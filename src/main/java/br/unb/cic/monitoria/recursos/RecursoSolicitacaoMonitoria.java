package br.unb.cic.monitoria.recursos;

import lombok.Data;

import com.fasterxml.jackson.databind.ObjectMapper;

import spark.Request;
import spark.Response;
import br.unb.cic.monitoria.dominio.GerenteMonitoria;
import br.unb.cic.monitoria.dominio.MonitoriaVO;
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

					MonitoriaVO vo = new MonitoriaVO(sm.idOferta, sm.getIdAluno(), sm.getTipo());
					
					GerenteMonitoria repositorio = new GerenteMonitoria();
					
					Integer id = repositorio.registrarPedidoMonitoria(vo);
					
					resp.status(200);
					
					return id; //repositorio.solicitarPedido(sm.idAluno, sm.idTurma, sm.opcao);
				} catch (Exception e) {
					resp.status(400);
					return e.getMessage();
				}
			}
		});

	}

	/*
	 * classe auxiliar que permite extrair informacoes de 
	 * a requisicao REST para registrar interesse em 
	 * monitoria utilizando o metodo POST
	 */
	static class SolicitacaoMonitoria {
		int idAluno;
		int idOferta;
		String tipo;
		
		public SolicitacaoMonitoria() {
			
		}
		
		public SolicitacaoMonitoria(int idAluno, int idOferta, String tipo) {
			this.idAluno = idAluno;
			this.idOferta = idOferta;
			this.tipo = tipo;
		}
		
		public int getIdAluno() {
			return idAluno;
		}
		
		public void setIdAluno(int idAluno) {
			this.idAluno = idAluno;
		}
		
		public int getIdOferta() {
			return idOferta;
		}
		
		public void setIdOferta(int idOferta) {
			this.idOferta = idOferta;
		}
		
		public String getTipo() {
			return tipo;
		}
		
		public void setTipo(String tipo) {
			this.tipo = tipo;
		}
	}

}