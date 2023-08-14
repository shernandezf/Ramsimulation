package Caso2;
//por:Santiago Hernández – 201922432
//Dionny S. Cárdenas - 201921484
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		System.out.println("Escriba la cantidad de marcos de paginas que desea correr.");
		System.out.println("ejemplo:  8  16  32 ");
		String ramL=sc.nextLine();
		System.out.println("escriba las páginas, posibles combinaciones con el valor escrito anteriormente \n son \n 8(8,16,32,64), 16(32,64,128), 32(64)\n si no escribe una de esas combinaciones saldrá errors.");
		String pagina=sc.nextLine();
		
		Lectura lectura= new Lectura(ramL,pagina);
		ArrayList<String>datos=  lectura.getDatos();
		
		int marcos= Integer.parseInt(datos.get(0));
		MemoriaFisica ram= new MemoriaFisica(marcos);
		int paginas= Integer.parseInt(datos.get(1));
		TablaPaginas tablap= new TablaPaginas(paginas);
		//llena la ram con los marcos de pagina
		for(int i=0;i<marcos;i++){
			ram.actualizar(i, -1);
		}
		boolean[]acabe=new boolean[1];
		acabe[0]=false;
		Nru nru= new Nru(ram.getRam(), tablap.getTablaPaginas());
		ReemplazoDatos reemplazo= new ReemplazoDatos(ram, tablap, datos, nru,acabe);
		reemplazo.start();
		ActualizarVariable actualizar= new ActualizarVariable(tablap,acabe);
		actualizar.start();
	}

}
