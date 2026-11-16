package br.edu.unibras.solid.srp;

import br.edu.unibras.solid.srp.refatorado.CalculadoraSalario;
import br.edu.unibras.solid.srp.refatorado.Funcionario;
import br.edu.unibras.solid.srp.refatorado.FuncionarioRepository;
import br.edu.unibras.solid.srp.refatorado.RelatorioFuncionario;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SrpTest {

    @AfterEach
    void limpar() { br.edu.unibras.solid.srp.violacao.Funcionario.limparBanco(); }

    @Test
    @DisplayName("violacao: calculo e persistencia na mesma classe")
    void violacaoMisturaResponsabilidades() {
        var f = new br.edu.unibras.solid.srp.violacao.Funcionario("Ana", 5000.0);
        Assertions.assertEquals(4000.0, f.calcularLiquido(), 0.001);
        f.salvar();
        Assertions.assertEquals(1, br.edu.unibras.solid.srp.violacao.Funcionario.registrosSalvos().size());
    }

    @Test
    void deveCalcularSalarioCorretamente() {
        Funcionario f = new Funcionario("Ana", 5000.0);
        CalculadoraSalario calc = new CalculadoraSalario();
        Assertions.assertEquals(4000.0, calc.calcularLiquido(f), 0.001);
    }

    @Test
    void repositorioPersisteIndependenteDoCalculo() {
        FuncionarioRepository repo = new FuncionarioRepository();
        repo.salvar(new Funcionario("Bruno", 3000.0));
        Assertions.assertEquals("Bruno", repo.listar().get(0).getNome());
    }

    @Test
    void relatorioUsaCalculadora() {
        String r = new RelatorioFuncionario(new CalculadoraSalario()).gerar(new Funcionario("Ana", 5000.0));
        Assertions.assertEquals("Funcionário: Ana | Líquido: 4000.0", r);
    }
}
