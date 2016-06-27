package br.unb.cic.monitoria.dominio;

import javax.persistence.EntityManager;

import br.unb.cic.monitoria.util.HibernateUtil;

/**
 * Classe que representa um repositorio para os pedidos de monitoria.
 * 
 * @author rbonifacio
 * 
 */
public class GerenteMonitoria {

	private static final String CONSULTA_PEDIDO_REALIZADO = "SELECT COUNT(m.id) "
			+ "FROM Monitoria m "
			+ "WHERE m.aluno.id = :pmtIdAluno "
			+ "AND m.oferta.id = :pmtIdOferta";

	private static final String CONSULTA_SOLICITACOES_ALUNO = "SELECT COUNT(m.id)"
			+ "FROM Monitoria m "
			+ "WHERE m.aluno.id = :pmtIdAluno";
	/**
	 * Registra um novo pedido de monitoria.
	 * 
	 * @param pedidoMonitoria
	 */
	public Integer registrarPedidoMonitoria(MonitoriaVO pedidoMonitoria) {
		EntityManager em = HibernateUtil.instance().em();

		Oferta oferta = em.find(Oferta.class, pedidoMonitoria.getIdOferta());
		Aluno aluno = em.find(Aluno.class, pedidoMonitoria.getIdAluno());

		//verifica algumas regras de negocio. 
		
		if(oferta == null) {
			throw new RuntimeException("identificador da oferta invalido");
		}
		
		if(aluno == null) {
			throw new RuntimeException("identificador do aluno invalido");
		} 
		
		if (pedidoJaRealizado(aluno.getId(), oferta.getId())) {
			throw new RuntimeException("ja existe um pedido de monitoria para esse aluno / oferta");
		}
		
		if(pedidosAluno(aluno.getId()) >= 3) {
			throw new RuntimeException("aluno ja requisitou a quantidade maxima de pedidos de monitoria");
		}
		
		Monitoria m = new Monitoria();
		m.setOferta(oferta);
		m.setAluno(aluno);
		m.setRanking(0);
		m.setStatus("PV");
		m.setTipo(pedidoMonitoria.getTipo());
		
			
		em.getTransaction().begin();
		em.persist(m);
		em.flush();
		em.getTransaction().commit();
		return m.getId();
	}

	/*
	 * retorna verdadeiro caso o aluno ja tenha realizado um pedido de monitoria
	 * para uma determinada turma.
	 */
	private boolean pedidoJaRealizado(Integer idAluno, Integer idOferta) {
		EntityManager em = HibernateUtil.instance().em();
		Long pedidoRealizado = (Long) em
				.createQuery(CONSULTA_PEDIDO_REALIZADO)
				.setParameter("pmtIdAluno", idAluno)
				.setParameter("pmtIdOferta", idOferta).getSingleResult();

		return pedidoRealizado != 0;
	}
	
	/*
	 * retorna a quantidade de pedidos de monitoria ja 
	 * realizados por um aluno. 
	 */
	private Long pedidosAluno(Integer idAluno) {
		EntityManager em = HibernateUtil.instance().em();
		
		Long quantidadePedidos = (Long) em
				.createQuery(CONSULTA_SOLICITACOES_ALUNO)
				.setParameter("pmtIdAluno", idAluno)
				.getSingleResult();
		
		return quantidadePedidos;
	}

}
