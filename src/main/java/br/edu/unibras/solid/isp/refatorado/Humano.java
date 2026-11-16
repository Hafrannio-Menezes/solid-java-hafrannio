package br.edu.unibras.solid.isp.refatorado;

public class Humano implements Trabalhador, Alimentavel {
    public void trabalhar() { System.out.println("Humano trabalhando..."); }
    public void comer() { System.out.println("Humano almoçando..."); }
}
