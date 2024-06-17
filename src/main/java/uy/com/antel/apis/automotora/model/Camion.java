package uy.com.antel.apis.automotora.model;

public class Camion extends Auto {
	private int cantidadEjes;

	public Camion(Long id, String marca, String modelo, int año, String color, int precio, int cEjes ) {
		super(id, marca, modelo, año, color, precio);
		this.setCantidadEjes(cEjes);
	}

	public int getCantidadEjes() {
		return cantidadEjes;
	}

	public void setCantidadEjes(int cantidadEjes) {
		this.cantidadEjes = cantidadEjes;
	}

}
