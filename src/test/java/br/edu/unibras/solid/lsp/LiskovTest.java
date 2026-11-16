package br.edu.unibras.solid.lsp;

import br.edu.unibras.solid.lsp.refatorado.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class LiskovTest {

    @Test
    void violacaoSubclasseQuebraClienteDaBase() {
        var corrente = new br.edu.unibras.solid.lsp.violacao.ContaBancaria();
        var investimento = new br.edu.unibras.solid.lsp.violacao.ContaInvestimento();
        corrente.depositar(100);
        investimento.depositar(100);
        var servico = new br.edu.unibras.solid.lsp.violacao.ServicoSaque();
        Assertions.assertThrows(UnsupportedOperationException.class,
                () -> servico.sacarDeTodas(List.of(corrente, investimento), 10));
    }

    @Test
    void testSubstituicao() {
        ContaBancaria conta = new ContaInvestimento();
        conta.depositar(100.0);
        Assertions.assertEquals(102.0, conta.getSaldo(), 0.001);
    }

    @Test
    void qualquerContaBancariaHonraDepositoESaldo() {
        for (ContaBancaria c : List.<ContaBancaria>of(new ContaCorrente(), new ContaInvestimento())) {
            double antes = c.getSaldo();
            c.depositar(50.0);
            Assertions.assertTrue(c.getSaldo() >= antes + 50.0);
        }
    }

    @Test
    void servicoDeSaqueSoRecebeContasSacaveis() {
        ContaCorrente a = new ContaCorrente();
        ContaCorrente b = new ContaCorrente();
        a.depositar(100);
        b.depositar(30);
        new ServicoSaque().sacarDeTodas(List.of(a, b), 20);
        Assertions.assertEquals(80.0, a.getSaldo(), 0.001);
        Assertions.assertEquals(10.0, b.getSaldo(), 0.001);
    }
}
