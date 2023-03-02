package com.renan.minha_api_restful.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.renan.minha_api_restful.entities.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    Funcionario findByCpf(String cpf);

    List<Funcionario> findByNomeIgnoreCaseContaining(String nome);
    
}
