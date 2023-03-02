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

import com.renan.minha_api_restful.dtos.LancamentoDto;
import com.renan.minha_api_restful.services.LancamentoService;

@RestController
@RequestMapping("/api/v1/lancamento")
public class LancamentoController {

    @Autowired
    private LancamentoService service;

    @GetMapping
    public ResponseEntity<List<LancamentoDto>> getAll() {
        List<LancamentoDto> listaLancamento = service.getAll();
        return new ResponseEntity<List<LancamentoDto>>(listaLancamento, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LancamentoDto> getById(@PathVariable("id") long id) {

        LancamentoDto lancamento = service.findById(id);
        return new ResponseEntity<LancamentoDto>(lancamento, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<LancamentoDto> insertEmpresa(@RequestBody LancamentoDto lancamento) {
        if (lancamento.getId() == 0) {
            service.save(lancamento);
            return new ResponseEntity<LancamentoDto>(lancamento, HttpStatus.CREATED);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/descricao/{descricao}")
    public ResponseEntity<List<LancamentoDto>> getByDescricao(@PathVariable("descricao") String descricao) {
        List<LancamentoDto> listaLancamento = service.getByDescricao(descricao);
        return new ResponseEntity<List<LancamentoDto>>(listaLancamento, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LancamentoDto> update(@PathVariable("id") long id,
            @RequestBody LancamentoDto lancamento) {

        LancamentoDto lancamentoAntigo = service.findById(id);
        if (lancamentoAntigo == null) {
            return ResponseEntity.notFound().build();
        }
        
        lancamentoAntigo.setDescricao(lancamento.getDescricao());
        lancamentoAntigo.setData(lancamento.getData());
        lancamentoAntigo.setDataAtualizacao(lancamento.getDataAtualizacao());
        lancamentoAntigo.setDataCriacao(lancamento.getDataCriacao());
        lancamentoAntigo.setLocalizacao(lancamento.getLocalizacao());
        
        service.save(lancamentoAntigo);

        return new ResponseEntity<LancamentoDto>(lancamentoAntigo, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<LancamentoDto> delete(@PathVariable("id") long id) {

        LancamentoDto lancamentoAntigo = service.findById(id);
        if (lancamentoAntigo == null) {
            return ResponseEntity.notFound().build();
        }
        service.delete(lancamentoAntigo.getId());

        return new ResponseEntity<LancamentoDto>(lancamentoAntigo, HttpStatus.OK);
    }
    
}
