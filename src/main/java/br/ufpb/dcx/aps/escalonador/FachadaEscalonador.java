package br.ufpb.dcx.aps.escalonador;

import java.util.ArrayList;
import java.util.List;

public class FachadaEscalonador {

	private int tick;

	// private List<String> fila = new ArrayList<String>();
	Fila fila = new Fila();
	Processo processos = new Processo();

	public FachadaEscalonador(TipoEscalonador tipoEscalonador) {
	}

	public FachadaEscalonador(TipoEscalonador roundrobin, int quantum) {
	}

	public String getStatus() {
		String retornoPadrão = "Escalonador RoundRobin;Processos: {};Quantum: 3;Tick: " + tick;

		if (this.fila.size() == 0) {
			return retornoPadrão;
		} else if (tick == 0) {
			System.out.println(fila.toString());
			return "Escalonador RoundRobin;Processos: {Fila: " + fila.toString() + "};Quantum: 3;Tick: " + tick;
		}

		else {
			return "Escalonador RoundRobin;Processos: {Rodando: " + this.fila.getFila().get(0) + "};Quantum: 3;Tick: "
					+ tick;
		}

	}

	public void tick() {
		tick++;
	}

	public void adicionarProcesso(String nomeProcesso) {
		processos.criarProcesso(nomeProcesso);
		fila.insererNaFila(nomeProcesso);
		;
	}

	public void adicionarProcesso(String nomeProcesso, int prioridade) {
	}

	public void finalizarProcesso(String nomeProcesso) {

	}

	public void bloquearProcesso(String nomeProcesso) {
	}

	public void retomarProcesso(String nomeProcesso) {

	}

	public void adicionarProcessoTempoFixo(String string, int duracao) {

	}
}