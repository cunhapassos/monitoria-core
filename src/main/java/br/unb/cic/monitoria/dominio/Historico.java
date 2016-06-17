package br.unb.cic.monitoria.dominio;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Historico")
public class Historico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CD_HISTORICO")
	private Integer id; 
	
	@Column(name="NR_ANO_SEMESTRE")
	private Integer semestre;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="CD_ALUNO")
	private Aluno aluno;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CD_DISCIPLINA")
	private Disciplina disciplina;
	
	@Column(name="VL_MENCAO")
	private String mencao;
	
	public Historico() {}
	
	public Historico(Integer semestre, Aluno aluno, Disciplina disciplina, String mencao) {
		this.semestre = semestre;
		this.aluno = aluno;
		this.disciplina = disciplina;
		this.mencao = mencao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSemestre() {
		return semestre;
	}

	public void setSemestre(Integer semestre) {
		this.semestre = semestre;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public String getMencao() {
		return mencao;
	}

	public void setMencao(String mencao) {
		this.mencao = mencao;
	} 
	
	
}
