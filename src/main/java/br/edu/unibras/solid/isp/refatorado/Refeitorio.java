package br.edu.unibras.solid.isp.refatorado;

import java.util.List;

// se tentar passar um Robo aqui nem compila
public class Refeitorio {
    public int servirAlmoco(List<? extends Alimentavel> pessoas) {
        pessoas.forEach(Alimentavel::comer);
        return pessoas.size();
    }
}
