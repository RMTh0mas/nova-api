package com.renan.minha_api_restful.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.renan.minha_api_restful.dtos.EmpresaDto;
import com.renan.minha_api_restful.entities.Empresa;

public interface EmpresaMapper {

    List<EmpresaDto> mapListEmpresa(List<Empresa> empresa);
    List<Empresa> mapListEmpresaDTO(List<EmpresaDto> empresa);

    EmpresaDto mapEmpresa(Empresa empresa);
    Empresa mapEmpresaDTO(EmpresaDto empresa);
    
}
