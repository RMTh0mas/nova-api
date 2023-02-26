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

import com.renan.minha_api_restful.entities.Empresa;
import com.renan.minha_api_restful.services.EmpresaService;

@RestController
@RequestMapping("/api/v1/empresa")
public class EmpresaController {

    @Autowired
    private EmpresaService service;

    
    @GetMapping
    public ResponseEntity<List<Empresa>> getAll() {
        List<Empresa> listaEmpresa = service.getAll();
        return new ResponseEntity<List<Empresa>>(listaEmpresa, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empresa> getById(@PathVariable("id") long id) {

        Empresa empresa = service.findById(id);
        return new ResponseEntity<Empresa>(empresa, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Empresa> insertEmpresa(@RequestBody Empresa empresa) {
        if (empresa.getId() == 0) {
            service.save(empresa);
            return new ResponseEntity<Empresa>(empresa, HttpStatus.CREATED);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/razaoSocial/{razaoSocial}")
    public ResponseEntity<List<Empresa>> getByRazaoSocial(@PathVariable("razaoSocial") String razaoSocial) {
        List<Empresa> listaEmpresas = service.getByRazaoSocial(razaoSocial);
        return new ResponseEntity<List<Empresa>>(listaEmpresas, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empresa> update(@PathVariable("id") long id,
            @RequestBody Empresa empresa) {

        Empresa empresaAntiga = service.findById(id);
        if (empresaAntiga == null) {
            return ResponseEntity.notFound().build();
        }
        
        empresaAntiga.setCnpj(empresa.getCnpj());
        empresaAntiga.setDataCriacao(empresa.getDataCriacao());
        empresaAntiga.setDataAtualizacao(empresa.getDataAtualizacao());
        empresaAntiga.setFuncionarios(empresa.getFuncionarios());
        empresaAntiga.setRazaoSocial(empresa.getRazaoSocial());

        service.save(empresaAntiga);

        return new ResponseEntity<Empresa>(empresaAntiga, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Empresa> delete(@PathVariable("id") long id) {

        Empresa empresaAntiga = service.findById(id);
        if (empresaAntiga == null) {
            return ResponseEntity.notFound().build();
        }
        service.delete(empresaAntiga.getId());

        return new ResponseEntity<Empresa>(empresaAntiga, HttpStatus.OK);
    }

    
}
