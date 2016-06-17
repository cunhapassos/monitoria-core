package br.unb.cic.monitoria.recursos;

import java.util.List;

import spark.Request;
import spark.Response;
import br.unb.cic.monitoria.dominio.GerenteDeOferta;
import br.unb.cic.monitoria.dominio.Oferta;
import br.unb.cic.spark.Capacidade;
import br.unb.cic.spark.JSONUtil;
import br.unb.cic.spark.Metodo;
import br.unb.cic.spark.Recurso;

public class RecursoOferta extends Recurso {

	@Override
	protected void carregarCapacidades() {
		capacidades.add(new Capacidade(Metodo.GET, "/oferta") {
			public Object handle(Request req, Response resp) throws Exception {
				try {
					Integer idDisciplina = Integer.parseInt(req.queryParams("disciplina"));
				
					Integer semestre = Integer.parseInt(req.queryParams(("semestre")));
					
					GerenteDeOferta repositorio  = new GerenteDeOferta();
					
					List<Oferta> listaDeOferta = repositorio.listarOferta(idDisciplina, semestre);
					OfertaVO responseData[] = new OfertaVO[listaDeOferta.size()];
					int i = 0;
					for (Oferta oferta : listaDeOferta) {
						responseData[i++] = new OfertaVO(oferta.getId(), oferta.getDisciplina().getTitulo(),
								oferta.getProfessor().getNome(), oferta.getTurma());
					}
					
					resp.status(200);
					resp.type("application/json");
					return JSONUtil.dataToJson(responseData);
				}
				catch(Exception e) {
					e.printStackTrace();
					resp.status(500);
					return "Internal server error";
				}
			}
		});
	}

	/*
	 * Classe que representa um value-object para a oferta de uma disciplina.
	 * Util para uma conversao automatica para o formato JSON.
	 */
	static class OfertaVO {
		private Integer id;
		private String disciplina;
		private String professor;
		private String turma;

		public OfertaVO() {
		}

		public OfertaVO(Integer id, String disciplina, String professor,
				String turma) {
			this.id = id;
			this.disciplina = disciplina;
			this.professor = professor;
			this.turma = turma;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getDisciplina() {
			return disciplina;
		}

		public void setDisciplina(String disciplina) {
			this.disciplina = disciplina;
		}

		public String getProfessor() {
			return professor;
		}

		public void setProfessor(String professor) {
			this.professor = professor;
		}

		public String getTurma() {
			return turma;
		}

		public void setTurma(String turma) {
			this.turma = turma;
		}

	}

}
