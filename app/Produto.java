package com.example.myapplication;



public class Produto {

    public Produto(){

    }
    public Produto(int idProduto,String nomeProduto,String nomeVendedor,int quantidade,String informacoes, int valor){
        this.setIdProduto(idProduto);
        this.setNomeVendedor(nomeVendedor);
        this.setNomeProduto(nomeProduto);
        this.setQuantidade(quantidade);
        this.setInformacoes(informacoes);
        this.setValor(valor);
    }
    public Produto(String nomeProduto,String nomeVendedor,int quantidade,String informacoes, int valor){
        this.nomeProduto=nomeProduto;
        this.nomeVendedor=nomeVendedor;
        this.quantidade=quantidade;
        this.informacoes=informacoes;
        this.valor=valor;


    }
    @Override
    public String toString() {
        return "Produtos{" + "idProduto=" + idProduto + ", nomeProduto='" + nomeProduto + '\'' + ", Valor=" + valor + "Nome Vendendor=" +nomeVendedor + "quantidade" + quantidade +"Informações" + informacoes +'}';

    }


    private int idProduto;
    private String nomeProduto;
    private String nomeVendedor;
    private int quantidade;
    private String informacoes;
    private int valor;

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getNomeVendedor() {
        return nomeVendedor;
    }

    public void setNomeVendedor(String nomeVendedor) {
        this.nomeVendedor = nomeVendedor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getInformacoes() {
        return informacoes;
    }

    public void setInformacoes(String informacoes) {
        this.informacoes = informacoes;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
