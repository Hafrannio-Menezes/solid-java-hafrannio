package br.edu.unibras.solid.ocp.refatorado;

public class DescontoFuncionario implements DescontoService {
    public double calcular(double v) { return v * 0.70; }
}
