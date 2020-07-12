package com.b2w.testebackend.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CargoDto {

	private Integer id;

	private String nome;

	private Integer trilhaId;

	private String missao;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private Date dataAtualizacao;

	public CargoDto() {

	}

	public CargoDto(Integer id, String nome, Integer trilhaId, String missao, Date dataAtualizacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.trilhaId = trilhaId;
		this.missao = missao;
		this.dataAtualizacao = dataAtualizacao;
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

	public void setNome(String cargoNome) {
		this.nome = cargoNome;
	}

	public Integer getTrilhaId() {
		return trilhaId;
	}

	public void setTrilhaId(Integer trilhaId) {
		this.trilhaId = trilhaId;
	}

	public String getMissao() {
		return missao;
	}

	public void setMissao(String cargoMissao) {
		this.missao = cargoMissao;
	}

	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

}
