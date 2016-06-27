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
@Table(name="Monitoria")
public class Monitoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CD_MONITORIA")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="CD_ALUNO")
	private Aluno aluno;
	
	@ManyToOne
	@JoinColumn(name="CD_OFERTA")
	private Oferta oferta;
	
	@Column(name="NR_RANKING")
	private Integer ranking;
	
	@Column(name="TP_MONITORIA")
	private String tipo;     //V - Voluntario, A - Ambos , R - Remunerado
	
	@Column(name="ST_MONITORIA")
	private String status;   //AB- Aceito com Bolsa, AV - Aceito Voluntario , ID - Indeferido , PV - Pendente
	
	public Monitoria() {}

	public Monitoria(Integer id, Aluno aluno, Oferta oferta, Integer ranking,
			String tipo, String status) {
		this.id = id;
		this.aluno = aluno;
		this.oferta = oferta;
		this.ranking = ranking;
		this.tipo = tipo;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Oferta getOferta() {
		return oferta;
	}

	public void setOferta(Oferta oferta) {
		this.oferta = oferta;
	}

	public Integer getRanking() {
		return ranking;
	}

	public void setRanking(Integer ranking) {
		this.ranking = ranking;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
