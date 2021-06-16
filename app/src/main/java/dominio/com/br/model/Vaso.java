package dominio.com.br.model;

import androidx.annotation.NonNull;

public class Vaso {
    private final String nome;
    private final String dimensao;
    private final String custo;
    private final String venda;

    public Vaso(String nome, String dimensao, String custo, String venda) { //Recebe os valores via construtor

        this.nome = nome;
        this.dimensao = dimensao;
        this.custo = custo;
        this.venda = venda;
    }

    @NonNull
    @Override
    public String toString() {
        return nome;
    }
}
