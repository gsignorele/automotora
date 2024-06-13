package uy.com.antel.apis.automotora.model;
/*
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
*/

public class Auto {
   /*
	@NotNull(message = "El id es obligatorio")
	private Long id;

	@NotBlank(message = "La marca es obligatoria")
	private String marca;

	@NotBlank(message = "El modelo es obligatorio")
	private String modelo;

	@NotNull(message = "El año es obligatorio")
	private Integer año;
	private String color; // Campo opcional	
  	private int precio; // Campo opcional
	*/
		
	private Long id;	
	private String marca;	
	private String modelo;	
	private Integer año;	
	private String color; // Campo opcional	
  	private int precio; // Campo opcional
	 
  	 public Auto(Long id, String marca, String modelo, int año, String color, int precio) {
 		this.id = id;
 		this.marca = marca;
 		this.modelo = modelo;
 		this.año = año;
 		this.color = color;
 		this.precio = precio;
 	}
 
  	
    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    public int getPrecio() {
  		return precio;
  	}

  	public void setPrecio(int precio) {
  		this.precio = precio;
  	}
}