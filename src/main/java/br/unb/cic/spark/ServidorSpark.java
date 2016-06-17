package br.unb.cic.spark;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spark.Spark;

/**
 * Classe que representa o container de 
 * micro-servicos baseado no SparkFramework, 
 * @author rbonifacio
 */
public class ServidorSpark extends Spark {
	public static void main(String args[]) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		ListaDeRecursos listaDeRecursos = (ListaDeRecursos)context.getBean("listaDeRecursos");
		List<Recurso> recursos = listaDeRecursos.getRecursos();
		
		
		for (Recurso recurso : recursos) {
			recurso.carregarCapacidades();
			for(Capacidade c : recurso.capacidades) {
				System.out.println("[UnBSpark] definindo rota " + c.getPath() + " metodo " + c.getMetodo());
				if(c.getMetodo() == Metodo.GET) {
					get(c.getPath(), c);
				}
				else if(c.getMetodo() == Metodo.POST) {
					post(c.getPath(),c);
				}
				else if(c.getMetodo() == Metodo.PUT) {
					put(c.getPath(),c);
				}
				else if(c.getMetodo() == Metodo.DELETE) {
					delete(c.getPath(),c);
				}
			}
		}
	}
}
