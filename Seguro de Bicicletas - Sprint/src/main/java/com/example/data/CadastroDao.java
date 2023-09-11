package com.example.data;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.example.model.Usuario;

public class CadastroDao {
     
    private final String USER = "RM550165";
    private final String PASS = "060605";
    private static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";

    public boolean cadastrarUsuario(Usuario usuario) {
        String sql = "INSERT INTO tpm_usuario (nome, data_nascimento, telefone, cep, cpf, email, senha) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (
            var conexao = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement statement = conexao.prepareStatement(sql);
        ) {
            statement.setString(1, usuario.getNome());
            statement.setDate(2, java.sql.Date.valueOf(usuario.getDataNascimento()));
            statement.setString(3, usuario.getCelular());
            statement.setString(4, usuario.getCep());
            statement.setString(5, usuario.getCpf());
            statement.setString(6, usuario.getEmail());
            statement.setString(7, usuario.getSenha());

            int rowsAffected = statement.executeUpdate();

            conexao.close();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
