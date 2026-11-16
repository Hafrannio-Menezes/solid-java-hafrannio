package br.edu.unibras.solid.dip.violacao;

import java.util.ArrayList;
import java.util.List;

public class EmailNotificador {
    private final List<String> enviados = new ArrayList<>();

    public void enviarEmail(String msg) {
        enviados.add(msg);
        System.out.println("E-mail: " + msg);
    }

    public List<String> getEnviados() { return List.copyOf(enviados); }
}
