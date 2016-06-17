package br.unb.cic.spark;

/**
 * Classe que define um conjunto de constantes 
 * com os codigos tipicamente retornados em 
 * requisicoes HTTP. 
 * 
 * @author rbonifacio
 */
public class CodigoDeRetorno {
	
	public static int SUCESSO = 200;
	public static int RECURSO_NAO_ENCONTRADO = 404;
	public static int NAO_AUTORIZADO = 401;
	public static int ERRO_INTERNO_SERVIDOR = 500;
}
