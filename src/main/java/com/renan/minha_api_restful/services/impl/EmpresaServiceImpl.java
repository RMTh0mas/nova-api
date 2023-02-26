package com.renan.minha_api_restful.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renan.minha_api_restful.entities.Empresa;
import com.renan.minha_api_restful.repositories.EmpresaRepository;
import com.renan.minha_api_restful.services.EmpresaService;

@Service
public class EmpresaServiceImpl implements EmpresaService {

    @Autowired
    private EmpresaRepository repository;

    @Override
    public List<Empresa> getAll() {
        return repository.findAll();
    }

    @Override
    public Empresa save(Empresa empresa) {
        return repository.save(empresa);
    }

    @Override
    public Empresa findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Empresa findByCnpj(String cnpj) {
        return repository.findByCnpj(cnpj);
    }

    @Override
    public Empresa delete(Long id) {
        Empresa empresaDeletada = repository.findOne(id);
        repository.delete(id);
        return empresaDeletada;
    }

    @Override
    public List<Empresa> getByRazaoSocial(String razaoSocial) {
        return repository.findByRazaoSocialIgnoreCaseContaining(razaoSocial);
    }
    
}
