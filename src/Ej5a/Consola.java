package Ej5a;

import java.util.Scanner;

public class Consola {

	public static void main(String[] args) {
		int c = 1;
		int lastPosition = 0;
		Empleado empleados[] = new Empleado[20];
		Scanner s = new Scanner(System.in);
		while (c == 1) {
		System.out.println("El empleado a cargar es Administrativo(0) o Vendedor(1)?");
		
		int inte = Integer.parseInt(s.nextLine());
		System.out.println("Ingresar dni");
		int dni = Integer.parseInt(s.nextLine());
		System.out.println("Ingresar nombre");
		String nombre = s.nextLine();
		System.out.println("Ingresar apellido");
		String apellido = s.nextLine();
		System.out.println("Ingresar email");
		String email = s.nextLine();
		System.out.println("Ingresar sueldo base");
		int sueldoBase = Integer.parseInt(s.nextLine());
		if (inte == 0) {
			System.out.println("Ingresar horas extra");
			int hsExtra = Integer.parseInt(s.nextLine());
			System.out.println("Ingresar horas por mes");
			int hsMes = Integer.parseInt(s.nextLine());
			Administrativo admin = new Administrativo(dni, nombre, apellido, email, sueldoBase, hsExtra, hsMes);
			empleados[lastPosition] = admin;
		}
		else if (inte==1){
			System.out.println("Ingresar porcentaje de comisión");
			int porcenComision = Integer.parseInt(s.nextLine());
			System.out.println("Ingresar total de ventas");
			int totalVentas = Integer.parseInt(s.nextLine());			
			Vendedor ven = new Vendedor(dni, nombre, apellido, email, sueldoBase, porcenComision, totalVentas);
			empleados[lastPosition] = ven;
		}
		lastPosition++;
		System.out.println("Cargar nuevo empleado? 1 para si, 0 para no");
		c = Integer.parseInt(s.nextLine());	
		
		}
		s.close();
		System.out.println("Mostrando todos los empleados cargados");
		for (int i = 0; i < lastPosition; i++) {
			System.out.println(empleados[i].getClass().getSimpleName());
			System.out.println(empleados[i].getDni()+" "+empleados[i].getNombre()+" "+empleados[i].getApellido()+" "+empleados[i].getSueldo());
		}		
	}
}

