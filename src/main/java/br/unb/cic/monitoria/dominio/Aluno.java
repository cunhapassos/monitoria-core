package br.unb.cic.monitoria.dominio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ALUNO")
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CD_ALUNO")
	private Integer id;

	@Column(name = "NR_MATRICULA")
	private String matricula;

	@Column(name = "NM_ALUNO")
	private String nome;

	@Column(name = "VL_IRA")
	private double ira;

	@Column(name = "DS_SENHA")
	private String senha;

	@OneToMany(mappedBy = "aluno")
	private List<Historico> historico;

	public Aluno() {

	}

	public Aluno(String matricula, String nome, double ira, String senha) {
		this.matricula = matricula;
		this.nome = nome;
		this.ira = ira;
		this.senha = senha;
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

	public double getIra() {
		return ira;
	}

	public void setIra(double ira) {
		this.ira = ira;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void adicionaDisciplinaEmHistorico(Historico h) {
		if (historico == null) {
			historico = new ArrayList<Historico>();
		}
		historico.add(h);
	}

	public List<Historico> getHistorico() {
		return historico;
	}

	public void setHistorico(List<Historico> historico) {
		this.historico = historico;
	}
}
