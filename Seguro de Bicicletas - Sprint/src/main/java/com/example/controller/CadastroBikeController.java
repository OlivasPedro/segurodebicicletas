package com.example.controller;

import java.io.IOException;
import java.util.Optional;

import com.example.data.BicicletaDao;
import com.example.model.Bicicleta;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CadastroBikeController {

    private String cpfDoUsuario;

    @FXML
    private TextField txtMarca;
    @FXML
    private TextField txtAno;
    @FXML
    private TextField txtTamanho;
    @FXML
    private TextField txtNumeroSerie;
    @FXML
    private TextField txtModelo;
    @FXML
    private TextField txtValor;
    @FXML
    private TextField txtModificacao;
    @FXML
    private TextField txtValorModificacao;
    @FXML
    private TextField txtSinistro;
    @FXML
    private DatePicker dtSinistro;
    @FXML
    private Button btnCadastrarBike;

    private BicicletaDao bicicletaDao = new BicicletaDao();

    @FXML
    private void cadastrarBicicletaButtonClicked(ActionEvent event) {
        Bicicleta bicicleta = new Bicicleta();
        bicicleta.setMarca(txtMarca.getText());
        bicicleta.setAno(Integer.parseInt(txtAno.getText()));
        bicicleta.setTamanho(txtTamanho.getText());
        bicicleta.setNumeroSerie(txtNumeroSerie.getText());
        bicicleta.setModelo(txtModelo.getText());
        bicicleta.setValor(Double.parseDouble(txtValor.getText()));
        bicicleta.setModificacao(txtModificacao.getText());
        bicicleta.setValorModificacao(Double.parseDouble(txtValorModificacao.getText()));
        bicicleta.setSinistro(txtSinistro.getText());
        bicicleta.setDataSinistro(dtSinistro.getValue());

        bicicletaDao.cadastrarBicicleta(bicicleta, cpfDoUsuario);

        mostrarMensagem(AlertType.CONFIRMATION, "Sucesso!", "Bicicleta inserida com sucesso!");
        limparCampos();
    }

    private void limparCampos() {
        txtMarca.clear();
        txtAno.clear();
        txtTamanho.clear();
        txtNumeroSerie.clear();
        txtModelo.clear();
        txtValor.clear();
        txtModificacao.clear();
        txtValorModificacao.clear();
        txtSinistro.clear();
        dtSinistro.getEditor().clear();
    }

    public void setCPFDoUsuario(String cpf) {
        this.cpfDoUsuario = cpf;
    }

    private void mostrarMensagem(AlertType tipo, String titulo, String mensagem) {
        Alert alerta = new Alert(AlertType.CONFIRMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(titulo);
        alerta.setContentText(mensagem);
        ButtonType adicionarOutraBike = new ButtonType("Adicionar outra bike");
        ButtonType voltar = new ButtonType("Inicio");

        DialogPane dialogPane = alerta.getDialogPane();
        dialogPane.getButtonTypes().clear();
        dialogPane.getButtonTypes().addAll(adicionarOutraBike, voltar);
        Optional<ButtonType> result = alerta.showAndWait();

        if (result.isPresent()) {
            if (result.get() == adicionarOutraBike) {
                alerta.close();
            } else if (result.get() == voltar) {
                abrirTelaInicial();
            }
            
        }
    }

    @FXML
    private void abrirTelaInicial() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/tela_inicial.fxml"));
            Parent root = loader.load();

            TelaInicialController telaInicialController = loader.getController();

            telaInicialController.setCPFDoUsuario(cpfDoUsuario);

            Stage stage = new Stage();
            stage.setTitle("Inicio");
            stage.setScene(new Scene(root, 439, 215));
            stage.show();

            Stage currentStage = (Stage) btnCadastrarBike.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
