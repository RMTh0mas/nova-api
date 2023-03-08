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

import com.renan.minha_api_restful.dtos.FuncionarioDto;
import com.renan.minha_api_restful.responses.Response;
import com.renan.minha_api_restful.services.FuncionarioService;

@RestController
@RequestMapping("/api/v1/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;
    
    @GetMapping
    public ResponseEntity<Response<List<FuncionarioDto>>> getAll() {
        Response<List<FuncionarioDto>> response = new Response<List<FuncionarioDto>>();
        List<FuncionarioDto> listaFuncionarioDto = service.getAll();
        response.setData(listaFuncionarioDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<FuncionarioDto>> getById(@PathVariable("id") long id) {
        Response<FuncionarioDto> response = new Response<FuncionarioDto>();
        FuncionarioDto funcionarioDto = service.findById(id);
        response.setData(funcionarioDto);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Response<FuncionarioDto>> insertEmpresa(@Valid @RequestBody FuncionarioDto funcionarioDto, BindingResult result) {
        Response<FuncionarioDto> response = new Response<FuncionarioDto>();

        if(result.hasErrors()){
            result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(response);
        }
        
        service.save(funcionarioDto);
        response.setData(funcionarioDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<Response<List<FuncionarioDto>>> getByNome(@PathVariable("nome") String nome) {
        Response<List<FuncionarioDto>> response = new Response<List<FuncionarioDto>>();
        List<FuncionarioDto> listaFuncionariosDto = service.getByName(nome);
        response.setData(listaFuncionariosDto);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response<FuncionarioDto>> update(@Valid @PathVariable("id") long id,
            @RequestBody FuncionarioDto funcionarioDto, BindingResult result) {
        
        Response<FuncionarioDto> response = new Response<FuncionarioDto>();

        if(result.hasErrors()){
            result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(response);
        }

        FuncionarioDto funcionarioAntigoDto = service.findById(id);

        if (funcionarioAntigoDto == null) {
            return ResponseEntity.notFound().build();
        }
        
        funcionarioAntigoDto.setNome(funcionarioDto.getNome());
        funcionarioAntigoDto.setCpf(funcionarioDto.getCpf());
        funcionarioAntigoDto.setEmail(funcionarioDto.getEmail());
        funcionarioAntigoDto.setData_atualizacao(funcionarioDto.getData_atualizacao());
        funcionarioAntigoDto.setData_criacao(funcionarioDto.getData_criacao());
        funcionarioAntigoDto.setEmpresa(funcionarioDto.getEmpresa());
        funcionarioAntigoDto.setLancamentos(funcionarioDto.getLancamentos());
        funcionarioAntigoDto.setQtdHorasAlmoco(funcionarioDto.getQtdHorasAlmoco());
        funcionarioAntigoDto.setQtdHorasTrabalhoDia(funcionarioDto.getQtdHorasTrabalhoDia());

        service.save(funcionarioAntigoDto);
        response.setData(funcionarioAntigoDto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<FuncionarioDto>> delete(@PathVariable("id") long id) {

        Response<FuncionarioDto> response = new Response<FuncionarioDto>();

        FuncionarioDto funcionarioAntigoDto = service.findById(id);
        if (funcionarioAntigoDto == null) {
            return ResponseEntity.notFound().build();
        }
        service.delete(funcionarioAntigoDto.getId());
        response.setData(funcionarioAntigoDto);
        return ResponseEntity.ok(response);
    }
    
}
