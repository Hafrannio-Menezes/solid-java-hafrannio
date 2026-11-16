package br.edu.unibras.solid.dip;

import br.edu.unibras.solid.dip.refatorado.Notificador;
import br.edu.unibras.solid.dip.refatorado.PedidoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class PedidoServiceTest {

    @Test
    void violacaoSoPermiteEmailConcreto() {
        var service = new br.edu.unibras.solid.dip.violacao.PedidoService();
        service.fecharPedido();
        // nao da pra trocar o notificador, tem que olhar a classe concreta
        Assertions.assertEquals(List.of("Pedido Confirmado!"), service.getNotificador().getEnviados());
    }

    @Test
    void testFechamentoPedido() {
        Notificador mockNotificador = msg -> Assertions.assertEquals("Pedido Confirmado!", msg);
        PedidoService service = new PedidoService(mockNotificador);
        service.fecharPedido();
    }

    @Test
    void notificadorEhChamadoExatamenteUmaVez() {
        List<String> recebidas = new ArrayList<>();
        new PedidoService(recebidas::add).fecharPedido();
        Assertions.assertEquals(List.of("Pedido Confirmado!"), recebidas);
    }
}
