package com.renan.minha_api_restful.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.renan.minha_api_restful.entities.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long>{

    Empresa findByCnpj(String cnpj);

    List<Empresa> findByRazaoSocialIgnoreCaseContaining(String razaoSocial);
    
}
