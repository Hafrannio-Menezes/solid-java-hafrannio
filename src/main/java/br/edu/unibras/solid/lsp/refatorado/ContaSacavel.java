package br.edu.unibras.solid.lsp.refatorado;

// separei o saque numa interface propria
public interface ContaSacavel extends ContaBancaria {
    void sacar(double v);
}
