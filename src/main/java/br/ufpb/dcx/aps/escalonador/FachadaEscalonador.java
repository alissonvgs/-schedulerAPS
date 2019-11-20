package br.ufpb.dcx.aps.escalonador;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FachadaEscalonador {
	
	protected TipoEscalonador tipoEscalonador;
	private int tick;
	protected int quantum;
	protected int duracaoFixa;
	protected String rodando;
	protected ArrayList<String> processoBloqueado;
	protected Queue<String> listaProcesso;
	protected List<String> fila = new ArrayList<String>();
	protected List<Integer> filaDuracao = new ArrayList<Integer>();
	protected List<String> processoRetomado = new ArrayList<String>();

	public FachadaEscalonador( TipoEscalonador tipoEscalonador ){
		
		if( tipoEscalonador == null ) throw new EscalonadorException();	
		this.quantum = 3;
		this.tick = 0;
		this.tipoEscalonador = tipoEscalonador;
		this.listaProcesso = new LinkedList<String>();
		this.processoBloqueado = new ArrayList<String>();
	}
	public FachadaEscalonador( TipoEscalonador roundrobin, int quantum ) {
		
		if(quantum <= 0) throw new EscalonadorException();
		this.quantum = quantum;
		this.tick = 0;
		this.tipoEscalonador = roundrobin;
		this.listaProcesso = new LinkedList<String>();
		this.processoBloqueado = new ArrayList<String>();
	}	
	public String getStatus() {

		String resultado = "";
		resultado += "Escalonador " + this.tipoEscalonador + ";";
		resultado += "Processos: {";
		if (rodando != null) resultado += "Rodando: " + this.rodando;
		if (listaProcesso.size() > 0 || fila.size() > 0) {
			
			if (rodando != null) resultado += ", ";		
			if (fila.size() > 0) {
				resultado += "Fila: " + this.fila.toString();
			} else {
				resultado += "Fila: " + this.listaProcesso.toString();
			}
		}
		if (this.processoBloqueado.size() > 0) {
			
			if (rodando != null || listaProcesso.size() > 0) resultado += ", ";
			resultado += "Bloqueados: " + this.processoBloqueado.toString();
		}
	
		resultado += "};Quantum: " + this.quantum + ";";
		resultado += "Tick: " + this.tick;
		return resultado;
	}
	public void tick() {
		
		this.tick++;
		
	}
	public void adicionarProcesso( String nomeProcesso ) {
			
	}
	public void adicionarProcesso(String nomeProcesso, int prioridade) {
			
	}
	public void finalizarProcesso(String nomeProcesso) {
		
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
