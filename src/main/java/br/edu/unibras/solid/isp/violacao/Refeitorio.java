package br.edu.unibras.solid.isp.violacao;

import java.util.List;

public class Refeitorio {
    public void servirAlmoco(List<Trabalhador> equipe) {
        for (Trabalhador t : equipe) t.comer();
    }
}
