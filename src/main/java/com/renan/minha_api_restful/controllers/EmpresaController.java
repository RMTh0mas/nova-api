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

import com.renan.minha_api_restful.dtos.EmpresaDto;
import com.renan.minha_api_restful.services.EmpresaService;

@RestController
@RequestMapping("/api/v1/empresa")
public class EmpresaController {

    @Autowired
    private EmpresaService service;

    
    @GetMapping
    public ResponseEntity<List<EmpresaDto>> getAll() {
        List<EmpresaDto> listaEmpresa = service.getAll();
        return new ResponseEntity<List<EmpresaDto>>(listaEmpresa, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpresaDto> getById(@PathVariable("id") long id) {

        EmpresaDto empresa = service.findById(id);
        return new ResponseEntity<EmpresaDto>(empresa, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EmpresaDto> insertEmpresa(@RequestBody EmpresaDto empresa) {
        if (empresa.getId() == 0) {
            service.save(empresa);
            return new ResponseEntity<EmpresaDto>(empresa, HttpStatus.CREATED);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/razaoSocial/{razaoSocial}")
    public ResponseEntity<List<EmpresaDto>> getByRazaoSocial(@PathVariable("razaoSocial") String razaoSocial) {
        List<EmpresaDto> listaEmpresas = service.getByRazaoSocial(razaoSocial);
        return new ResponseEntity<List<EmpresaDto>>(listaEmpresas, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpresaDto> update(@PathVariable("id") long id,
            @RequestBody EmpresaDto empresa) {

        EmpresaDto empresaAntiga = service.findById(id);
        if (empresaAntiga == null) {
            return ResponseEntity.notFound().build();
        }
        
        empresaAntiga.setCnpj(empresa.getCnpj());
        empresaAntiga.setRazaoSocial(empresa.getRazaoSocial());
        empresaAntiga.setDataCriacao(empresa.getDataCriacao());
        empresaAntiga.setDataAtualizacao(empresa.getDataAtualizacao());
        empresaAntiga.setFuncionarios(empresa.getFuncionarios());

        service.save(empresaAntiga);

        return new ResponseEntity<EmpresaDto>(empresaAntiga, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EmpresaDto> delete(@PathVariable("id") long id) {

        EmpresaDto empresaAntiga = service.findById(id);
        if (empresaAntiga == null) {
            return ResponseEntity.notFound().build();
        }
        service.delete(empresaAntiga.getId());

        return new ResponseEntity<EmpresaDto>(empresaAntiga, HttpStatus.OK);
    }

    
}
