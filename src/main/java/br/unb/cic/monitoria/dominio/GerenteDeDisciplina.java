package br.unb.cic.monitoria.dominio;

import java.util.List;

import javax.persistence.EntityManager;

import br.unb.cic.monitoria.util.HibernateUtil;

/**
 * Representa uma abstracao que permite manipular 
 * disciplinas, em particular com metodos para recuperar 
 * disciplinas a partir da base de dados. 
 * 
 * @author rbonifacio
 */
public class GerenteDeDisciplina {
	private static final String CONSULTA_POR_CODIGO = 
			"SELECT d from Disciplina d where d.codigo = :pCodigo";
	
	/**
	 * Pesquisa uma disciplina po codigo. 
	 * @param codigo codigo da disciplina
	 * @return disciplina que satisfaz o criterio de busca.
	 */
	public Disciplina pesquisaPorCodigo(Integer codigo) {
		EntityManager em = HibernateUtil.instance().em();
		
		List<Disciplina> disciplinas = em.createQuery(CONSULTA_POR_CODIGO).setParameter("pCodigo", codigo).getResultList();
	
		if(disciplinas.size() == 1) {
			return disciplinas.get(0);
		}
		return null;
	}

}
