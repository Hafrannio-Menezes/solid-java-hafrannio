package br.edu.unibras.solid.dip.refatorado;

public class EmailNotificador implements Notificador {
    public void enviar(String msg) { System.out.println("E-mail: " + msg); }
}
