package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.AcessoBD;
import com.example.myapplication.R;
import com.example.myapplication.Produto;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;

import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText edtProduto;
    EditText edtVendedor;
    EditText edtQuantidade;
    EditText edtValor;
    ArrayAdapter produtoArrayAdapter;
    EditText edtInformacoes;
    Button btAddProdutos;
    AcessoBD acessoBD;
    ListView lvUsuarios;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtProduto=findViewById(R.id.edtProduto);
        edtVendedor=findViewById(R.id.edtVendedor);
        edtQuantidade=findViewById(R.id.edtQuantidade);
        edtValor=findViewById(R.id.edtValor);
        edtInformacoes=findViewById(R.id.edtInformacoes);
        btAddProdutos=findViewById(R.id.btAddProduto);
        lvUsuarios = findViewById(R.id.lv_usuarios);

        acessoBD = new AcessoBD(MainActivity.this);
        mostrarProdutosNaListView(acessoBD);

        btAddProdutos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //aqui acontece a ação


                //Declaração de um objeto usuário da (nossa) classe Usuário
                Produto produto = null;//null para inicializar

                //nomeProduto, nomeVendedor, quantidade, informacoes, valorBloco try para "tentar" executar as ações esperadas. O catch é para "remediar" ou "avisar" algo que não foi realizado no bloco try como esperado.
                try {
                    produto = new Produto(-1,
                            edtProduto.getText().toString(),
                            edtVendedor.getText().toString(),
                            Integer.parseInt(edtQuantidade.getText().toString()),
                            edtInformacoes.getText().toString(),
                            Integer.parseInt(edtValor.getText().toString()));

                    boolean sucesso = acessoBD.adicionarProduto(produto);

                    mostrarProdutosNaListView(acessoBD);
                    Toast.makeText(MainActivity.this, "Sucesso:" + sucesso, Toast.LENGTH_SHORT).show();

                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Erro na conversão de uma String para int: Idade não corresponde a número!", Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Erro na criação do usuário!", Toast.LENGTH_LONG).show();
                    //produto=new Produto(-1,"erro", 0);
                }


            }
        });


        /**
         * Evento de click na lista de usuários na intenção de excluir o usuário clicado.
             */
            lvUsuarios.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    System.out.println("Captou click na lista!");
                    Produto produtoClicado = (Produto) parent.getItemAtPosition(position);
                    boolean excluiu = acessoBD.excluirProduto(produtoClicado);

                    mostrarProdutosNaListView(acessoBD);

                    Toast.makeText(MainActivity.this, "Usuário excluído(" + excluiu + "):" + produtoClicado.toString(), Toast.LENGTH_SHORT).show();


                }
            });

        }

        private void mostrarProdutosNaListView(AcessoBD acessoBD) {
            produtoArrayAdapter = new ArrayAdapter<Produto>(MainActivity.this,
                    android.R.layout.simple_list_item_1, acessoBD.getListaProdutos());//Dentro de <> está o tipo de objeto que será adicionado na lista
            lvUsuarios.setAdapter(produtoArrayAdapter);
        }


    }
