package com.renan.minha_api_restful.mappers.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.renan.minha_api_restful.dtos.LancamentoDto;
import com.renan.minha_api_restful.entities.Lancamento;
import com.renan.minha_api_restful.mappers.LancamentoMapper;

@Component
public class LancamentoMapperImpl implements LancamentoMapper {

    @Override
    public List<LancamentoDto> mapListLancamento(List<Lancamento> lancamento) {
        return lancamento.stream().map(this::mapLancamento).collect(Collectors.toList());
    }

    @Override
    public List<Lancamento> mapListLancamentoDTO(List<LancamentoDto> lancamento) {
        return lancamento.stream().map(this::mapLancamentoDTO).collect(Collectors.toList());
    }

    @Override
    public LancamentoDto mapLancamento(Lancamento lancamento) {
        LancamentoDto lancamentoDto = new LancamentoDto();
        lancamentoDto.setId(lancamento.getId());
        lancamentoDto.setData(lancamento.getData());
        lancamentoDto.setDescricao(lancamento.getDescricao());
        lancamentoDto.setLocalizacao(lancamento.getLocalizacao());
        lancamentoDto.setDataCriacao(lancamento.getDataCriacao());
        lancamentoDto.setDataAtualizacao(lancamento.getDataAtualizacao());
        lancamentoDto.setTipo(lancamento.getTipo());
        lancamentoDto.setFuncionario(lancamento.getFuncionario());
        return lancamentoDto;
    }

    @Override
    public Lancamento mapLancamentoDTO(LancamentoDto lancamentoDto) {
        Lancamento lancamento = new Lancamento();
    
        lancamento.setId(lancamentoDto.getId());
        lancamento.setData(lancamentoDto.getData());
        lancamento.setDescricao(lancamentoDto.getDescricao());
        lancamento.setLocalizacao(lancamentoDto.getLocalizacao());
        lancamento.setDataCriacao(lancamentoDto.getDataCriacao());
        lancamento.setDataAtualizacao(lancamentoDto.getDataAtualizacao());
        lancamento.setTipo(lancamentoDto.getTipo());
        lancamento.setFuncionario(lancamentoDto.getFuncionario());
        return lancamento;
    }
    
}
