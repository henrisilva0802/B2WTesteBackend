package com.b2w.testebackend.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cargo")
public class Cargo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "cargo_nome")
	private String nome;

	@ManyToOne
	@JoinColumn(name = "trilha_id")
	private Trilha trilha;

	@Column(name = "cargo_missao")
	private String missao;

	@Column(name = "data_atualizacao")
	private Date dataAtualizacao;

	public Cargo() {
	}

	public Cargo(Integer id, String nome, Trilha trilha, String missao, Date dataAtualizacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.trilha = trilha;
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

	public Trilha getTrilha() {
		return trilha;
	}

	public void setTrilha(Trilha trilha) {
		this.trilha = trilha;
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
