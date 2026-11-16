package br.edu.unibras.solid.dip.refatorado;

// recebe o notificador pelo construtor (injecao de dependencia)
public class PedidoService {
    private final Notificador notificador;

    public PedidoService(Notificador n) { this.notificador = n; }

    public void fecharPedido() { notificador.enviar("Pedido Confirmado!"); }
}
