package br.edu.unibras.solid.ocp.violacao;

// problema: todo tipo novo de cliente precisa de mais um if aqui dentro
public class CalculadoraDesconto {
    public double calcular(String tipoCliente, double valor) {
        if ("COMUM".equals(tipoCliente)) return valor;
        if ("VIP".equals(tipoCliente)) return valor * 0.85;
        if ("FUNCIONARIO".equals(tipoCliente)) return valor * 0.70;
        throw new IllegalArgumentException("Tipo de cliente desconhecido: " + tipoCliente);
    }
}
