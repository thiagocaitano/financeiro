package br.com.deliverit.br.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//@Getter @Setter @EqualsAndHashCode @ToString
@Entity(name = "conta_pagar")
public class ContaPagar implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "nome")
	public String nome;

    @Column(name = "valor_original")
	public Double valorOriginal;

    @Column(name = "valor_corrigido")
	public Double valorCorrigido;

    @Column(name = "qtd_dias_atraso")
	public Long qtdDiasAtraso;

    @Column(name = "data_vencimento")
	public Date dataVencimento;

    @Column(name = "data_pagamento")
	public Date dataPagamento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValorOriginal() {
		return valorOriginal;
	}

	public void setValorOriginal(Double valorOriginal) {
		this.valorOriginal = valorOriginal;
	}

	public Double getValorCorrigido() {
		return valorCorrigido;
	}

	public void setValorCorrigido(Double valorCorrigido) {
		this.valorCorrigido = valorCorrigido;
	}

	public Long getQtdDiasAtraso() {
		return qtdDiasAtraso;
	}

	public void setQtdDiasAtraso(Long qtdDiasAtraso) {
		this.qtdDiasAtraso = qtdDiasAtraso;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
    
    
}