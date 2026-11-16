package br.edu.unibras.solid.srp.violacao;

import java.util.ArrayList;
import java.util.List;

// aqui a classe faz tudo: guarda os dados, calcula salario, salva e ainda monta relatorio
// ou seja, tem varios motivos pra mudar (quebra o SRP)
public class Funcionario {

    // simulando o banco com uma lista
    private static final List<String> BANCO = new ArrayList<>();

    private final String nome;
    private final double salarioBruto;

    public Funcionario(String nome, double salarioBruto) {
        this.nome = nome;
        this.salarioBruto = salarioBruto;
    }

    public String getNome() { return nome; }
    public double getSalarioBruto() { return salarioBruto; }

    // regra de negocio
    public double calcularLiquido() {
        return salarioBruto * 0.8;
    }

    // persistencia, nao deveria estar aqui
    public void salvar() {
        BANCO.add(nome + ";" + salarioBruto);
    }

    // parte de apresentacao tbm misturada
    public String gerarRelatorio() {
        return "Funcionário: " + nome + " | Líquido: " + calcularLiquido();
    }

    public static List<String> registrosSalvos() { return List.copyOf(BANCO); }
    public static void limparBanco() { BANCO.clear(); }
}
