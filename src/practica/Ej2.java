package practica;

import java.util.Scanner;

public class Ej2 {

	public static void main(String[] args) {
		String palabras[] = new String[10];
		Scanner scan = new Scanner(System.in);
		for (int i=1; i <=10; i++) {
			System.out.println("Ingrese palabra "+ i);
			palabras[i-1] = scan.nextLine();
		}
		System.out.println("Palabras en orden inverso:");
		for (int i=10; i > 0; i--) {
			System.out.println(palabras[i-1]);
			
		}
		scan.close();
	}

}
