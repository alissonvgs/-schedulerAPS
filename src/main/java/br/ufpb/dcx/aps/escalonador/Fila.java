package br.ufpb.dcx.aps.escalonador;

import java.util.ArrayList;
import java.util.List;

public class Fila {

	private List<RoundRobinObject> fila = new ArrayList<RoundRobinObject>();

	
	public String getNomeDoObjeto() {
		for(RoundRobinObject r: this.fila) {
				return r.getNome();
		}
		return null;
	}
	
	public List<RoundRobinObject> getFila() {
		return fila;
	}

	public void insererNaFila(RoundRobinObject roundRobinObject) {
		this.fila.add(roundRobinObject);
	}

	public Object remove() {
		return this.fila.remove(0);
	}

	public boolean vazia() {
		return this.fila.size() == 0;
	}

	public int size() {
		return this.fila.size();
	}
	
	@Override
	public String toString() {
		
		return super.toString();
	}
}