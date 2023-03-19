package com.renan.minha_api_restful;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.renan.minha_api_restful.entities.*;
import com.renan.minha_api_restful.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.renan.minha_api_restful.enums.PerfilEnum;
import com.renan.minha_api_restful.enums.TipoEnum;
import com.renan.minha_api_restful.utils.SenhaUtils;

import javax.persistence.EntityManager;

@SpringBootApplication
public class MinhaApiRestfulApplication {
	
	@Autowired // Instância a classe de forma automática
	private EmpresaRepository empresaRepository; 
	
	@Autowired 
	private FuncionarioRepository funcionarioRepository;

	@Autowired
	private LancamentoRepository lancamentoRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private UsuarioRoleRepository usuarioRoleRepository;

	Date c = new Date(); 
	
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

			empresas = empresaRepository.findAll();
			System.out.println("Empresas " + empresas.size());

			Funcionario funcionario1 = new Funcionario();

			funcionario1.setNome("Zezin");
			funcionario1.setEmail("zezin@gmail.com");
			funcionario1.setCpf("139.625.086-78");
			funcionario1.setSenha("teste123");
			funcionario1.setPerfil(PerfilEnum.ADMIN);

			this.funcionarioRepository.save(funcionario1);

			Lancamento lancamento1 = new Lancamento();

			lancamento1.setDescricao("Pausa");
			lancamento1.setData(c);
			lancamento1.setLocalizacao("Garuva");
			lancamento1.setTipo(TipoEnum.INICIO_ALMOCO);

			this.lancamentoRepository.save(lancamento1);

			Usuario usuario1 = new Usuario();
			senhaEncriptada = SenhaUtils.gerarBCript("renan123");

			usuario1.setUsername("renan");
			usuario1.setPassword(senhaEncriptada);

			UsuarioRole usuarioRole = new UsuarioRole();
			usuarioRole.setRole(PerfilEnum.ADMIN);
			this.usuarioRoleRepository.save(usuarioRole);

			List<UsuarioRole> lista = new ArrayList<UsuarioRole>();
			lista.add(usuarioRole);
			usuario1.setAuthorities(lista);

			this.usuarioRepository.save(usuario1);

			Usuario usuario2 = new Usuario();
			senhaEncriptada = SenhaUtils.gerarBCript("ramon123");

			usuario2.setUsername("ramon");
			usuario2.setPassword(senhaEncriptada);
			usuarioRole.setRole(PerfilEnum.USER);

			this.usuarioRoleRepository.save(usuarioRole);

			lista.add(usuarioRole);
			usuario2.setAuthorities(lista);

			this.usuarioRepository.save(usuario2);




		
		}; 
	} 

}
