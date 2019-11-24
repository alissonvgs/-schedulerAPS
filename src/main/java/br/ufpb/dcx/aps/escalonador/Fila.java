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

	public void removerDaFila(String nome) {
		for(String r: fila) {
			if(r.equals(nome)){
				this.fila.remove(r);
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