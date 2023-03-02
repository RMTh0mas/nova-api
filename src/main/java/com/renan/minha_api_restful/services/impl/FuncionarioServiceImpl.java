package com.renan.minha_api_restful.services.impl;

import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renan.minha_api_restful.dtos.FuncionarioDto;
import com.renan.minha_api_restful.entities.Funcionario;
import com.renan.minha_api_restful.mappers.FuncionarioMapper;
import com.renan.minha_api_restful.repositories.FuncionarioRepository;
import com.renan.minha_api_restful.services.FuncionarioService;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    @Autowired
    private FuncionarioMapper mapper;

    @Override
    public List<FuncionarioDto> getAll() {
        List<Funcionario> listaFuncionario = repository.findAll();
        return mapper.mapListFuncionario(listaFuncionario);
    }

    @Override
    public FuncionarioDto save(FuncionarioDto funcionariodto) {
        Funcionario funcionario = mapper.mapFuncionarioDTO(funcionariodto);
        funcionario = repository.save(funcionario);
        return mapper.mapFuncionario(funcionario);
    }

    @Override
    public FuncionarioDto findById(Long id) {
        Funcionario funcionario = repository.findOne(id);
        return mapper.mapFuncionario(funcionario);
    }

    @Override
    public FuncionarioDto findByCpf(String cpf) {
        Funcionario funcionario = repository.findByCpf(cpf);
        return mapper.mapFuncionario(funcionario);
    }

    @Override
    public FuncionarioDto delete(Long id) {
        Funcionario funcionario = repository.findOne(id);
        repository.delete(funcionario);
        return mapper.mapFuncionario(funcionario);
    }

    @Override
    public List<FuncionarioDto> getByName(String nome) {
        List<Funcionario> funcionario = repository.findByNomeIgnoreCaseContaining(nome);

        return mapper.mapListFuncionario(funcionario);
    }


    
}
