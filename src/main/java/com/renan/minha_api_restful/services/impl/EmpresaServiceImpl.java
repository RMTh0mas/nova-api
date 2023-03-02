package com.renan.minha_api_restful.services.impl;

import java.util.List;
import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renan.minha_api_restful.dtos.EmpresaDto;
import com.renan.minha_api_restful.entities.Empresa;
import com.renan.minha_api_restful.mappers.EmpresaMapper;
import com.renan.minha_api_restful.repositories.EmpresaRepository;
import com.renan.minha_api_restful.services.EmpresaService;

@Service
public class EmpresaServiceImpl implements EmpresaService {

    @Autowired
    private EmpresaRepository repository;

    @Autowired
    private EmpresaMapper mapper;

    @Override
    public List<EmpresaDto> getAll() {
        List<Empresa> listaEmpresa = repository.findAll();
        return mapper.mapListEmpresa(listaEmpresa);
    }

    @Override
    public EmpresaDto save(EmpresaDto empresadto) {
        Empresa empresa = mapper.mapEmpresaDTO(empresadto);
        empresa = repository.save(empresa);
        return mapper.mapEmpresa(empresa);
    }

    @Override
    public EmpresaDto findById(Long id) {
        Empresa empresa = repository.findOne(id);
        return mapper.mapEmpresa(empresa);
    }

    @Override
    public EmpresaDto findByCnpj(String cnpj) {
        Empresa empresa = repository.findByCnpj(cnpj);
        return mapper.mapEmpresa(empresa);
    }

    @Override
    public EmpresaDto delete(Long id) {
        Empresa empresa = repository.findOne(id);
        repository.delete(empresa);
        return mapper.mapEmpresa(empresa);

    }

    @Override
    public List<EmpresaDto> getByRazaoSocial(String razaoSocial) {
        List<Empresa> empresa = repository.findByRazaoSocialIgnoreCaseContaining(razaoSocial);

        return mapper.mapListEmpresa(empresa);

    }
    
}
