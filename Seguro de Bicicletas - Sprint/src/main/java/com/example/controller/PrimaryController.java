package com.example.controller;

import java.io.IOException;

import com.example.data.LoginDao;
import com.example.model.Usuario;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PrimaryController {

    @FXML TextField txtEmail;
    @FXML PasswordField txtSenha;
    @FXML Button btnLogin;
    @FXML Button btnCadastrar;

    private LoginDao loginDao = new LoginDao();
    private Usuario usuarioLogado;

    @FXML
    void cadastrarButtonClicked(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/cadastro_user.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Cadastro de Usuario");
            stage.setScene(new Scene(root, 655, 411));
            stage.show();

            Stage currentStage = (Stage) btnCadastrar.getScene().getWindow();
            currentStage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void loginButtonClicked(ActionEvent event) {
        String email = txtEmail.getText();
        String senha = txtSenha.getText();

        usuarioLogado = loginDao.logar(email, senha);

        if (usuarioLogado != null) {
            abrirTelaInicial();
        } else {
            mostrarMensagem(AlertType.ERROR, "Erro de Login", "Email ou senha inválidos");
        }
    }

    private void abrirTelaInicial() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/tela_inicial.fxml"));
            Parent root = loader.load();

            TelaInicialController telaInicialController = loader.getController();
            
            telaInicialController.setCPFDoUsuario(usuarioLogado.getCpf());
            
            Stage stage = new Stage();
            stage.setTitle("Seguro de bicicleta");
            stage.setScene(new Scene(root, 439, 215));
            stage.show();
            
            Stage currentStage = (Stage) btnLogin.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void mostrarMensagem(AlertType tipo, String titulo, String mensagem ){
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(titulo);
        alerta.setContentText(mensagem);
        alerta.show();
    }

}
