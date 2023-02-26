package com.renan.minha_api_restful.services.impl;

import java.util.Date;
import java.util.List;

import javax.validation.ReportAsSingleViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renan.minha_api_restful.entities.Lancamento;
import com.renan.minha_api_restful.repositories.LancamentoRepository;
import com.renan.minha_api_restful.services.LancamentoService;

@Service
public class LancamentoServiceImpl implements LancamentoService {

    @Autowired
    private LancamentoRepository repository;

    @Override
    public List<Lancamento> getAll() {
        return repository.findAll();
    }

    @Override
    public Lancamento save(Lancamento lancamento) {
        return repository.save(lancamento);
    }

    @Override
    public Lancamento findById(Long id) {
        return findById(id);
    }

    @Override
    public List<Lancamento> findByDate(Date data) {
        return repository.findByData(data);
    }

    @Override
    public Lancamento delete(Long id) {
        Lancamento lancamentoDeletado = repository.findOne(id);
        repository.delete(id);
        return lancamentoDeletado;
    }

    @Override
    public List<Lancamento> getByDescricao(String descricao) {
        return repository.findByDescricaoIgnoreCaseContaining(descricao);
    }
    
}
