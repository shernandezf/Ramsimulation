package Caso2;

public class ActualizarVariable extends Thread {
	private TablaPaginas tablapaginas;
	boolean[]acabe;

	public ActualizarVariable(TablaPaginas tabla,boolean[]acabe){
		tablapaginas=tabla;
		this.acabe=acabe;
	}
	public void run(){
		while(true){
			
			tablapaginas.limpiar();
			
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(acabe[0]){
				break;
			}
		}
	
		System.out.println("el programa ha finalizado correctamente");
	}
	
}
