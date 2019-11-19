package br.ufpb.dcx.aps.escalonador;

import java.util.ArrayList;
import java.util.List;

public class Processo {
	
	private List<RoundRobinObject> processoLista = new ArrayList<RoundRobinObject>();
	
	public void criarProcesso(RoundRobinObject roundRobinObject) {
		this.getProcessoLista().add(roundRobinObject);
	}

	public List<RoundRobinObject> getProcessoLista() {
		return processoLista;
	}

	public void setProcessoLista(List<RoundRobinObject> processoLista) {
		this.processoLista = processoLista;
	}

	public int size() {
		return processoLista.size();
	}

}
