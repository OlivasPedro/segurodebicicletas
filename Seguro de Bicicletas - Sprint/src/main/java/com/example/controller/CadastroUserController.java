package com.example.controller;

import com.example.data.CadastroDao;
import com.example.model.Usuario;
import com.example.util.Util;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class CadastroUserController {

    @FXML
    private TextField txtNomeCadastro;
    @FXML
    private DatePicker dtNascimento;
    @FXML
    private TextField txtCelular;
    @FXML
    private TextField txtCep;
    @FXML
    private TextField txtCpf;
    @FXML
    private TextField txtEmail;
    @FXML
    private PasswordField txtSenhaCadastro;

    @FXML
    private Button btnCadastrarUsuario;

    @FXML private Button btn_voltar;

    private CadastroDao user = new CadastroDao();

    @FXML
    void cadastrarButtonClicked(ActionEvent event) {
        if (camposObrigatoriosPreenchidos() && validarCampos()) {
            user.cadastrarUsuario(new Usuario(txtNomeCadastro.getText(),
                                                dtNascimento.getValue(),
                                                txtCelular.getText(),
                                                txtCep.getText(),
                                                txtCpf.getText(),
                                                txtEmail.getText(),
                                                txtSenhaCadastro.getText()));
            exibirMensagem(AlertType.INFORMATION,
                                "Aviso",
                                "Cadastro de Usuario",
                                "Usuario cadastrado com sucesso!");
            Util.mostrarTela("/com/example/primary.fxml", 655, 411, btnCadastrarUsuario);
        } else {
            exibirMensagem(AlertType.ERROR, "ERRO.",
                    "Campos obrigatórios não preenchidos ou inválidos",
                    "Por favor, preencha todos os campos obrigatórios e verifique os dados inseridos.");
        }
    }

    @FXML
    void voltar(ActionEvent event){
        Util.mostrarTela("/com/example/primary.fxml", 655, 411, btnCadastrarUsuario);
    }

    private boolean camposObrigatoriosPreenchidos() {
        return !txtNomeCadastro.getText().isEmpty() &&
                dtNascimento.getValue() != null &&
                !txtCelular.getText().isEmpty() &&
                !txtCep.getText().isEmpty() &&
                !txtCpf.getText().isEmpty() &&
                !txtEmail.getText().isEmpty() &&
                !txtSenhaCadastro.getText().isEmpty();
    }

    private boolean validarCampos() {
        return isValidCpf(txtCpf.getText().trim()) &&
                validarCep(txtCep.getText().trim()) &&
                validarCelular(txtCelular.getText().trim());
    }

    private boolean isValidCpf(String cpf) {
        cpf = cpf.replaceAll("[^0-9]", "");

        if (cpf.length() != 11) {
            return false;
        }

        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        int[] digitos = new int[11];
        for (int i = 0; i < 11; i++) {
            digitos[i] = Integer.parseInt(cpf.substring(i, i + 1));
        }

        int soma1 = 0;
        for (int i = 0; i < 9; i++) {
            soma1 += digitos[i] * (10 - i);
        }

        int resto1 = soma1 % 11;
        int digitoVerificador1 = (resto1 < 2) ? 0 : (11 - resto1);

        int soma2 = 0;
        for (int i = 0; i < 10; i++) {
            soma2 += digitos[i] * (11 - i);
        }

        int resto2 = soma2 % 11;
        int digitoVerificador2 = (resto2 < 2) ? 0 : (11 - resto2);

        return (digitos[9] == digitoVerificador1) && (digitos[10] == digitoVerificador2);
    }

    private boolean validarCep(String cep) {
        return cep.matches("\\d{8}");
    }

    private boolean validarCelular(String celular) {
        return celular.matches("\\d{10,}");
    }

    private void exibirMensagem(AlertType tipo, String titulo, String header, String content) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
}