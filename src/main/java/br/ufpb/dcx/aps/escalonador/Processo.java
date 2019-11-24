package br.ufpb.dcx.aps.escalonador;

import java.util.ArrayList;
import java.util.List;

public class Processo {
	
	private List<String> processoLista = new ArrayList<String>();
	
	public void removerProcesso(String nome) {
		for(String r: processoLista) {
			if(r.equals(nome)){
				this.processoLista.remove(r);
			}
		}
	}
	
	public void criarProcesso(String nomeProcesso) {
		this.getProcessoLista().add(nomeProcesso);
	}

	public List<String> getProcessoLista() {
		return processoLista;
	}

	public void setProcessoLista(List<String> processoLista) {
		this.processoLista = processoLista;
	}

	public int size() {
		return processoLista.size();
	}

}
