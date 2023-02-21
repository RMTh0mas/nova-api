package com.renan.minha_api_restful;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.renan.minha_api_restful.entities.Empresa;
import com.renan.minha_api_restful.repositories.EmpresaRepository;
import com.renan.minha_api_restful.utils.SenhaUtils;

@SpringBootApplication
public class MinhaApiRestfulApplication {
	/* 
	@Autowired // Instância a classe de forma automática
	private EmpresaRepository empresaRepository; */

	public static void main(String[] args) {
		SpringApplication.run(MinhaApiRestfulApplication.class, args);
	}
/* 
	@Bean
	public CommandLineRunner commandLineRunner(){
		return args -> {
			String senhaEncriptada = SenhaUtils.gerarBCript("4558898oidjsd");
			System.out.println("Senha encriptada -> " + senhaEncriptada);

			senhaEncriptada = SenhaUtils.gerarBCript("4558898oidjsd");
			System.out.println("Senha encriptada nova -> " + senhaEncriptada);

			System.out.println("Senha válida: " + SenhaUtils.validaSenha("4558898oidjsd", senhaEncriptada));

			Empresa empresa = new Empresa();
			empresa.setRazaoSocial("Renan CORP");
			empresa.setCnpj("10548567897000104");

			this.empresaRepository.save(empresa);

			List<Empresa> empresas = empresaRepository.findAll();
			empresas.forEach(System.out::println);
			
			Empresa empresa1 = empresaRepository.findOne(1L);

			System.out.println(empresa1);

			empresa1.setRazaoSocial("empresa");
			this.empresaRepository.save(empresa1);

			Empresa empresaCnpj = empresaRepository.findByCnpj("10548567897000104");

			System.out.println("Empresa por CNPJ: " + empresaCnpj);

			this.empresaRepository.delete(empresaCnpj);

			empresas = empresaRepository.findAll();
			System.out.println("Empresas " + empresas.size());

		
		}; 
	} */

}
