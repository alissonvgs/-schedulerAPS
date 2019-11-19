package br.ufpb.dcx.aps.escalonador;

import java.util.ArrayList;
import java.util.List;

public class FachadaEscalonador {

	private int tick;

	private List<String> fila = new ArrayList<String>();
	Processo processos = new Processo();

	public FachadaEscalonador(TipoEscalonador tipoEscalonador) {
	}

	public FachadaEscalonador(TipoEscalonador roundrobin, int quantum) {
	}

	public String getStatus() {
		String Inicial = "Escalonador RoundRobin;Processos: {};Quantum: 3;Tick: " + tick;
		if (fila.size() > 0) {
			return "Escalonador RoundRobin;Processos: {Fila: [" + this.fila.get(0) + "]};Quantum: 3;Tick: " + tick;
		}
		
		if (processos.size() > 0) {
			return "Escalonador RoundRobin;Processos: {Rodando: " + this.fila.get(0) + "};Quantum: 3;Tick: " + tick;
		}
		return Inicial;
		

	}

	public void tick() {
		tick++;
	}

	public void adicionarProcesso(String nomeProcesso) {
		RoundRobinObject roundRobinObject = new RoundRobinObject("P1");
		processos.criarProcesso(roundRobinObject);
		fila.add(roundRobinObject.getNome());
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