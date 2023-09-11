package com.example.model;

import java.time.LocalDate;

public class Bicicleta {
    private String marca;
    private int ano;
    private String tamanho;
    private String numeroSerie;
    private String modelo;
    private double valor;
    private String modificacao;
    private double valorModificacao;
    private String sinistro;
    private LocalDate dataSinistro;
    
    public Bicicleta(){}

    public Bicicleta(String marca, int ano, String tamanho, String numeroSerie, String modelo, double valor,
            String modificacao, double valorModificacao, String sinistro, LocalDate dataSinistro) {
        this.marca = marca;
        this.ano = ano;
        this.tamanho = tamanho;
        this.numeroSerie = numeroSerie;
        this.modelo = modelo;
        this.valor = valor;
        this.modificacao = modificacao;
        this.valorModificacao = valorModificacao;
        this.sinistro = sinistro;
        this.dataSinistro = dataSinistro;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }
    public String getTamanho() {
        return tamanho;
    }
    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }
    public String getNumeroSerie() {
        return numeroSerie;
    }
    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public String getModificacao() {
        return modificacao;
    }
    public void setModificacao(String modificacao) {
        this.modificacao = modificacao;
    }
    public double getValorModificacao() {
        return valorModificacao;
    }
    public void setValorModificacao(double valorModificacao) {
        this.valorModificacao = valorModificacao;
    }
    public String getSinistro() {
        return sinistro;
    }
    public void setSinistro(String sinistro) {
        this.sinistro = sinistro;
    }
    public LocalDate getDataSinistro() {
        return dataSinistro;
    }
    public void setDataSinistro(LocalDate dataSinistro) {
        this.dataSinistro = dataSinistro;
    }

    @Override
    public String toString() {
        return "Marca: " + marca + " | " 
            + "Ano: " + ano + " | " 
            + "Tamanho: " + tamanho + " | " 
            + "Numero de Serie: " + numeroSerie + " | " 
            + "Modelo: " + modelo + " | " 
            + "Valor: R$" + valor;
    }
    
}
