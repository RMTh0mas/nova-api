package com.renan.minha_api_restful.dtos;

import java.util.Date;
import java.util.List;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CNPJ;

import com.renan.minha_api_restful.entities.Funcionario;

public class EmpresaDto {

    private Long id;
    private String razaoSocial;
    private String cnpj;
    private Date dataCriacao;
    private Date dataAtualizacao;
    private List<Funcionario> funcionarios;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @NotEmpty(message = "razão social não pode ser vazia.")
    @Length(min = 5, max = 200, message = "razão social deve conter entre 5 e 200 caracteres.")
    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }
    
    @NotEmpty(message = "CNPJ não pode ser vazio.")
    @CNPJ(message = "CNPJ inválido.")
    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    
    
}
