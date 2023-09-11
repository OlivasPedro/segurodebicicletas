package com.example.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Bicicleta;

public class BicicletaDao {

    private final String USER = "RM550165";
    private final String PASS = "060605";
    private static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";

    public void cadastrarBicicleta(Bicicleta bicicleta, String cpf) {
        String sql = "INSERT INTO tpm_bicicleta(marca, modelo, ano, tamanho, numero_de_serie, valor_bicicleta, cpf_proprietario) VALUES(?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, bicicleta.getMarca());
            preparedStatement.setString(2, bicicleta.getModelo());
            preparedStatement.setInt(3, bicicleta.getAno());
            preparedStatement.setString(4, bicicleta.getTamanho());
            preparedStatement.setString(5, bicicleta.getNumeroSerie());
            preparedStatement.setDouble(6, bicicleta.getValor());
            preparedStatement.setString(7, cpf);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Trate exceções ou lance-as para quem chama este método
        }
    }

    public List<Bicicleta> listarBicicletasPorCPF(String cpf) {
    List<Bicicleta> bicicletas = new ArrayList<>();
    String sql = "SELECT * FROM tpm_bicicleta WHERE cpf_proprietario = ?";

    try (Connection connection = DriverManager.getConnection(URL, USER, PASS);
         PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

        preparedStatement.setString(1, cpf);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Bicicleta bicicleta = new Bicicleta();
            bicicleta.setMarca(resultSet.getString("marca"));
            bicicleta.setModelo(resultSet.getString("modelo"));
            bicicleta.setAno(resultSet.getInt("ano"));
            bicicleta.setTamanho(resultSet.getString("tamanho"));
            bicicleta.setNumeroSerie(resultSet.getString("numero_de_serie"));
            bicicleta.setValor(resultSet.getDouble("valor_bicicleta"));
            bicicletas.add(bicicleta);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return bicicletas;
}
}
