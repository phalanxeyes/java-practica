package Ej5b;

public class Vendedor extends Empleado {

	private int porcenComision;
	private int totalVentas;
	
	public Vendedor(int dni, String nombre, String apellido, String email, int sueldoBase, int porcenComision, int totalVentas) {
		super(dni, nombre, apellido, email, sueldoBase);
		this.porcenComision = porcenComision;
		this.totalVentas = totalVentas;
	}
	
	public int getPorcenComision() {
		return porcenComision;
	}
	public void setPorcenComision(int porcenComision) {
		this.porcenComision = porcenComision;
	}
	public int getTotalVentas() {
		return totalVentas;
	}
	public void setTotalVentas(int totalVentas) {
		this.totalVentas = totalVentas;
	}
	
	public double getSueldo() {
		return super.getSueldoBase() + (this.porcenComision * this.totalVentas/100);
	}
}
