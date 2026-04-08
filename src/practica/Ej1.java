package practica;

public class Ej1 {

	public static void main(String[] args) {
		System.out.println("10 primeros números enteros:");
		for (int i = 1; i < 10; i++ ) {
			System.out.print(i+", ");
		}
		System.out.println();
		System.out.println("10 primeros números impares:");
		for (int i = 1; i <= 10; i++ ) {
			System.out.print((2*i)-1 + ", ");
		}
	}

}
