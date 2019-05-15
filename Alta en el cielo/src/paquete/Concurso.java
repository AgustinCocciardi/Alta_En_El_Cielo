package paquete;

public class Concurso {
	
	private int largoCarretel;
	private Bandera[] banderas;
	
	public Concurso(int largoCarretel, int escuelas, int []retazos) {
		this.largoCarretel = largoCarretel;
		banderas = new Bandera[escuelas];
		for(int i =0; i<escuelas; i++) {
			this.banderas[i] = new Bandera(retazos[i]);
		}
	}
	
	public void resolver() {
		
	}
	
	public static void main(String[] args) {
		
	}
	
}
