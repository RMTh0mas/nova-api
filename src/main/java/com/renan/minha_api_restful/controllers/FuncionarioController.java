package com.renan.minha_api_restful.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.renan.minha_api_restful.entities.Funcionario;
import com.renan.minha_api_restful.services.FuncionarioService;

@RestController
@RequestMapping("/api/v1/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;
    
    @GetMapping
    public ResponseEntity<List<Funcionario>> getAll() {
        List<Funcionario> listaFuncionario = service.getAll();
        return new ResponseEntity<List<Funcionario>>(listaFuncionario, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> getById(@PathVariable("id") long id) {

        Funcionario funcionario = service.findById(id);
        return new ResponseEntity<Funcionario>(funcionario, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Funcionario> insertEmpresa(@RequestBody Funcionario funcionario) {
        if (funcionario.getId() == 0) {
            service.save(funcionario);
            return new ResponseEntity<Funcionario>(funcionario, HttpStatus.CREATED);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Funcionario>> getByNome(@PathVariable("nome") String nome) {
        List<Funcionario> listaFuncionarios = service.getByName(nome);
        return new ResponseEntity<List<Funcionario>>(listaFuncionarios, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> update(@PathVariable("id") long id,
            @RequestBody Funcionario funcionario) {

        Funcionario funcionarioAntigo = service.findById(id);
        if (funcionarioAntigo == null) {
            return ResponseEntity.notFound().build();
        }
        
        funcionarioAntigo.setNome(funcionario.getNome());
        funcionarioAntigo.setCpf(funcionario.getCpf());
        funcionarioAntigo.setEmail(funcionario.getEmail());
        funcionarioAntigo.setEmpresa(funcionario.getEmpresa());
        funcionarioAntigo.setData_criacao(funcionario.getData_criacao());
        funcionarioAntigo.setData_atualizacao(funcionario.getData_atualizacao());
        funcionarioAntigo.setPerfil(funcionario.getPerfil());
        funcionarioAntigo.setQtdHorasAlmoco(funcionario.getQtdHorasAlmoco());
        funcionarioAntigo.setQtdHorasTrabalhoDia(funcionario.getQtdHorasTrabalhoDia());
        
        service.save(funcionarioAntigo);

        return new ResponseEntity<Funcionario>(funcionarioAntigo, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Funcionario> delete(@PathVariable("id") long id) {

        Funcionario funcionarioAntigo = service.findById(id);
        if (funcionarioAntigo == null) {
            return ResponseEntity.notFound().build();
        }
        service.delete(funcionarioAntigo.getId());

        return new ResponseEntity<Funcionario>(funcionarioAntigo, HttpStatus.OK);
    }
    
}
