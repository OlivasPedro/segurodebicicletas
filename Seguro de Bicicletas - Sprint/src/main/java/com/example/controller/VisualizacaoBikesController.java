package com.example.controller;

import java.io.IOException;
import java.util.List;

import com.example.data.BicicletaDao;
import com.example.model.Bicicleta;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class VisualizacaoBikesController {

    private String cpfDoUsuario;

    private BicicletaDao bicicletaDao = new BicicletaDao();

    @FXML private ListView<String> lvbikes;
    @FXML Button btnVoltar;

    public void initialize() {
        mostraLista();
    }

    public void mostraLista() {
        String cpf = cpfDoUsuario;

        List<Bicicleta> bicicletas = bicicletaDao.listarBicicletasPorCPF(cpf);

        for (Bicicleta bicicleta : bicicletas) {
            lvbikes.getItems().add(bicicleta.toString());
        }
    }

    public void setCPFDoUsuario(String cpf) {
        this.cpfDoUsuario = cpf;
        initialize();
    }

    @FXML
    private void voltar() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/tela_inicial.fxml"));
            Parent root = loader.load();
            
            TelaInicialController telaInicialController = loader.getController();
            
            telaInicialController.setCPFDoUsuario(cpfDoUsuario);
            
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 439, 215));
            stage.show();
            
            Stage currentStage = (Stage) btnVoltar.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
