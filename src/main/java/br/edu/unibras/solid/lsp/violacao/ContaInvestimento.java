package br.edu.unibras.solid.lsp.violacao;

// herda sacar() mas nao consegue sacar de verdade, entao lanca excecao
// quem usa ContaBancaria esperando sacar vai quebrar com essa classe
public class ContaInvestimento extends ContaBancaria {
    @Override
    public void depositar(double v) { saldo += v * 1.02; } // rendimento aplicado

    @Override
    public void sacar(double v) {
        throw new UnsupportedOperationException("Conta investimento não permite saque");
    }
}
