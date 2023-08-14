package Caso2;

public class TablaPaginas {


	private int[][] tablaPaginas;
	private int indicemenor;
	public TablaPaginas(){
		llenar();
	}
	public int[][] getTablaPaginas() {
		return tablaPaginas;
		
	}
	public void llenar(){
		for(int i=0;i<tablaPaginas.length; i++){
			tablaPaginas[i][0]=-1;
			
		}
	}
	public synchronized  void setTablaPaginas(int[][] tablaPaginas) {
		this.tablaPaginas = tablaPaginas;
	}

	public TablaPaginas(int paginas ) {
		tablaPaginas= new int[paginas+1][4];
	}
	//actualiza los valores de la columna r a 0
	public synchronized void limpiar(){
		for(int i=0;i<tablaPaginas.length; i++){
			tablaPaginas[i][1]=0;
			calcularsuma(i);
		}
	}
	public synchronized void actualizartabla(int pagina, int marco){
		tablaPaginas[pagina][0]=marco;
	}
	public synchronized void añadirReferencia(int pagina){
		tablaPaginas[pagina][1]=1;
		calcularsuma(pagina);
	}
	public synchronized void añadirModificacion(int pagina){
		tablaPaginas[pagina][2]=1;
		calcularsuma(pagina);
	}
	public void calcularsuma(int pagina){
		tablaPaginas[pagina][3]=(tablaPaginas[pagina][1]*10)+tablaPaginas[pagina][2];
	}
	
}
