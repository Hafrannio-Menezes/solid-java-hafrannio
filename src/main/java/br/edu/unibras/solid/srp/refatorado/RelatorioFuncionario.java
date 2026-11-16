package br.edu.unibras.solid.srp.refatorado;

public class RelatorioFuncionario {
    private final CalculadoraSalario calculadora;

    public RelatorioFuncionario(CalculadoraSalario calculadora) {
        this.calculadora = calculadora;
    }

    public String gerar(Funcionario f) {
        return "Funcionário: " + f.getNome() + " | Líquido: " + calculadora.calcularLiquido(f);
    }
}
