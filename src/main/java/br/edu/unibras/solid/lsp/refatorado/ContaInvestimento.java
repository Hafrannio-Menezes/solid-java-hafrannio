package br.edu.unibras.solid.lsp.refatorado;

// nao implementa ContaSacavel, entao nao tem como quebrar quem espera saque
public class ContaInvestimento implements ContaBancaria {
    private double saldo;

    public void depositar(double v) { saldo += v * 1.02; } // rendimento aplicado
    public double getSaldo() { return saldo; }
}
