package br.unb.cic.monitoria.recursos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import spark.Request;
import spark.Response;
import br.unb.cic.monitoria.dominio.Aluno;
import br.unb.cic.monitoria.dominio.Disciplina;
import br.unb.cic.monitoria.dominio.Professor;
import br.unb.cic.spark.Capacidade;
import br.unb.cic.spark.Metodo;
import br.unb.cic.spark.Recurso;

public class RecursoPopulaDB extends Recurso {

	@Override
	protected void carregarCapacidades() {
		capacidades.add(new Capacidade(Metodo.POST, "/populaDB") {
			public Object handle(Request req, Response resp) throws Exception {
				resp.status(200);
				
				try {
					insereAlunosTeste();
					insereProfessoresTeste();
					insereDisciplinas();
					return "done";
				}
				catch(Exception e) {
					return e.getMessage();
				}
			}

			private void insereDisciplinas() {
				EntityManagerFactory factory = Persistence.createEntityManagerFactory("hsqldb");
				EntityManager manager = factory.createEntityManager();
				
				manager.getTransaction().begin();
				manager.createQuery("delete from Disciplina").executeUpdate();
							
				Disciplina d1 = new Disciplina(113034, "Calculo I");
				Disciplina d2 = new Disciplina(113476, "Algoritmos e Prog. de Computadores");
				Disciplina d3 = new Disciplina(113468, "Introducao aos Sistemas Computacionais");
				Disciplina d4 = new Disciplina(116726, "Informatica e Sociedade");
				
				manager.persist(d1);
				manager.persist(d2);
				manager.persist(d3);
				manager.persist(d4);
				
				manager.getTransaction().commit();
			}

			private void insereProfessoresTeste() {
				EntityManagerFactory factory = Persistence.createEntityManagerFactory("hsqldb");
				EntityManager manager = factory.createEntityManager();
				
				manager.getTransaction().begin();
				manager.createQuery("delete from Professor").executeUpdate();
				
				Professor p1 = new Professor("123", "Professor 01", "123");
				Professor p2 = new Professor("456", "Professor 02", "456");
				Professor p3 = new Professor("789", "Professor 03", "789");
				Professor p4 = new Professor("987", "Professor 04", "987");
				
				manager.persist(p1);
				manager.persist(p2);
				manager.persist(p3);
				manager.persist(p4);
				
				manager.getTransaction().commit();
				
			}

			private void insereAlunosTeste() {
				EntityManagerFactory factory = Persistence.createEntityManagerFactory("hsqldb");
				EntityManager manager = factory.createEntityManager();
				
				manager.getTransaction().begin();
				manager.createQuery("delete from Historico").executeUpdate();
				manager.createQuery("delete from Aluno").executeUpdate();
				
				Aluno alunoTeste1 = new Aluno("123", "rbonifacio", 4.3, "123");
				Aluno alunoTeste2 = new Aluno("456", "hbonifacio", 4.5, "456");
				Aluno alunoTeste3 = new Aluno("789", "ibonifacio", 4.5, "789");
				Aluno alunoTeste4 = new Aluno("987", "jbonifacio", 4.5, "987");
				Aluno alunoTeste5 = new Aluno("654", "kbonifacio", 4.5, "654");
				
				manager.persist(alunoTeste1);
				manager.persist(alunoTeste2);
				manager.persist(alunoTeste3);
				manager.persist(alunoTeste4);
				manager.persist(alunoTeste5);
				
				manager.getTransaction().commit();
			}
		});
	}

}
