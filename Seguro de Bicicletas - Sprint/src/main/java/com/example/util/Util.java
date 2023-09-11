package com.example.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Util {

    public static void mostrarTela(String endereco, double altura, double largura, Button botao) {
        FXMLLoader loader = new FXMLLoader(Util.class.getResource(endereco));
        Parent root;
        try {
            Stage currentStage = (Stage) botao.getScene().getWindow();
            currentStage.close();
            Stage stage = new Stage();
            root = loader.load();
            stage.setScene(new Scene(root, altura, largura));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

