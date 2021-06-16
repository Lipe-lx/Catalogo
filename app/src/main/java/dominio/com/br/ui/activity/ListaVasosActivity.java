package dominio.com.br.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import dominio.com.br.R;
import dominio.com.br.dao.VasoDAO;

public class ListaVasosActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Catálogo de Vasos";
    private final VasoDAO dao = new VasoDAO();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        imprimeToastEntrada();
        setTitle(TITULO_APPBAR); //Titulo da appbar
        configuraFabNovoVaso();
    }

    private void imprimeToastEntrada() {
        Toast.makeText(this, "Bem vindo ao Atelier Graça Lima!", Toast.LENGTH_LONG).show(); // aparece o texto e desaparece na tela, LONG desaparece devagar e SHORT desaparece rapido
        setContentView(R.layout.activity_lista_vasos); // Classe R - Mapeia todos os resources, nesse caso pega o layout estatico dentro de res e coloca como view da activity
    }

    private void configuraFabNovoVaso() {
        FloatingActionButton botaoNovoVaso = findViewById(R.id.activity_lista_vasos_fab_novo_vaso);
        botaoNovoVaso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abreFormularioVasoActivity(); // Cria um intent que vem de ListaVasosActivity e vai para FormularioVasosActivity
            }
        });
    }

    private void abreFormularioVasoActivity() {
        startActivity(new Intent(this, FormularioVasosActivity.class));
    }

    @Override
    protected void onResume() { // onResume ideal para manter os dados na lista - Verificar o ciclo de vida da Activity na documentação.
        super.onResume();
        configuraLista();
    }

    private void configuraLista() {
        ListView listaDeVasos = findViewById(R.id.activity_lista_de_vasos_listview); // Busca no layout a lista
        listaDeVasos.setAdapter(new ArrayAdapter<>( // Responsavel em pegar os dados e renderizar com uma view desejada, no caso uma view do android padrão ja existente, por isso do "this"
                this,
                android.R.layout.simple_list_item_1,
                dao.todos()));
    }

    //  FORMA DE INSERIR DADOS DE TEXTO MANUAL
//        TextView primeiroVaso = findViewById(R.id.textView2);//Pega uma view no layout de acordo com seu ID
//        TextView segundoVaso = findViewById(R.id.textView3);//Pega uma view no layout de acordo com seu ID
//        TextView terceiroVaso = findViewById(R.id.textView4);//Pega uma view no layout de acordo com seu ID
//        primeiroVaso.setText(vasos.get(0));
//        segundoVaso.setText(vasos.get(1));
//        terceiroVaso.setText(vasos.get(2));
}

