package br.edu.unibras.solid.ocp;

import br.edu.unibras.solid.ocp.refatorado.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DescontoTest {

    @Test
    void violacaoNaoConheceTipoNovoSemSerModificada() {
        var calc = new br.edu.unibras.solid.ocp.violacao.CalculadoraDesconto();
        Assertions.assertEquals(85.0, calc.calcular("VIP", 100.0), 0.001);
        Assertions.assertThrows(IllegalArgumentException.class, () -> calc.calcular("BLACK_FRIDAY", 100.0));
    }

    @Test
    void testDescontoVip() {
        DescontoService d = new DescontoVip();
        Assertions.assertEquals(85.0, d.calcular(100.0), 0.001);
    }

    @Test
    void descontosExistentesMantemComportamento() {
        Assertions.assertEquals(100.0, new SemDesconto().calcular(100.0), 0.001);
        Assertions.assertEquals(70.0, new DescontoFuncionario().calcular(100.0), 0.001);
    }

    @Test
    void novaRegraEntraPorExtensaoSemAlterarCaixa() {
        Caixa caixa = new Caixa(new DescontoBlackFriday());
        Assertions.assertEquals(50.0, caixa.fecharCompra(100.0), 0.001);
        Caixa caixaLambda = new Caixa(v -> v - 10); // da pra usar lambda tbm
        Assertions.assertEquals(90.0, caixaLambda.fecharCompra(100.0), 0.001);
    }
}
