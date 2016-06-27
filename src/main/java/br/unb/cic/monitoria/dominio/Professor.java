package br.unb.cic.monitoria.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Professor")
public class Professor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CD_PROFESSOR")
	private Integer id;
	
	@Column(name="NR_MATRICULA")
	private String matricula;
	
	@Column(name="NM_PROFESSOR")
	private String nome;
	
	@Column(name="DS_SENHA")
	private String senha;

	public Professor() { }
	
	public Professor(String matricula, String nome, String senha) {
		this.matricula = matricula;
		this.nome = nome;
		this.senha = senha;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
}
