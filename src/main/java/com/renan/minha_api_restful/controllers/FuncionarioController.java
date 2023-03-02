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

import com.renan.minha_api_restful.dtos.FuncionarioDto;
import com.renan.minha_api_restful.services.FuncionarioService;

@RestController
@RequestMapping("/api/v1/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;
    
    @GetMapping
    public ResponseEntity<List<FuncionarioDto>> getAll() {
        List<FuncionarioDto> listaFuncionarioDto = service.getAll();
        return new ResponseEntity<List<FuncionarioDto>>(listaFuncionarioDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioDto> getById(@PathVariable("id") long id) {

        FuncionarioDto funcionarioDto = service.findById(id);
        return new ResponseEntity<FuncionarioDto>(funcionarioDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FuncionarioDto> insertEmpresa(@RequestBody FuncionarioDto funcionarioDto) {
        if (funcionarioDto.getId() == 0) {
            service.save(funcionarioDto);
            return new ResponseEntity<FuncionarioDto>(funcionarioDto, HttpStatus.CREATED);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<FuncionarioDto>> getByNome(@PathVariable("nome") String nome) {
        List<FuncionarioDto> listaFuncionariosDto = service.getByName(nome);
        return new ResponseEntity<List<FuncionarioDto>>(listaFuncionariosDto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FuncionarioDto> update(@PathVariable("id") long id,
            @RequestBody FuncionarioDto funcionarioDto) {

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

        return new ResponseEntity<FuncionarioDto>(funcionarioAntigoDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<FuncionarioDto> delete(@PathVariable("id") long id) {

        FuncionarioDto funcionarioAntigoDto = service.findById(id);
        if (funcionarioAntigoDto == null) {
            return ResponseEntity.notFound().build();
        }
        service.delete(funcionarioAntigoDto.getId());

        return new ResponseEntity<FuncionarioDto>(funcionarioAntigoDto, HttpStatus.OK);
    }
    
}
