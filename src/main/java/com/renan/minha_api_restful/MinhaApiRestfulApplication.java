package com.renan.minha_api_restful;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.renan.minha_api_restful.utils.SenhaUtils;

@SpringBootApplication
public class MinhaApiRestfulApplication {

	public static void main(String[] args) {
		SpringApplication.run(MinhaApiRestfulApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(){
		return args -> {
			String senhaEncriptada = SenhaUtils.gerarBCript("4558898oidjsd");
			System.out.println("Senha encriptada -> " + senhaEncriptada);

			senhaEncriptada = SenhaUtils.gerarBCript("4558898oidjsd");
			System.out.println("Senha encriptada nova -> " + senhaEncriptada);

			System.out.println("Senha válida: " + SenhaUtils.validaSenha("4558898oidjsd", senhaEncriptada));
		};
	}

}
