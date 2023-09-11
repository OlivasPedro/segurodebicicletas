package com.example.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.model.Usuario;

public class LoginDao {
    
    private final String USER = "RM550165";
    private final String PASS = "060605";
    private static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";

    public Usuario logar(String email, String senha) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASS);
            String query = "SELECT * FROM tpm_usuario WHERE email = ? AND senha = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, senha);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String senha2 = resultSet.getString("senha");
                String cpf = resultSet.getString("cpf");

                return new Usuario(nome,senha2,cpf);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
