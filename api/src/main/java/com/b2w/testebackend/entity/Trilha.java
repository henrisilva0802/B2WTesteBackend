package com.b2w.testebackend.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "trilha")
public class Trilha {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "trilha_nome")
	private String nome;

	@Column(name = "diretoria")
	private String diretoria;

	@Column(name = "missao_formal")
	private String missaoFormal;

	@Column(name = "missao_alternativa")
	private String missaoAlternativa;

	@Column(name = "data_atualizacao")
	private Date dataAtualizacao;

	public Trilha() {

	}

	public Trilha(Integer id, String nome, String diretoria, String missaoFormal, String missaoAlternativa,
			Date dataAtualizacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.diretoria = diretoria;
		this.missaoFormal = missaoFormal;
		this.missaoAlternativa = missaoAlternativa;
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

	public void setTrilhaNome(String nome) {
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
