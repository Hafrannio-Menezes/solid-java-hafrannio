package br.edu.unibras.solid.lsp.refatorado;

public class ContaCorrente implements ContaSacavel {
    private double saldo;

    public void depositar(double v) { saldo += v; }

    public void sacar(double v) {
        if (v > saldo) throw new IllegalArgumentException("Saldo insuficiente");
        saldo -= v;
    }

    public double getSaldo() { return saldo; }
}
