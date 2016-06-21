package br.unb.cic.monitoria.dominio;

import java.util.List;

import javax.persistence.EntityManager;

import br.unb.cic.monitoria.util.HibernateUtil;

/**
 * Classe que representa um repositorio de ofertas de disciplinas, como
 * operacoes que permitem acessar e manipular uma oferta de disciplina na base
 * de dados.
 * 
 * @author rbonifacio
 */
public class GerenteDeOferta {

	private static final String CONSULTA_POR_SEMESTRE_DISCIPLINA = 
			"SELECT o FROM Oferta o "
			+ "WHERE o.semestre = :pmtSemestre and "
			+ "o.disciplina.departamento.id = :pmtDepartamento";

	/**
	 * Lista a oferta de uma determinada disciplina em um semestre especifico.
	 * 
	 * @param idDisciplina identificador da disciplina
	 * @param semestre numero do semestre
	 * @return turmas ofertadas para a disciplina em um semestre especifico.
	 */
	public List<Oferta> listarOferta(Integer idDepartamento, Integer semestre) {
		System.out.println("semestre: " + semestre);
		EntityManager em = HibernateUtil.instance().em();
		return em.createQuery(CONSULTA_POR_SEMESTRE_DISCIPLINA)
				.setParameter("pmtSemestre", semestre)
				.setParameter("pmtDepartamento", idDepartamento)
				.getResultList();
	}

}
