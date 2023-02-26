package com.renan.minha_api_restful.services;

import java.util.Date;
import java.util.List;

import com.renan.minha_api_restful.entities.Lancamento;

public interface LancamentoService {

    public List<Lancamento> getAll();

    public Lancamento save(Lancamento lancamento);

    public Lancamento findById(Long id);

    public List<Lancamento> findByDate(Date data);

    public Lancamento delete(Long id);

    public List<Lancamento> getByDescricao(String descricao);
    
}
