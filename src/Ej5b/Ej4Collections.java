package Ej5b;

import java.util.Scanner;
import java.util.LinkedList;

public class Ej4Collections {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Ingrese el primer numero");
		int firstNumber = Integer.parseInt(scan.nextLine());
		LinkedList<Integer> col = new LinkedList<>(); 
		for (int i = 1; i<= 20; i++) {
			System.out.println("Ingrese el siguiente numero");
			int testNumber = Integer.parseInt(scan.nextLine());
			if (testNumber > firstNumber) col.offer(testNumber);
		}
		System.out.println("Numeros mayores al primero:");
		for (int j = 0; j< col.size(); j++) {
			System.out.println(col.get(j));
		}		
		scan.close();
	}
}
