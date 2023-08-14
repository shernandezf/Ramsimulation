package Caso2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Lectura {

	private ArrayList<String>datos;
	
	private String ram;
	private String pagina;
	
	public Lectura(String ram,String pagina){
			datos=new ArrayList<>(503);
			this.ram=ram;
			this.pagina=pagina;
			cargarDatos();
			
	}
	public void cargarDatos() {
		String path="./data/referencias"+ram+"_"+pagina+"_75.txt";
		
		File file= new File(path);
		try {
			BufferedReader br= new BufferedReader(new FileReader(file));
			String st;
			int contador=0;
			while((st = br.readLine()) != null){
				
				datos.add(contador, st);
				contador++;
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("no se encontró el archivo");
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ArrayList<String> getDatos() {
		return datos;
	}
	public void setDatos(ArrayList<String> datos) {
		this.datos = datos;
	}
}
