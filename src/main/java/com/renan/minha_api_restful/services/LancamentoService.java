package com.renan.minha_api_restful.services;

import java.util.Date;
import java.util.List;

import com.renan.minha_api_restful.dtos.LancamentoDto;

public interface LancamentoService {

    public List<LancamentoDto> getAll();

    public LancamentoDto save(LancamentoDto lancamento);

    public LancamentoDto findById(Long id);

    public List<LancamentoDto> findByDate(Date data);

    public LancamentoDto delete(Long id);

    public List<LancamentoDto> getByDescricao(String descricao);
    
}
