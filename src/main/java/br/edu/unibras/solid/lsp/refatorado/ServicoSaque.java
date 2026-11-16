package br.edu.unibras.solid.lsp.refatorado;

// so aceita conta que da pra sacar
public class ServicoSaque {
    public void sacarDeTodas(Iterable<? extends ContaSacavel> contas, double valor) {
        for (ContaSacavel c : contas) c.sacar(valor);
    }
}
