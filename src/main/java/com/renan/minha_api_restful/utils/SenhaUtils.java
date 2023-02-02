package com.renan.minha_api_restful.utils;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SenhaUtils {

    /**
     * Gera um hash utilizando o BCrypt.
     * 
     * @param senha
     * @return
     */

    public static String gerarBCript(String senha){
        if(senha == null){
            return senha;
        }

        BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();
        return bCryptEncoder.encode(senha);
    }

    /*
     * Verifica se a senha é válida
     */

    public static Boolean validaSenha(String senha, String senhaEncriptada){
        BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();
        return bCryptEncoder.matches(senha, senhaEncriptada);
    }


    
}
