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

import com.renan.minha_api_restful.entities.Lancamento;
import com.renan.minha_api_restful.services.LancamentoService;

@RestController
@RequestMapping("/api/v1/lancamento")
public class LancamentoController {

    @Autowired
    private LancamentoService service;

    @GetMapping
    public ResponseEntity<List<Lancamento>> getAll() {
        List<Lancamento> listaLancamento = service.getAll();
        return new ResponseEntity<List<Lancamento>>(listaLancamento, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lancamento> getById(@PathVariable("id") long id) {

        Lancamento lancamento = service.findById(id);
        return new ResponseEntity<Lancamento>(lancamento, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Lancamento> insertEmpresa(@RequestBody Lancamento lancamento) {
        if (lancamento.getId() == 0) {
            service.save(lancamento);
            return new ResponseEntity<Lancamento>(lancamento, HttpStatus.CREATED);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/descricao/{descricao}")
    public ResponseEntity<List<Lancamento>> getByDescricao(@PathVariable("descricao") String descricao) {
        List<Lancamento> listaLancamento = service.getByDescricao(descricao);
        return new ResponseEntity<List<Lancamento>>(listaLancamento, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lancamento> update(@PathVariable("id") long id,
            @RequestBody Lancamento lancamento) {

        Lancamento lancamentoAntigo = service.findById(id);
        if (lancamentoAntigo == null) {
            return ResponseEntity.notFound().build();
        }
        
        lancamentoAntigo.setDescricao(lancamento.getDescricao());
        lancamentoAntigo.setData(lancamento.getData());
        lancamentoAntigo.setDataAtualizacao(lancamento.getDataAtualizacao());
        lancamentoAntigo.setDataCriacao(lancamento.getDataCriacao());
        lancamentoAntigo.setLocalizacao(lancamento.getLocalizacao());
        
        service.save(lancamentoAntigo);

        return new ResponseEntity<Lancamento>(lancamentoAntigo, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Lancamento> delete(@PathVariable("id") long id) {

        Lancamento lancamentoAntigo = service.findById(id);
        if (lancamentoAntigo == null) {
            return ResponseEntity.notFound().build();
        }
        service.delete(lancamentoAntigo.getId());

        return new ResponseEntity<Lancamento>(lancamentoAntigo, HttpStatus.OK);
    }
    
}
