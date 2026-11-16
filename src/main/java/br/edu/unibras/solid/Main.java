package br.edu.unibras.solid;

import br.edu.unibras.solid.dip.refatorado.EmailNotificador;
import br.edu.unibras.solid.dip.refatorado.PedidoService;
import br.edu.unibras.solid.dip.refatorado.SmsNotificador;
import br.edu.unibras.solid.isp.refatorado.Humano;
import br.edu.unibras.solid.isp.refatorado.Refeitorio;
import br.edu.unibras.solid.isp.refatorado.Robo;
import br.edu.unibras.solid.isp.refatorado.Trabalhador;
import br.edu.unibras.solid.lsp.refatorado.ContaBancaria;
import br.edu.unibras.solid.lsp.refatorado.ContaCorrente;
import br.edu.unibras.solid.lsp.refatorado.ContaInvestimento;
import br.edu.unibras.solid.ocp.refatorado.Caixa;
import br.edu.unibras.solid.ocp.refatorado.DescontoBlackFriday;
import br.edu.unibras.solid.ocp.refatorado.DescontoVip;
import br.edu.unibras.solid.srp.refatorado.CalculadoraSalario;
import br.edu.unibras.solid.srp.refatorado.Funcionario;
import br.edu.unibras.solid.srp.refatorado.FuncionarioRepository;
import br.edu.unibras.solid.srp.refatorado.RelatorioFuncionario;

import java.util.List;

// roda os exemplos refatorados
public class Main {
    public static void main(String[] args) {
        System.out.println("== S - Responsabilidade Única ==");
        Funcionario ana = new Funcionario("Ana", 5000.0);
        new FuncionarioRepository().salvar(ana);
        System.out.println(new RelatorioFuncionario(new CalculadoraSalario()).gerar(ana));

        System.out.println("\n== O - Aberto/Fechado ==");
        System.out.println("VIP: " + new Caixa(new DescontoVip()).fecharCompra(100.0));
        System.out.println("Black Friday: " + new Caixa(new DescontoBlackFriday()).fecharCompra(100.0));

        System.out.println("\n== L - Substituição de Liskov ==");
        for (ContaBancaria c : List.of(new ContaCorrente(), new ContaInvestimento())) {
            c.depositar(100.0);
            System.out.println(c.getClass().getSimpleName() + ": " + c.getSaldo());
        }

        System.out.println("\n== I - Segregação de Interfaces ==");
        List<Trabalhador> equipe = List.of(new Humano(), new Robo());
        equipe.forEach(Trabalhador::trabalhar);
        new Refeitorio().servirAlmoco(List.of(new Humano()));

        System.out.println("\n== D - Inversão de Dependência ==");
        new PedidoService(new EmailNotificador()).fecharPedido();
        new PedidoService(new SmsNotificador()).fecharPedido();
    }
}
