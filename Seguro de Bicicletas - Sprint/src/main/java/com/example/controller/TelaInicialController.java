package com.example.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class TelaInicialController {

    private String cpfDoUsuario;

    public String getCpfDoUsuario() {
        return cpfDoUsuario;
    }

    @FXML
    Button btnCadastrarBikes;
    @FXML
    Button btnVerBikes;

    @FXML
    void cadastrarBikeButtonClicked(ActionEvent event) {
        mudaTela("/com/example/cadastro_bike.fxml", 542,468, btnVerBikes, "Cadastro de bicicleta");
    }

    @FXML
    void verButtonClicked(ActionEvent event) {
        mudaTela("/com/example/visualizacao_bikes.fxml", 710, 405, btnVerBikes, "Suas bicicletas");
    }

    public void setCPFDoUsuario(String cpf) {
        this.cpfDoUsuario = cpf;
    }

    private void mudaTela(String endereco, double altura, double largura, Button botao, String titulo) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(endereco));
            Parent root = loader.load();
    
            if (titulo.equals("Cadastro de bicicleta")) {
                CadastroBikeController controller = loader.getController();
                controller.setCPFDoUsuario(cpfDoUsuario);
            } else if (titulo.equals("Suas bicicletas")) {
                VisualizacaoBikesController controller = loader.getController();
                controller.setCPFDoUsuario(cpfDoUsuario);
            }
    
            Stage stage = new Stage();
            stage.setTitle(titulo);
            stage.setScene(new Scene(root, altura, largura));
            stage.show();
    
            Stage currentStage = (Stage) botao.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    


}
