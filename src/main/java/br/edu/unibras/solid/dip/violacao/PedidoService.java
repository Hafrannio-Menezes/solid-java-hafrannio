package br.edu.unibras.solid.dip.violacao;

// o service cria o EmailNotificador direto, fica preso no email
// pra trocar por sms ou testar tem que mexer aqui
public class PedidoService {
    private final EmailNotificador notificador = new EmailNotificador();

    public void fecharPedido() { notificador.enviarEmail("Pedido Confirmado!"); }

    public EmailNotificador getNotificador() { return notificador; }
}
