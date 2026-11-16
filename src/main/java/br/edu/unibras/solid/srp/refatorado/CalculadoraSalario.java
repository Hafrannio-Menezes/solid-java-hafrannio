package br.edu.unibras.solid.srp.refatorado;

// so o calculo do liquido (20% de desconto)
public class CalculadoraSalario {
    public double calcularLiquido(Funcionario f) {
        return f.getSalarioBruto() * 0.8;
    }
}
