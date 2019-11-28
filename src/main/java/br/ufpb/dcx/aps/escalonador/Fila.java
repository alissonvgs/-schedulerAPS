package br.ufpb.dcx.aps.escalonador;

import java.util.ArrayList;
import java.util.List;

public class Fila {

	private List<String> fila = new ArrayList<String>();

	public List<String> getFila() {
		return fila;
	}

	public void insererNaFila(String nomeProcesso) {
		this.fila.add(nomeProcesso);
	}

	public void remover(String nomeProcesso) {
		for (int i = 0; i < fila.size(); i++) {
			if (fila.get(i).equals(nomeProcesso)) {
				this.getFila().remove(i);
			}
		}
	}

	public void removerDaFila(String nome) {
		for (String r : fila) {
			if (r.equals(nome)) {
				this.getFila().remove(r);
			}
		}
	}

	public boolean vazia() {
		return this.fila.size() == 0;
	}

	public int size() {
		return this.fila.size();
	}

	@Override
	public String toString() {
		return "" + fila + "";
	}

}