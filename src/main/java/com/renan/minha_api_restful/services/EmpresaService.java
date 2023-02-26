package com.renan.minha_api_restful.services;

import java.util.List;

import com.renan.minha_api_restful.entities.Empresa;

public interface EmpresaService {

    public List<Empresa> getAll();

    public Empresa save(Empresa empresa);

    public Empresa findById(Long id);

    public Empresa findByCnpj(String cnpj);

    public Empresa delete(Long id);

    public List<Empresa> getByRazaoSocial(String razaoSocial);
    
}
