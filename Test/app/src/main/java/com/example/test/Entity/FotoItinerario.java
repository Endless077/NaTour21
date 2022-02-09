package com.example.test.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FotoItinerario {

	//Class Primary Key
	@Expose
	@SerializedName("id_photo")
	private Long id_photo;

	//Class Foreign Key
	@Expose
	@SerializedName("id_itinerario")
	private Long id_itinerario;

	//Campi Locali
	@Expose
	@SerializedName("urlfoto")
	private String urlfoto;

	/*********************************************************************************************/
	
	//Constructor
	public FotoItinerario(Long id_photo, Long id_itinerario, String urlfoto) {
		super();
		this.id_photo = id_photo;
		this.id_itinerario = id_itinerario;
		this.urlfoto = urlfoto;
	}


	public FotoItinerario() {}

	/*********************************************************************************************/
	
	//Getter e Setter
	public Long getId_photo() {
		return id_photo;
	}


	public void setId_photo(Long id_photo) {
		this.id_photo = id_photo;
	}


	public Long getId_itinerario() {
		return id_itinerario;
	}


	public void setId_itinerario(Long id_itinerario) {
		this.id_itinerario = id_itinerario;
	}


	public String getUrlfoto() {
		return urlfoto;
	}


	public void setUrlfoto(String urlfoto) {
		this.urlfoto = urlfoto;
	}
	
	/*********************************************************************************************/
	
}
