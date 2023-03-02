package com.renan.minha_api_restful.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import com.renan.minha_api_restful.dtos.FuncionarioDto;
import com.renan.minha_api_restful.entities.Funcionario;


public interface FuncionarioMapper {
    
    List<FuncionarioDto> mapListFuncionario(List<Funcionario> funcionario);
    List<Funcionario> mapListFuncionarioDTO(List<FuncionarioDto> funcionario);

    FuncionarioDto mapFuncionario (Funcionario funcionario);
    Funcionario mapFuncionarioDTO(FuncionarioDto funcionario);
}
