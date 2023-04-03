package com.renan.minha_api_restful.repositories;


import com.renan.minha_api_restful.entities.Lancamento;
import com.renan.minha_api_restful.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByUsername(String username);

    @Query(value = "select * from usuario where username = :username and password = :password", nativeQuery = true)
    public Usuario Login(@Param("username") String username, @Param("password") String password);
}
