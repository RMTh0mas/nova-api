package com.renan.minha_api_restful.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.renan.minha_api_restful.dtos.EmpresaDto;
import com.renan.minha_api_restful.responses.Response;
import com.renan.minha_api_restful.services.EmpresaService;

@RestController
@RequestMapping("/api/v1/empresa")
public class EmpresaController {

    @Autowired
    private EmpresaService service;

    
    @GetMapping
    public ResponseEntity<Response<List<EmpresaDto>>> getAll() {
        Response<List<EmpresaDto>> response = new Response<List<EmpresaDto>>();
        List<EmpresaDto> listaEmpresa = service.getAll();
        response.setData(listaEmpresa);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<EmpresaDto>> getById(@PathVariable("id") long id) {
        Response<EmpresaDto> response = new Response<EmpresaDto>();

        EmpresaDto empresa = service.findById(id);
        response.setData(empresa);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Response<EmpresaDto>> insertEmpresa(@Valid @RequestBody EmpresaDto empresa, BindingResult result) {
        
        Response<EmpresaDto> response = new Response<EmpresaDto>();
    
        if(result.hasErrors()){
            result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(response);
        }

        service.save(empresa);
        response.setData(empresa);
        return ResponseEntity.ok(response);

    }

    @GetMapping("/razaoSocial/{razaoSocial}")
    public ResponseEntity<Response<List<EmpresaDto>>> getByRazaoSocial(@PathVariable("razaoSocial") String razaoSocial) {
        Response<List<EmpresaDto>> response = new Response<List<EmpresaDto>>();

        List<EmpresaDto> listaEmpresas = service.getByRazaoSocial(razaoSocial);
        response.setData(listaEmpresas);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response<EmpresaDto>> update(@Valid @PathVariable("id") long id,
            @RequestBody EmpresaDto empresa, BindingResult result) {

        Response<EmpresaDto> response = new Response<EmpresaDto>();

        EmpresaDto empresaAntiga = service.findById(id);
        if (empresaAntiga == null) {
            return ResponseEntity.notFound().build();
        }

        if(result.hasErrors()){
            result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(response);
        }
        
        empresaAntiga.setCnpj(empresa.getCnpj());
        empresaAntiga.setRazaoSocial(empresa.getRazaoSocial());
        empresaAntiga.setDataCriacao(empresa.getDataCriacao());
        empresaAntiga.setDataAtualizacao(empresa.getDataAtualizacao());
        empresaAntiga.setFuncionarios(empresa.getFuncionarios());

        service.save(empresaAntiga);
        response.setData(empresaAntiga);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<EmpresaDto>> delete(@PathVariable("id") long id) {

        Response<EmpresaDto> response = new Response<EmpresaDto>();

        EmpresaDto empresaAntiga = service.findById(id);
        if (empresaAntiga == null) {
            return ResponseEntity.notFound().build();
        }
        service.delete(empresaAntiga.getId());
        response.setData(empresaAntiga);

        return ResponseEntity.ok(response);
    }

    
}
