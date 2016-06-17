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
@Table(name="Disciplina")
public class Disciplina {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CD_DISCIPLINA")
	private Integer id;
	
	@Column(name="NR_DISCIPLINA")
	private Integer codigo;
	
	@Column(name="NM_DISCIPLINA")
	private String titulo;
	
	@Column(name="IN_TIPO")
	private String tipo; 

	@ManyToOne
	@JoinColumn(name="CD_DEPARTAMENTO")
	private Departamento departamento;
	
	public Disciplina() {}
	
	public Disciplina(Integer codigo, String titulo) {
		this.codigo = codigo;
		this.titulo = titulo;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
}
