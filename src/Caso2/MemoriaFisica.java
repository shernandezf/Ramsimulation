package Caso2;

import java.util.HashMap;

public class MemoriaFisica {

	private HashMap<Integer,Integer> ram;
	
	public MemoriaFisica(int marcosPagina){
		ram= new HashMap<>(marcosPagina);
		
		
	}
	public HashMap<Integer, Integer> getRam() {
		return ram;
	}
	public synchronized void setRam(HashMap<Integer, Integer> ram) {
		this.ram = ram;
	}
	public synchronized void Contains(int valor){
		ram.containsValue(valor);
	}
	public synchronized void actualizar(int marco, int pagina){
		ram.put(marco, pagina);
		
	}
	
	
	
}
