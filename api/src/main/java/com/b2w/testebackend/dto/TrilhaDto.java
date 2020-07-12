package com.b2w.testebackend.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TrilhaDto {
	private Integer id;

	private String nome;

	private String diretoria;

	private String missaoFormal;

	private String missaoAlternativa;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private Date dataAtualizacao;

	public TrilhaDto(Integer id, String nome, String diretoria, String missaoFormal, String missaoAlternativa,
			Date dataAtualizacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.diretoria = diretoria;
		this.missaoFormal = missaoFormal;
		this.missaoAlternativa = missaoAlternativa;
		this.dataAtualizacao = dataAtualizacao;
	}

	public TrilhaDto() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDiretoria() {
		return diretoria;
	}

	public void setDiretoria(String diretoria) {
		this.diretoria = diretoria;
	}

	public String getMissaoFormal() {
		return missaoFormal;
	}

	public void setMissaoFormal(String missaoFormal) {
		this.missaoFormal = missaoFormal;
	}

	public String getMissaoAlternativa() {
		return missaoAlternativa;
	}

	public void setMissaoAlternativa(String missaoAlternativa) {
		this.missaoAlternativa = missaoAlternativa;
	}

	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

}
