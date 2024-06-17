package uy.com.antel.apis.automotora.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Auto {
	
	private Long id;

	@NotBlank(message = "La marca es obligatoria")
	private String marca;

	@NotBlank(message = "El modelo es obligatorio")
	private String modelo;

	@NotNull(message = "El año es obligatorio")
	private Integer año;
	
	private String color; // Campo opcional	
  	private Integer precio; // Campo opcional

  	
  	
  	 public Auto(Long id, String marca, String modelo, int año, String color, Integer precio) {
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
    
    public Integer getPrecio() {
  		return precio;
  	}

  	public void setPrecio(Integer precio) {
  		this.precio = precio;
  	}
}