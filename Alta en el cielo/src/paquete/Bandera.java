package paquete;

public class Bandera {
	
	private int longitudProximoRetazo;
	private int longitudTotal;
	private int retazos;
	
	public Bandera(int longitudRetazo) {
		this.longitudProximoRetazo = longitudRetazo;
		this.longitudTotal = 0;
		this.retazos = 0;
	}
	
	public int getLongitudProximoRetazo() {
		return this.longitudProximoRetazo;
	}
	
	private int obtenerProximaLongitud() {
		int numero = 0, i = 0;
		String retazo = Integer.toString(longitudProximoRetazo);
		while( i < retazo.length() ) {
			numero += retazo.charAt(i++);
		}
		return numero;
	}
	
	public void cocerRetazo() {
		this.retazos++;
		this.longitudTotal += this.longitudProximoRetazo;
		this.longitudProximoRetazo += this.obtenerProximaLongitud();
	}
	
}
