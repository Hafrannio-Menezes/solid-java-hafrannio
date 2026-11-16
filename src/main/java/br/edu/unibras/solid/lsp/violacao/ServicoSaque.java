package br.edu.unibras.solid.lsp.violacao;

public class ServicoSaque {
    public void sacarDeTodas(Iterable<ContaBancaria> contas, double valor) {
        for (ContaBancaria c : contas) c.sacar(valor);
    }
}
