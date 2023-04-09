package com.renan.minha_api_restful.dtos;

import java.util.Date;

import javax.validation.constraints.Future;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.renan.minha_api_restful.entities.Funcionario;
import com.renan.minha_api_restful.enums.TipoEnum;

public class LancamentoDto {

    private Long id;
    private Date data;
    private String descricao;
    private String localizacao;
    private Date dataCriacao;
    private Date dataAtualizacao;
    private String tipo;
    private Funcionario funcionario;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }

    @NotEmpty(message = "O nome não pode ser vazio.")
    @Length(min = 3, max = 200, message = "nome deve conter entre 3 e 100 caracteres.")
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getLocalizacao() {
        return localizacao;
    }
    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
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
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public Funcionario getFuncionario() {
        return funcionario;
    }
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    
    
}
