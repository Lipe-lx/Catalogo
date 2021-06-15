package dominio.com.br;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(this, "Bem vindo ao Atelier Graça Lima!", Toast.LENGTH_LONG).show(); // aparece o texto e desaparece na tela, LONG desaparece devagar e SHORT desaparece rapido
        setContentView(R.layout.activity_main); // Classe R - Mapeia todos os resources, nesse caso pega o layout estatico dentro de res e coloca como view da activity
        List<String> vasos = new ArrayList<>(
                Arrays.asList("Cone Médio", "Cone Grande", "Gota Médio", "Gota Grande", "Sino Grande", "Triangular Médio")); //Criação de um tipo lista sem banco de dados, lista dinamica
        ListView listaDeVasos = findViewById(R.id.activity_main_lista_de_vasos); // Busca no layout a lista
        listaDeVasos.setAdapter(new ArrayAdapter<>( // Responsavel em pegar os dados e renderizar com uma view desejada, no caso uma view do android padrão ja existente
                this,
                android.R.layout.simple_list_item_1,
                vasos));


//  FORMA DE INSERIR DADOS DE TEXTO MANUAL
//        TextView primeiroVaso = findViewById(R.id.textView2);//Pega uma view no layout de acordo com seu ID
//        TextView segundoVaso = findViewById(R.id.textView3);//Pega uma view no layout de acordo com seu ID
//        TextView terceiroVaso = findViewById(R.id.textView4);//Pega uma view no layout de acordo com seu ID
//        primeiroVaso.setText(vasos.get(0));
//        segundoVaso.setText(vasos.get(1));
//        terceiroVaso.setText(vasos.get(2));
    }
}
