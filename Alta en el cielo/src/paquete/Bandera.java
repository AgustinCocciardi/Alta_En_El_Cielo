package paquete;

import java.util.ArrayList;

public class Bandera {
	
	private int longitudProximoRetazo;
	private int longitudTotal;
	private int retazos;
	private ArrayList<Integer> subsecuencias; 
	
	public Bandera(int longitudRetazo) {
		this.longitudProximoRetazo = longitudRetazo;
		this.longitudTotal = 0;
		this.retazos = 0;
		this.subsecuencias = new ArrayList<Integer>();
	}
	
	public int getLongitudProximoRetazo() {
		return this.longitudProximoRetazo;
	}
	
	public int getLongitudTotal() {
		return this.longitudTotal;
	}
	
	public int getCantidadRetazos() {
		return this.retazos;
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
		this.subsecuencias.add(this.longitudProximoRetazo);
		this.longitudProximoRetazo += this.obtenerProximaLongitud();
	}
	
	
	
}
