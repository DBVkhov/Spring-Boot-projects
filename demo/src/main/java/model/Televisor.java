package model;

public class Televisor {
	private String modelo;
	private double precio;
	private double pulgadas;
	public Televisor(String modelo, double precio, double pulgadas) {
		super();
		this.modelo = modelo;
		this.precio = precio;
		this.pulgadas = pulgadas;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public double getPulgadas() {
		return pulgadas;
	}
	public void setPulgadas(double pulgadas) {
		this.pulgadas = pulgadas;
	}
	
	
	
}
