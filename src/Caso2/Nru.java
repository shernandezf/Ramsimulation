package Caso2;

import java.util.HashMap;



public class Nru {
	private HashMap<Integer, Integer> ram;

	private int[][] tablaPaginas;
	public Nru(HashMap<Integer, Integer> ram, int[][] tp){
		this.ram=ram;
		tablaPaginas=tp;
	}
	//revisa si la página buscada está en ram
	public boolean estaEnRam(int pagina){
		if(ram.containsValue(pagina)){
			return true;
		}else{
			return false;
		}
	}
	//revisa si hay un espacio libre en la ram para añadir la página
	public int posLibreRAM(){
		boolean encontre=false; 
		int retorno=-1;
		for(int i=0;i<ram.size()&&encontre==false;i++){
			if(ram.get(i)==-1){
				
				encontre=true;
				retorno=i;
			}
		}

		return retorno;
	}
	//encuentra la página que toca retirar en base a las clases del algoritmo
	public int darMenorValorTP(){
		int menor=12;
		int posicion=-1;
		for(int i=0; i<tablaPaginas.length;i++){
			if(tablaPaginas[i][3]<menor&&(tablaPaginas[i][0]!=-1)){
				menor=tablaPaginas[i][3];
				posicion=i;
			}

		}
		return posicion;
	}
	


}
