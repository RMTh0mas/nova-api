package com.renan.minha_api_restful.services;

import java.util.List;

import com.renan.minha_api_restful.dtos.FuncionarioDto;

public interface FuncionarioService {

    public List<FuncionarioDto> getAll();

    public FuncionarioDto save(FuncionarioDto funcionario);

    public FuncionarioDto findById(Long id);

    public FuncionarioDto findByCpf(String cpf);

    public FuncionarioDto delete(Long id);

    public List<FuncionarioDto> getByName(String nome);
    
}
