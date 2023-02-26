package com.renan.minha_api_restful.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renan.minha_api_restful.entities.Funcionario;
import com.renan.minha_api_restful.repositories.FuncionarioRepository;
import com.renan.minha_api_restful.services.FuncionarioService;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    @Override
    public List<Funcionario> getAll() {
        return repository.findAll();
    }

    @Override
    public Funcionario save(Funcionario funcionario) {
        return repository.save(funcionario);
    }

    @Override
    public Funcionario findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Funcionario findByCpf(String cpf) {
        return repository.findByCpf(cpf);
    }

    @Override
    public Funcionario delete(Long id) {
        Funcionario funcionarioDeletado = repository.findOne(id);
        repository.delete(id);
        return funcionarioDeletado;
    }

    @Override
    public List<Funcionario> getByName(String nome) {
        return repository.findByNomeIgnoreCaseContaining(nome);
    }


    
}
