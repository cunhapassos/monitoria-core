package br.unb.cic.monitoria.dominio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Classe que representa um repositorio 
 * para o conceito aluno, com metodos de 
 * @author rbonifacio
 */
public class GerenteDeAluno {

	private static final String CONSULTA_POR_MATRICULA = "select a from Aluno a "
			+ "where a.matricula = :pmtMatricula";

	public GerenteDeAluno() {
	}

	/**
	 * Realiza a autenticacao dos alunos. 
	 * 
	 * @param matricula matricula do aluno a ser autenticado
	 * @param senha senha do aluno a ser autenticado
	 * @return um aluno autenticado. 
	 */
	public Aluno autenticar(String matricula, String senha) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("hsqldb");
		EntityManager manager = factory.createEntityManager();

		List<Aluno> res = manager.createQuery(CONSULTA_POR_MATRICULA)
				.setParameter("pmtMatricula", matricula).getResultList();

		if (res.size() != 0 && res.get(0).getSenha().equals(senha)) {
			return res.get(0);
		}
		return null;

	}
}
