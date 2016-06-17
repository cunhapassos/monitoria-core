package br.unb.cic.monitoria.recursos;

import lombok.Data;

import com.fasterxml.jackson.databind.ObjectMapper;

import spark.Request;
import spark.Response;
import br.unb.cic.monitoria.dominio.GerenteMonitoria;
import br.unb.cic.spark.Capacidade;
import br.unb.cic.spark.Metodo;
import br.unb.cic.spark.Recurso;

public class RecursoSolicitacaoMonitoria extends Recurso {

	@Override
	protected void carregarCapacidades() {

		capacidades.add(new Capacidade(Metodo.POST, "/solicitacaoMonitoria") {

			@Override
			public Object handle(Request req, Response resp) throws Exception {
				System.out.println(req.body());

				try {
					ObjectMapper om = new ObjectMapper();
					
					SolicitacaoMonitoria sm = om.readValue(req.body(), SolicitacaoMonitoria.class);
					
					System.out.println(sm);
					
					resp.status(200);
					
					GerenteMonitoria repositorio = new GerenteMonitoria();
					
					return null; //repositorio.solicitarPedido(sm.idAluno, sm.idTurma, sm.opcao);
				} catch (Exception e) {
					e.printStackTrace();
					resp.status(500);
					return e.getMessage();
				}
			}
		});

	}

	static class SolicitacaoMonitoria {
		int idAluno;
		int idTurma;
		int opcao;
		
		
		public SolicitacaoMonitoria() {
			
		}
		public SolicitacaoMonitoria(int idAluno, int idTurma, int opcao) {
			this.idAluno = idAluno;
			this.idTurma = idTurma;
			this.opcao = opcao;
		}
		public int getIdAluno() {
			return idAluno;
		}
		public void setIdAluno(int idAluno) {
			this.idAluno = idAluno;
		}
		public int getIdTurma() {
			return idTurma;
		}
		public void setIdTurma(int idTurma) {
			this.idTurma = idTurma;
		}
		public int getOpcao() {
			return opcao;
		}
		public void setOpcao(int opcao) {
			this.opcao = opcao;
		}

		
	}

}