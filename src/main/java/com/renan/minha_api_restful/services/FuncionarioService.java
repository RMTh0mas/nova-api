package com.renan.minha_api_restful.services;

import java.util.List;

import com.renan.minha_api_restful.entities.Funcionario;

public interface FuncionarioService {

    public List<Funcionario> getAll();

    public Funcionario save(Funcionario funcionario);

    public Funcionario findById(Long id);

    public Funcionario findByCpf(String cpf);

    public Funcionario delete(Long id);

    public List<Funcionario> getByName(String nome);
    
}
