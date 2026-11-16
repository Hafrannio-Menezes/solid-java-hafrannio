package br.edu.unibras.solid.ocp.refatorado;

// adicionei depois sem mexer em nenhuma outra classe
public class DescontoBlackFriday implements DescontoService {
    public double calcular(double v) { return v * 0.50; }
}
