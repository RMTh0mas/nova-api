package com.renan.minha_api_restful.dtos;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

import com.renan.minha_api_restful.entities.Empresa;
import com.renan.minha_api_restful.entities.Lancamento;
import com.renan.minha_api_restful.enums.PerfilEnum;
import com.renan.minha_api_restful.utils.SenhaUtils;

public class FuncionarioDto {

    private Long id;
    private String nome;
    private String email;
    private String senha;
    private String cpf;
    private BigDecimal valorHora;
    private Float qtdHorasTrabalhoDia;
    private Float qtdHorasAlmoco;
    private PerfilEnum perfil;
    private Date dataCriacao;
    private Date dataAtualizacao;
    private Empresa empresa;
    private List<Lancamento> lancamentos;
    private SenhaUtils encript;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    @NotEmpty(message = "O nome não pode ser vazio.")
    @Length(min = 3, max = 200, message = "nome deve conter entre 3 e 100 caracteres.")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @NotEmpty(message = "O e-mail não pode ser vazio.")
    @Email(message = "e-mail inválido")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @NotEmpty(message = "CPF não pode ser vazio.")
    @CPF(message = "CPF inválido")
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public BigDecimal getValorHora() {
        return valorHora;
    }

    public void setValorHora(BigDecimal valorHora) {
        this.valorHora = valorHora;
    }

    public Float getQtdHorasTrabalhoDia() {
        return qtdHorasTrabalhoDia;
    }

    public void setQtdHorasTrabalhoDia(Float qtdHorasTrabalhoDia) {
        this.qtdHorasTrabalhoDia = qtdHorasTrabalhoDia;
    }

    public Float getQtdHorasAlmoco() {
        return qtdHorasAlmoco;
    }

    public void setQtdHorasAlmoco(Float qtdHorasAlmoco) {
        this.qtdHorasAlmoco = qtdHorasAlmoco;
    }

    public PerfilEnum getPerfil() {
        return perfil;
    }

    public void setPerfil(PerfilEnum perfil) {
        this.perfil = perfil;
    }

    public Date getData_criacao() {
        return dataCriacao;
    }

    public void setData_criacao(Date data_criacao) {
        this.dataCriacao = data_criacao;
    }

    public Date getData_atualizacao() {
        return dataAtualizacao;
    }

    public void setData_atualizacao(Date data_atualizacao) {
        this.dataAtualizacao = data_atualizacao;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = encript.gerarBCript(senha);
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public List<Lancamento> getLancamentos() {
        return lancamentos;
    }

    public void setLancamentos(List<Lancamento> lancamentos) {
        lancamentos = lancamentos;
    }
    
    
}
