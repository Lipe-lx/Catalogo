package dominio.com.br.dao;

import java.util.ArrayList;
import java.util.List;

import dominio.com.br.model.Vaso;

public class VasoDAO {

   private final static List<Vaso> vasos = new ArrayList<>(); //solução estatica mais objetiva e simples, poderia utilizar um banco de dados mais pro caso deste modo e melhor

    public void salva(Vaso vaso) {
        vasos.add(vaso);
    } // salva um vaso e adiciona na lista

    public List<Vaso> todos() {
        return new ArrayList<>(vasos); // Faz uma copia da lista estatica onde quem modifica externamente nao modifica internamente. Para nao perder o encapsulamento
    }
}
