package com.renan.minha_api_restful.mappers.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.renan.minha_api_restful.dtos.FuncionarioDto;
import com.renan.minha_api_restful.entities.Funcionario;
import com.renan.minha_api_restful.mappers.FuncionarioMapper;

@Component
public class FuncionarioMapperImpl implements FuncionarioMapper {

    @Override
    public List<FuncionarioDto> mapListFuncionario(List<Funcionario> funcionario) {
        return funcionario.stream().map(this::mapFuncionario).collect(Collectors.toList());
    }

    @Override
    public List<Funcionario> mapListFuncionarioDTO(List<FuncionarioDto> funcionario) {
        return funcionario.stream().map(this::mapFuncionarioDTO).collect(Collectors.toList());
    }

    @Override
    public FuncionarioDto mapFuncionario(Funcionario funcionario) {
        FuncionarioDto funcionarioDto = new FuncionarioDto();
        funcionarioDto.setId(funcionario.getId());
        funcionarioDto.setNome(funcionario.getNome());
        funcionarioDto.setEmail(funcionario.getEmail());
        funcionarioDto.setSenha(funcionario.getSenha());
        funcionarioDto.setValorHora(funcionario.getValorHora());
        funcionarioDto.setQtdHorasTrabalhoDia(funcionario.getQtdHorasTrabalhoDia());
        funcionarioDto.setQtdHorasAlmoco(funcionario.getQtdHorasAlmoco());
        funcionarioDto.setPerfil(funcionario.getPerfil());
        funcionarioDto.setLancamentos(funcionario.getLancamentos());
        funcionarioDto.setCpf(funcionario.getCpf());
        funcionarioDto.setData_criacao(funcionario.getData_criacao());
        funcionarioDto.setData_atualizacao(funcionario.getData_atualizacao());
        funcionarioDto.setEmpresa(funcionario.getEmpresa());
        return funcionarioDto;
    }

    @Override
    public Funcionario mapFuncionarioDTO(FuncionarioDto funcionarioDto) {
        Funcionario funcionario = new Funcionario();
        funcionario.setId(funcionarioDto.getId());
        funcionario.setNome(funcionarioDto.getNome());
        funcionario.setEmail(funcionarioDto.getEmail());
        funcionario.setSenha(funcionarioDto.getSenha());
        funcionario.setValorHora(funcionarioDto.getValorHora());
        funcionario.setQtdHorasTrabalhoDia(funcionarioDto.getQtdHorasTrabalhoDia());
        funcionario.setQtdHorasAlmoco(funcionarioDto.getQtdHorasAlmoco());
        funcionario.setPerfil(funcionarioDto.getPerfil());
        funcionario.setLancamentos(funcionarioDto.getLancamentos());
        funcionario.setCpf(funcionarioDto.getCpf());
        funcionario.setData_criacao(funcionarioDto.getData_criacao());
        funcionario.setData_atualizacao(funcionarioDto.getData_atualizacao());
        funcionario.setEmpresa(funcionarioDto.getEmpresa());
        return funcionario;
    }
    
}
