package paquete;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Concurso {
	
	private int largoCarretel;
	private Bandera[] banderas;
	
	public Concurso(Scanner entrada) {
		this.largoCarretel = entrada.nextInt();
		this.banderas = new Bandera[entrada.nextInt()];
		for(int i=0; i<this.banderas.length; i++) {
			this.banderas[i] = new Bandera(entrada.nextInt());
		}
	}
	
	public int getCarretel() {
		return this.largoCarretel;
	}
	
	private void cocerBanderas() {
		boolean puedeCocer = true;
		int noPuedeCocer = 0;
		int i=0;
		while(puedeCocer == true) {
			if(this.largoCarretel > this.banderas[i].getLongitudProximoRetazo()) {
				this.largoCarretel -= this.banderas[i].getLongitudProximoRetazo();
				this.banderas[i].cocerRetazo();
			}
			else {
				noPuedeCocer++;
			}
			i++;
			if(i == this.banderas.length)
				i = 0;
			if(noPuedeCocer == this.banderas.length)
				puedeCocer = false;
		}
	}
	
	private int escuelaConBanderaMasLarga() {
		int posMayor=0;
		for(int i=1; i<this.banderas.length; i++) {
			if(this.banderas[i].getLongitudTotal() > this.banderas[posMayor].getLongitudTotal()) 
				posMayor = i;
		}
		return posMayor+1;
	}
	
	private int escuelaConBanderaConMasRetazos() {
		int posMasRetazos=0;
		for(int i=1; i<this.banderas.length; i++) {
			if(this.banderas[i].getCantidadRetazos() > this.banderas[posMasRetazos].getCantidadRetazos()) 
				posMasRetazos = i;
		}
		return posMasRetazos+1;
	}
	
	public void resolver(PrintWriter salida) {
		this.cocerBanderas();
		int escuelaGanadora = this.escuelaConBanderaMasLarga();
		salida.println(escuelaGanadora + " " + this.banderas[escuelaGanadora].getLongitudTotal());
		salida.println(this.escuelaConBanderaConMasRetazos());
		salida.println(this.getCarretel());
		//
	}
	
	public static void main(String[] args) throws IOException {
		Scanner entrada = new Scanner(new FileReader("bandera.in"));
		Concurso concurso = new Concurso(entrada);
		entrada.close();
		PrintWriter salida = new PrintWriter(new FileWriter("bandera.out"));
		concurso.resolver(salida);
		salida.close();
	}
	
}
