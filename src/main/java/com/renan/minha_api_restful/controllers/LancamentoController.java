package com.renan.minha_api_restful.controllers;

import java.util.List;

import javax.validation.Valid;

import com.renan.minha_api_restful.enums.TipoEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

import com.renan.minha_api_restful.dtos.LancamentoDto;
import com.renan.minha_api_restful.responses.Response;
import com.renan.minha_api_restful.services.LancamentoService;

@RestController
@RequestMapping("/api/v1/lancamento")
public class LancamentoController {

    @Autowired
    private LancamentoService service;

    private TipoEnum enums;

    @GetMapping
    public ResponseEntity<Response<List<LancamentoDto>>> getAll() {
        Response<List<LancamentoDto>> response = new Response<List<LancamentoDto>>();
        List<LancamentoDto> listaLancamento = service.getAll();
        response.setData(listaLancamento);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<LancamentoDto>> getById(@PathVariable("id") long id) {

        Response<LancamentoDto> response = new Response<LancamentoDto>();

        LancamentoDto lancamento = service.findById(id);
        response.setData(lancamento);
        return ResponseEntity.ok(response);
    }

    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<Response<LancamentoDto>> insertLancamento(@Valid @RequestBody LancamentoDto lancamento, BindingResult result) {
        
        Response<LancamentoDto> response = new Response<LancamentoDto>();

        if(result.hasErrors()){
            result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(response);
        }

        service.save(lancamento);
        response.setData(lancamento);
        return ResponseEntity.ok(response);
        
    }

    @GetMapping("/descricao/{descricao}")
    public ResponseEntity<Response<List<LancamentoDto>>> getByDescricao(@PathVariable("descricao") String descricao) {
        Response<List<LancamentoDto>> response = new Response<List<LancamentoDto>>();
        List<LancamentoDto> listaLancamento = service.getByDescricao(descricao);
        response.setData(listaLancamento);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response<LancamentoDto>> update(@Valid @PathVariable("id") long id,
            @RequestBody LancamentoDto lancamento, BindingResult result) {
        
        Response<LancamentoDto> response = new Response<LancamentoDto>();

        LancamentoDto lancamentoAntigo = service.findById(id);
        if (lancamentoAntigo == null) {
            return ResponseEntity.notFound().build();
        }

        if(result.hasErrors()){
            result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(response);
        }
        
        lancamentoAntigo.setDescricao(lancamento.getDescricao());
        lancamentoAntigo.setData(lancamento.getData());
        lancamentoAntigo.setDataAtualizacao(lancamento.getDataAtualizacao());
        lancamentoAntigo.setDataCriacao(lancamento.getDataCriacao());
        lancamentoAntigo.setLocalizacao(lancamento.getLocalizacao());
        
        service.save(lancamentoAntigo);
        response.setData(lancamentoAntigo);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<LancamentoDto>> delete(@PathVariable("id") long id) {

        Response<LancamentoDto> response = new Response<LancamentoDto>();

        LancamentoDto lancamentoAntigo = service.findById(id);
        if (lancamentoAntigo == null) {
            return ResponseEntity.notFound().build();
        }
        service.delete(lancamentoAntigo.getId());
        response.setData(lancamentoAntigo);
        return ResponseEntity.ok(response);
    }
    
}
