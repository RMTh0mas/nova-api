package com.renan.minha_api_restful.mappers.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.renan.minha_api_restful.dtos.EmpresaDto;
import com.renan.minha_api_restful.entities.Empresa;
import com.renan.minha_api_restful.mappers.EmpresaMapper;

@Component
public class EmpresaMapperImpl implements EmpresaMapper {

    @Override
    public List<EmpresaDto> mapListEmpresa(List<Empresa> empresa) {
        return empresa.stream().map(this::mapEmpresa).collect(Collectors.toList());
    }

    @Override
    public List<Empresa> mapListEmpresaDTO(List<EmpresaDto> empresa) {
        return empresa.stream().map(this::mapEmpresaDTO).collect(Collectors.toList());
    }

    @Override
    public EmpresaDto mapEmpresa(Empresa empresa) {
        EmpresaDto empresaDto = new EmpresaDto();
        empresaDto.setId(empresa.getId());
        empresaDto.setRazaoSocial(empresa.getRazaoSocial());
        empresaDto.setCnpj(empresa.getCnpj());
        empresaDto.setDataCriacao(empresa.getDataCriacao());
        empresaDto.setDataAtualizacao(empresa.getDataAtualizacao());
        empresaDto.setFuncionarios(empresa.getFuncionarios());
        return empresaDto;
    }

    @Override
    public Empresa mapEmpresaDTO(EmpresaDto empresaDto) {
        Empresa empresa = new Empresa();
        empresa.setId(empresaDto.getId());
        empresa.setRazaoSocial(empresaDto.getRazaoSocial());
        empresa.setCnpj(empresaDto.getCnpj());
        empresa.setDataCriacao(empresaDto.getDataCriacao());
        empresa.setDataAtualizacao(empresaDto.getDataAtualizacao());
        empresa.setFuncionarios(empresaDto.getFuncionarios());
        return empresa;
    }
    
}
