package practica;

import java.util.Scanner;

public class Ej3 {

	public static void main(String[] args) {
		String palabras[] = new String[10];
		boolean isPalabraOnArray=false;
		Scanner scan = new Scanner(System.in);
		for (int i=1; i <=10; i++) {
			System.out.println("Ingrese palabra "+ i);
			palabras[i-1] = scan.nextLine();
		}
		System.out.println("Ingrese la ultima palabra");
		String ultimaPalabra = scan.nextLine();
		for (int i=1; i <=10; i++) {
			if (palabras[i-1].equals(ultimaPalabra)) 
				isPalabraOnArray=true;
		}
		scan.close();
		if (isPalabraOnArray) {
		System.out.println("la palabra ya fue ingresada");}
		

	}

}
