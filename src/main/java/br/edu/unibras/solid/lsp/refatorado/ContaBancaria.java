package br.edu.unibras.solid.lsp.refatorado;

// so o que toda conta consegue fazer
public interface ContaBancaria {
    void depositar(double v);
    double getSaldo();
}
