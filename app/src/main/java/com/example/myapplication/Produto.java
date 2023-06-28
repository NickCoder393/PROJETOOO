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

    protected int getIdProduto() {
     return idProduto;
    }

    protected void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    protected String getNomeProduto() {
        return nomeProduto;
    }

    protected void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    protected String getNomeVendedor() {
        return nomeVendedor;
    }

    protected void setNomeVendedor(String nomeVendedor) {
        this.nomeVendedor = nomeVendedor;
    }

    protected int getQuantidade() {
        return quantidade;
    }

    protected void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    protected String getInformacoes() {
        return informacoes;
    }

    protected void setInformacoes(String informacoes) {
        this.informacoes = informacoes;
    }

    protected int getValor() {
        return valor;
    }

    protected void setValor(int valor) {
        this.valor = valor;
    }
}
