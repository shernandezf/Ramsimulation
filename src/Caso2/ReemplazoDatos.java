package Caso2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ReemplazoDatos extends Thread {

	private MemoriaFisica ram;

	private ArrayList<String>datos;

	private TablaPaginas tabla;


	private Nru algoritmoReemplazo;
	private int cantidadfallos=0;
	private boolean[]acabe;
	
	public ReemplazoDatos(MemoriaFisica ram, TablaPaginas tabla,ArrayList<String>datos, Nru nru,boolean[]acabe){
		this.ram=ram;
		this.datos=datos;
		this.tabla=tabla;
		algoritmoReemplazo=nru;
		this.acabe=acabe;
	}
	
	int contador=0;
	public void run(){
		for(int i=3;i<datos.size();i++){
			System.out.println("+++++++++++++++++");
			String dato=datos.get(i);
			String[]linea=dato.split(",");
			int pagina=Integer.parseInt(linea[0]);

			//verifica si está en la ram
			if(algoritmoReemplazo.estaEnRam(pagina)){

				System.out.println("Está en la ram");
			}else{
				cantidadfallos++;
				System.out.println("no esta en la ram + fallos");
				//intentar buscar espacio en la ram
				int marcopagina=algoritmoReemplazo.posLibreRAM();

				//si la ram está llena, se busca la página a reemplazar

				if(marcopagina==-1){
					System.out.println("no hay espacio en la ram//////");
					int posicionreemplazar=algoritmoReemplazo.darMenorValorTP();

					int marcoReemplazo=tabla.getTablaPaginas()[posicionreemplazar][0];
					// se borra la ram anterior y se actualiza por la ram nueva
					System.out.println("marco de reemplazo:"+marcoReemplazo);
					ram.actualizar(marcoReemplazo, pagina);
					//la página que se acaba de remover recibe un valor de -1
					tabla.actualizartabla(posicionreemplazar, -1);
					//la página que se agregó a la RAM recibe el valor del marco al que le fue asignado

					tabla.actualizartabla(pagina, marcoReemplazo);
				}else{
					System.out.println("hay espacio en la RAM y actualiza valores");
					ram.actualizar(marcopagina, pagina);
					//la página que se agregó a la RAM recibe el valor del marco al que le fue asignado
					tabla.actualizartabla(pagina, marcopagina);
				}

			}
			if(tabla.getTablaPaginas()[pagina][1]==0){

				tabla.añadirReferencia(pagina);
			}else{
				tabla.añadirModificacion(pagina);
			}
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("lectura del archivo:  "+contador);
			System.out.println(Arrays.asList( ram.getRam()));
			System.out.println("cantidad de fallos: "+cantidadfallos);
			contador++;

			print2D(tabla.getTablaPaginas());	

			
			System.out.println("----------------------");
		}
		
		acabe[0]=true;
		System.out.println("la cantidad de fallos fue de: "+cantidadfallos);

	}
	public static void print2D(int mat[][])
	{
		// Loop through all rows
		for (int[] row : mat)

			// converting each row as string
			// and then printing in a separate line
			System.out.println(Arrays.toString(row));
	}


}
