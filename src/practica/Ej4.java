package practica;

import java.util.Scanner;

public class Ej4 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Ingrese el primer numero");
		int firstNumber = Integer.parseInt(scan.nextLine());
		int numbers[] = new int[20];
		int count = 0;
		for (int i = 1; i<= 20; i++) {
			System.out.println("Ingrese el siguiente numero");
			int testNumber = Integer.parseInt(scan.nextLine());
			if (testNumber > firstNumber) {
				numbers[count]= testNumber; 
				count++;
			}
		}
		for (int i : numbers) {
			if (i==0) {break;}
			System.out.print(i+", ");
		}
		scan.close();
	}
}
