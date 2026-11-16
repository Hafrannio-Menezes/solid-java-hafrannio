package br.edu.unibras.solid.srp.refatorado;

import java.util.ArrayList;
import java.util.List;

// salva em memoria mesmo, so pra exemplo
public class FuncionarioRepository {
    private final List<Funcionario> registros = new ArrayList<>();

    public void salvar(Funcionario f) { registros.add(f); }
    public List<Funcionario> listar() { return List.copyOf(registros); }
}
