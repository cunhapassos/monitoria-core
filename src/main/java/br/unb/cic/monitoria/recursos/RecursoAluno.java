package br.unb.cic.monitoria.recursos;

import spark.Request;
import spark.Response;
import br.unb.cic.monitoria.dominio.Aluno;
import br.unb.cic.monitoria.dominio.GerenteDeAluno;
import br.unb.cic.spark.Capacidade;
import br.unb.cic.spark.CodigoDeRetorno;
import br.unb.cic.spark.JSONUtil;
import br.unb.cic.spark.Metodo;
import br.unb.cic.spark.Recurso;

/**
 * Classe que representa um recurso REST com 
 * capacidades para lidar com o conceito Aluno. 
 * 
 * @author rbonifacio
 */
public class RecursoAluno extends Recurso {

	@Override
	protected void carregarCapacidades() {
		capacidades.add(new Capacidade(Metodo.GET, "/aluno/autenticar") {
		
			public Object handle(Request req, Response resp) throws Exception {
				try {
					String matricula = req.queryParams("matricula");
					
					String senha = req.queryParams("senha");
					
					GerenteDeAluno repositorio = new GerenteDeAluno();
						
					Aluno aluno = repositorio.autenticar(matricula, senha);
						
					if(aluno == null) {
						resp.status(CodigoDeRetorno.NAO_AUTORIZADO);
						return "Unauthorized";
					}
					else {
						resp.status(CodigoDeRetorno.SUCESSO);
						resp.type("application/json");
						return JSONUtil.dataToJson(new AlunoVO(aluno.getId(), aluno.getNome(), aluno.getIra()));
					}
				}catch(Exception e) {
					e.printStackTrace();
					throw e;
				}
			}
		});	
	}
	
	/*
	 * Classe que representa um VO para o conceito 
	 * aluno. 
	 */
	static class AlunoVO {
		private Integer id;
		private String nome;
		private Double ira;
		
		public AlunoVO() {}
		
		public AlunoVO(Integer id, String nome, Double ira) {
			this.id = id;
			this.nome = nome;
			this.ira = ira;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public Double getIra() {
			return ira;
		}
		public void setIra(Double ira) {
			this.ira = ira;
		}
		
		
	}

}
