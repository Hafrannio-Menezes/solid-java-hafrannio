package br.edu.unibras.solid.ocp.refatorado;

// o caixa nao sabe qual desconto ta usando, so chama calcular
public class Caixa {
    private final DescontoService desconto;

    public Caixa(DescontoService desconto) { this.desconto = desconto; }

    public double fecharCompra(double valor) { return desconto.calcular(valor); }
}
