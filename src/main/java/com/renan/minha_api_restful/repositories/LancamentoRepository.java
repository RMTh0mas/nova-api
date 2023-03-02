package com.renan.minha_api_restful.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.renan.minha_api_restful.entities.Lancamento;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, Long>{

    List<Lancamento> findByData(Date data);

    List<Lancamento> findByDescricaoIgnoreCaseContaining(String descricao);
    
}
