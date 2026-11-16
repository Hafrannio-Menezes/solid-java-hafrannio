package br.edu.unibras.solid.isp.violacao;

// robo nao come mas e obrigado a implementar comer()
public class Robo implements Trabalhador {
    public void trabalhar() { System.out.println("Robô operando..."); }

    public void comer() {
        throw new UnsupportedOperationException("Robô não come");
    }
}
