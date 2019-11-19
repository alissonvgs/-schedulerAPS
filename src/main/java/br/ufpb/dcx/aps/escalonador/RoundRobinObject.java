package br.ufpb.dcx.aps.escalonador;

public class RoundRobinObject {

	private String nome;
	private int quantum;

	public RoundRobinObject(String nome) {
		this.nome = nome;
		this.quantum = quantum;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuantum() {
		return quantum;
	}

	public void setQuantum(int quantum) {
		this.quantum = quantum;
	}

}
