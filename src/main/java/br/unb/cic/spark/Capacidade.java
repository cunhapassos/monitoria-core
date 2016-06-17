package br.unb.cic.spark;

import spark.Route;

/**
 * Classe abstrata que representacao uma 
 * Capacidade de um micro-servico, 
 * usando o framework Spark. 
 * 
 * @author rbonifacio
 */
public abstract class Capacidade implements Route {
	
	private Metodo metodo;
	private String path;
	
	public Capacidade(Metodo metodo, String path) {
		this.metodo = metodo;
		this.path = path;
	}

	public Metodo getMetodo() {
		return metodo;
	}

	public String getPath() {
		return path;
	}
}
