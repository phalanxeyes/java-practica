package Ej5a;

public class Administrativo extends Empleado {

	private int hsExtra;
	private int hsMes;
	
	public Administrativo(int dni, String nombre, String apellido, String email, int sueldoBase, int hsExtra, int hsMes) {
		super(dni, nombre, apellido, email, sueldoBase);
		this.hsExtra = hsExtra;
		this.hsMes = hsMes;
	}
	
	public int getHsExtra() {
		return hsExtra;
	}
	public void setHsExtra(int hsExtra) {
		this.hsExtra = hsExtra;
	}
	public int getHsMes() {
		return hsMes;
	}
	public void setHsMes(int hsMes) {
		this.hsMes = hsMes;
	}
	
	public double getSueldo() {
		return super.getSueldoBase() * ((this.hsExtra * 1.5) + this.hsMes)/this.hsMes;
	}
}
