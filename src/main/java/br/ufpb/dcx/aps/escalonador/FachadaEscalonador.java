package br.ufpb.dcx.aps.escalonador;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import java.util.ArrayList;
import java.util.List;

public class FachadaEscalonador {

	protected TipoEscalonador tipoEscalonador;
	private int tick;
	private int quantum;
	private int controlador;

	private String rodando;
	private String processoParaSerFinalizado;
	private Queue<String> listaProcesso;
	private List<String> fila = new ArrayList<String>();

	private String resultado;

	public FachadaEscalonador(TipoEscalonador tipoEscalonador) {

		if (tipoEscalonador == null)
			throw new EscalonadorException();
		this.quantum = 3;
		this.tick = 0;
		this.tipoEscalonador = tipoEscalonador;
		this.listaProcesso = new LinkedList<String>();

	}

	public FachadaEscalonador(TipoEscalonador roundrobin, int quantum) {

		if (quantum <= 0)
			throw new EscalonadorException();
		this.quantum = quantum;
		this.tick = 0;
		this.tipoEscalonador = roundrobin;
		this.listaProcesso = new LinkedList<String>();
	}

	public String getStatus() {

		System.err.println("getstauts >");

		resultado = "Escalonador " + this.tipoEscalonador + ";";
		resultado += "Processos: {";
		if (rodando != null)
			resultado += "Rodando: " + this.rodando;
		if (listaProcesso.size() > 0 || fila.size() > 0) {

			if (rodando != null)
				resultado += ", ";
			if (fila.size() > 0) {
				resultado += "Fila: " + this.fila.toString();
			} else {
				resultado += "Fila: " + this.listaProcesso.toString();
			}
		}
		resultado += "};Quantum: " + this.quantum + ";";
		resultado += "Tick: " + this.tick;
		System.out.println(resultado);
		return resultado;
	}

	public void tick() {

		this.tick++;
		if (this.controlador > 0 && (this.controlador + this.quantum) == this.tick) {
			this.listaProcesso.add(rodando);
			this.rodando = this.listaProcesso.poll();
			this.controlador = this.tick;
		}
		if (this.rodando == null) {
			if (this.listaProcesso.size() != 0) {
				this.rodando = this.listaProcesso.poll();
				if (listaProcesso.size() > 0)
					this.controlador = this.tick;
			}
		}
	}

	public void adicionarProcesso(String nomeProcesso) {

		if (nomeProcesso == null)
			throw new EscalonadorException();
		if (listaProcesso.contains(nomeProcesso))
			throw new EscalonadorException();
		this.listaProcesso.add(nomeProcesso);
		System.err.println("Processo add> " + nomeProcesso);
	}

	public void adicionarProcesso(String nomeProcesso, int prioridade) {

		if (tipoEscalonador == TipoEscalonador.RoundRobin)
			throw new EscalonadorException();
	}

	public void finalizarProcesso(String nomeProcesso) {
		if (!listaProcesso.contains(nomeProcesso) && rodando == null)
			throw new EscalonadorException();

		System.err.println("Finalizar processo >" + listaProcesso);
		System.err.println("Rodando:" + rodando);
		System.out.println("Fila:" + fila.toString());
		System.out.println("LProcesso:" + listaProcesso.toString());
		System.err.println("prev>" + resultado);

		if (listaProcesso.size() == 0) {
			System.out.println("Processo nulo");
		} else {
			System.err.println("Tem Processo");
			String var = resultado.replace("Rodando: " + rodando, "");
			resultado = var;
			fila.remove(nomeProcesso);
			System.err.println("Next>" + getStatus().toString());
		}

	}

	public void bloquearProcesso(String nomeProcesso) {

	}

	public void retomarProcesso(String nomeProcesso) {

	}

	public void adicionarProcessoTempoFixo(String nomeProcesso, int duracao) {

	}

	public TipoEscalonador escalonadorRoundRobin() {
		return TipoEscalonador.RoundRobin;
	}

	public TipoEscalonador getTipoEscalonador() {
		return tipoEscalonador;
	}

	public void setTipoEscalonador(TipoEscalonador tipoEscalonador) {
		this.tipoEscalonador = tipoEscalonador;
	}
}