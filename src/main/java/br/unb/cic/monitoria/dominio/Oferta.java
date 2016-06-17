package br.unb.cic.monitoria.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Oferta")
public class Oferta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CD_OFERTA")
	private Integer id;

	@ManyToOne
	@JoinColumn(name="CD_PROFESSOR")
	private Professor professor; 
	
	@ManyToOne
	@JoinColumn(name="CD_DISCIPLINA")
	private Disciplina disciplina; 
	
	@Column(name="NR_ANO_SEMESTRE")
	private Integer semestre;
	
	@Column(name="DS_TURMA")
	private String turma;
	
	@Column(name="NR_ALUNOS")
	private int quantidadeDeAlunos;
	
	public Oferta() { }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Integer getSemestre() {
		return semestre;
	}

	public void setSemestre(Integer semestre) {
		this.semestre = semestre;
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

	public int getQuantidadeDeAlunos() {
		return quantidadeDeAlunos;
	}

	public void setQuantidadeDeAlunos(int quantidadeDeAlunos) {
		this.quantidadeDeAlunos = quantidadeDeAlunos;
	}
	
}
