package com.renan.minha_api_restful.services;

import java.util.List;

import com.renan.minha_api_restful.dtos.EmpresaDto;

public interface EmpresaService {

    public List<EmpresaDto> getAll();

    public EmpresaDto save(EmpresaDto empresa);

    public EmpresaDto findById(Long id);

    public EmpresaDto findByCnpj(String cnpj);

    public EmpresaDto delete(Long id);

    public List<EmpresaDto> getByRazaoSocial(String razaoSocial);
    
}
