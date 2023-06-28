
package com.example.myapplication;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;


public class AcessoBD extends SQLiteOpenHelper {

    protected static final String TABELA_PRODUTO = "TABELA_PRODUTO";
    protected static final String PRODUTO_ID = "ID";
    protected static final String PRODUTO_NOME = "PRODUTO_NOME";
    protected static final String VENDEDOR_NOME = "VENDEDOR_NOME";
    protected static final String PRODUTO_VALOR = "PRODUTO_VALOR";
    protected static final String PRODUTO_QUANTIDADE = "PRODUTO_QUANTIDADE";
    protected static final String PRODUTO_INFORMACOES = "PRODUTO_INFORMACOES";


    public AcessoBD(@Nullable Context context) {super(context, "ClienteBD", null, 1);}
    
    @Override
    public void onCreate(SQLiteDatabase db) {
        String statement = "CREATE TABLE " + TABELA_PRODUTO +
                " (" + PRODUTO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + PRODUTO_NOME + " TEXT, " + PRODUTO_INFORMACOES + " TEXT, " + VENDEDOR_NOME + " TEXT, "
                + PRODUTO_VALOR + " INTEGER, " + PRODUTO_QUANTIDADE + " INTEGER)";
        db.execSQL(statement);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean adicionarProduto(Produto produto) {
        SQLiteDatabase db = this.getWritableDatabase();


        ContentValues contentValues = new ContentValues();
        contentValues.put(PRODUTO_NOME, produto.getNomeProduto());
        contentValues.put(VENDEDOR_NOME, produto.getNomeVendedor());
        contentValues.put(PRODUTO_VALOR, produto.getValor());
        contentValues.put(PRODUTO_QUANTIDADE, produto.getQuantidade());
        contentValues.put(PRODUTO_INFORMACOES, produto.getInformacoes());

        long inserirSucedido = db.insert(TABELA_PRODUTO, null, contentValues);
        db.close();

        return inserirSucedido != -1;
    }

    public boolean atualizarProduto(Produto produto) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(PRODUTO_NOME, produto.getNomeProduto());
        contentValues.put(VENDEDOR_NOME, produto.getNomeVendedor());
        contentValues.put(PRODUTO_VALOR, produto.getValor());
        contentValues.put(PRODUTO_QUANTIDADE, produto.getQuantidade());
        contentValues.put(PRODUTO_INFORMACOES, produto.getInformacoes());


        long atualizarSucedido = db.update(TABELA_PRODUTO, contentValues, PRODUTO_ID + "=" + produto.getIdProduto(), null);
        db.close();


        return atualizarSucedido != -1;

    }

    /**
     * Método para retornar a lista de usuarios completa.
     * Cria uma lista (listaUsuarios) vazia para preenchimento com as tuplas resultantes da consulta no banco de dados.
     *
     * @return List de objetos Usuario
     */
    public List<Produto> getListaProdutos() {

        List<Produto> listaProdutos = new ArrayList<>();


        String queryStatement = "SELECT * FROM " + TABELA_PRODUTO;

        SQLiteDatabase db = this.getReadableDatabase();



        try (Cursor cursor = db.rawQuery(queryStatement, null)) {




            if (cursor.moveToFirst()) {

                do {
                    int quantidade = cursor.getInt(3);
                    String nomeProduto = cursor.getString(1);
                    int valor = cursor.getInt(2);
                    String nomeVendedor = cursor.getString(0);
                    String informacoes = cursor.getString(4);




                    Produto produto = new Produto(nomeProduto, nomeVendedor, quantidade, informacoes, valor);
                    listaProdutos.add(produto);
                } while (cursor.moveToNext());
            } else {

            }



            cursor.close();
        }
        db.close();

        return listaProdutos;
    }


    /**
     * Método para encontrar um usuário no banco de dados e excluí-lo.
     *
     * @param
     * @return true no caso do usuário ser encontrado e excluído
     */
    public boolean excluirProduto(Produto produto) {
        SQLiteDatabase db = this.getWritableDatabase();
        String queryString =
                "DELETE FROM " + TABELA_PRODUTO + " WHERE " + PRODUTO_ID + " = " + produto.getIdProduto();

        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {
            return true;
        } else {
            return false;
        }

    }
}
