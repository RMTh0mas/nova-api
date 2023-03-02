package com.renan.minha_api_restful.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import com.renan.minha_api_restful.dtos.LancamentoDto;
import com.renan.minha_api_restful.entities.Lancamento;

public interface LancamentoMapper {
    
    List<LancamentoDto> mapListLancamento(List<Lancamento> lancamento);
    List<Lancamento> mapListLancamentoDTO(List<LancamentoDto> lancamento);

    LancamentoDto mapLancamento (Lancamento lancamento);
    Lancamento mapLancamentoDTO(LancamentoDto lancamento);
}
