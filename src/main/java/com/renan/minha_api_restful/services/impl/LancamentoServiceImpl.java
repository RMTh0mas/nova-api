package com.renan.minha_api_restful.services.impl;

import java.util.Date;
import java.util.List;

import javax.validation.ReportAsSingleViolation;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renan.minha_api_restful.dtos.LancamentoDto;
import com.renan.minha_api_restful.entities.Lancamento;
import com.renan.minha_api_restful.mappers.LancamentoMapper;
import com.renan.minha_api_restful.repositories.LancamentoRepository;
import com.renan.minha_api_restful.services.LancamentoService;

@Service
public class LancamentoServiceImpl implements LancamentoService {

    @Autowired
    private LancamentoRepository repository;

    @Autowired
    private LancamentoMapper mapper;

    @Override
    public List<LancamentoDto> getAll() {
        List<Lancamento> listaLancamento = repository.findAll();
        return mapper.mapListLancamento(listaLancamento);
    }

    @Override
    public LancamentoDto save(LancamentoDto lancamentoDto) {
        Lancamento lancamento = mapper.mapLancamentoDTO(lancamentoDto);
        lancamento = repository.save(lancamento);
        return mapper.mapLancamento(lancamento);
    }

    @Override
    public LancamentoDto findById(Long id) {
        Lancamento lancamento = repository.findOne(id);
        return mapper.mapLancamento(lancamento);
    }

    @Override
    public List<LancamentoDto> findByDate(Date data) {
        List<Lancamento> lancamento = repository.findByData(data);
        return mapper.mapListLancamento(lancamento);
    }

    @Override
    public LancamentoDto delete(Long id) {
        Lancamento lancamento = repository.findOne(id);
        repository.delete(lancamento);
        return mapper.mapLancamento(lancamento);
    }

    @Override
    public List<LancamentoDto> getByDescricao(String descricao) {
        List<Lancamento> lancamento = repository.findByDescricaoIgnoreCaseContaining(descricao);

        return mapper.mapListLancamento(lancamento);
    }
    
}
