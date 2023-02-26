package com.renan.minha_api_restful.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.renan.minha_api_restful.entities.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>{

    List<Lancamento> findByData(Date data);

    List<Lancamento> findByDescricaoIgnoreCaseContaining(String descricao);
    
}
