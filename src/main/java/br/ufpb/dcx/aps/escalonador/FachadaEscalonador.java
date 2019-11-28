package br.ufpb.dcx.aps.escalonador;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FachadaEscalonador {
	
	protected TipoEscalonador tipoEscalonador;
	private int tick;
	protected int quantum;
	protected int contador;
	protected String rodando;
	protected String serFinalizado;
	//Queue é um tipo de Lista que tem metodos que funcionam como uma Fila, ou seja, não precisa de uma classe Fila
	protected Queue<String> listaProcesso;
	protected List<String> fila = new ArrayList<String>();
	
	
	public FachadaEscalonador( TipoEscalonador tipoEscalonador ){
		
		this.quantum = 3;
		this.tick = 0;
		this.tipoEscalonador = tipoEscalonador;
		this.listaProcesso = new LinkedList<String>();
		
	}
	public FachadaEscalonador( TipoEscalonador roundrobin, int quantum ) {
		
		this.quantum = quantum;
		this.tick = 0;
		this.tipoEscalonador = roundrobin;
		this.listaProcesso = new LinkedList<String>();
	}	
	public String getStatus() {

		String resultado = "Escalonador " + tipoEscalonador + ";";
		resultado += "Processos: {";
		if (rodando != null) resultado += "Rodando: " + rodando;
		if (listaProcesso.size() > 0 || fila.size() > 0) {
			
			if (rodando != null) resultado += ", ";		
			if (fila.size() > 0) {
				resultado += "Fila: " + fila.toString();
			} else {
				resultado += "Fila: " + listaProcesso.toString();
			}
		}
		resultado += "};Quantum: " + quantum + ";";
		resultado += "Tick: " + tick;
		return resultado;
	}
	public void tick() {
		
		this.tick++;
		if (contador + quantum == tick) {
			listaProcesso.add(rodando);
			rodando = listaProcesso.poll();
			contador = tick;
		}
		if (rodando == null) {
			if (listaProcesso.size() != 0) {
				rodando = listaProcesso.poll();
				if (listaProcesso.size() > 0) contador = tick;			
			}
		}
		if(serFinalizado != null) {
			listaProcesso.remove(serFinalizado);
		}
	}
	public void adicionarProcesso( String nomeProcesso ) {		
		listaProcesso.add(nomeProcesso);
	}
	public void adicionarProcesso(String nomeProcesso, int prioridade) {
		
	}
	public void finalizarProcesso(String nomeProcesso) {		
		serFinalizado = nomeProcesso;
	}
	public void bloquearProcesso(String nomeProcesso) {
		
	}
	public void retomarProcesso(String nomeProcesso) {
		
	}
	public void adicionarProcessoTempoFixo(String nomeProcesso, int duracao) {

	}
}
