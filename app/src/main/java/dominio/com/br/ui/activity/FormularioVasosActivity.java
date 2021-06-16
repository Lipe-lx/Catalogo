package dominio.com.br.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import dominio.com.br.R;
import dominio.com.br.dao.VasoDAO;
import dominio.com.br.model.Vaso;

public class FormularioVasosActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Novo Vaso";
    private EditText campoNome;
    private EditText campoDimensao;
    private EditText campoCusto;
    private EditText campoVenda;
    private final VasoDAO dao = new VasoDAO();//Onde ficará as informações salvas - banco de dados

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_vasos);
        setTitle(TITULO_APPBAR); //Modifica o titulo da appBar
        inicializacaoDosCampos();
        configuraBotaoSalvar();
    }

    private void configuraBotaoSalvar() {
        Button botaoSalvar = findViewById(R.id.activity_formulario_vasos_botao_salvar); //Pegar a referencia do botão salvar
        botaoSalvar.setOnClickListener(new View.OnClickListener() { //Cria uma interface para verificar se teve um click
            @Override
            public void onClick(View v) { // Ao clicar ele executara oque tiver abaixo
                Toast.makeText(FormularioVasosActivity.this, // aparece o texto e depois desaparece
                        "Cadastro Salvo",
                        Toast.LENGTH_SHORT).show();
                Vaso vasoCriado = criaVaso();
                salva(vasoCriado);
            }
        });
    }

    private void inicializacaoDosCampos() {
        campoNome = findViewById(R.id.activity_formulario_vasos_nome); // Pega as informações inseridas de cada campo
        campoDimensao = findViewById(R.id.activity_formulario_vasos_dimensoes); // Pega as informações inseridas de cada campo
        campoCusto = findViewById(R.id.activity_formulario_vasos_custo); // Pega as informações inseridas de cada campo
        campoVenda = findViewById(R.id.activity_formulario_vasos_venda); // Pega as informações inseridas de cada campo
    }

    private void salva(Vaso vasoCriado) {
        dao.salva(vasoCriado);
        finish(); // Finalizar a activity de formularios para ela voltar a lista de alunos (Desempilhando activity)
    }

    @org.jetbrains.annotations.NotNull
    private Vaso criaVaso() {
        String nome = campoNome.getText().toString(); // Converte as informações em String
        String dimensao = campoDimensao.getText().toString(); // Converte as informações em String
        String custo = campoCusto.getText().toString(); // Converte as informações em String
        String venda = campoVenda.getText().toString(); // Converte as informações em String

        Vaso vasoCriado = new Vaso(nome, dimensao, custo, venda); //Criando vaso - pega as imformações inseridas
        return vasoCriado;
    }
}