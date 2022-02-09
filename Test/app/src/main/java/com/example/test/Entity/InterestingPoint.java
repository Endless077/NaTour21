package com.example.test.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InterestingPoint {

	//Class Primary Key
	@Expose
	@SerializedName("id_interestingpoint")
	private Long id_interestingpoint;

	//Class Foreign Key
	@Expose
	@SerializedName("id_itinerario")
	private Long id_itinerario;

	//Campi Locali
	@Expose
	@SerializedName("latitudine")
	private Double latitudine;
	@Expose
	@SerializedName("longitudine")
	private Double longitudine;
	@Expose
	@SerializedName("titolo")
	private String titolo;
	@Expose
	@SerializedName("descrizione")
	private String descrizione;
	@Expose
	@SerializedName("urlfoto")
	private String urlfoto;

	/*********************************************************************************************/

	//Constructor
	public InterestingPoint(Long id_interestingpoint, Long id_itinerario, Double latitudine, Double longitudine,
							String titolo, String descrizione, String urlfoto) {
		super();
		this.id_interestingpoint = id_interestingpoint;
		this.id_itinerario = id_itinerario;
		this.latitudine = latitudine;
		this.longitudine = longitudine;
		this.descrizione = descrizione;
		this.titolo = titolo;
		this.urlfoto = urlfoto;
	}


	public InterestingPoint() {}


	/*********************************************************************************************/

	//Getter e Setter
	public Long getId_interestingpoint() {
		return id_interestingpoint;
	}


	public void setId_interestingpoint(Long id_interestingpoint) {
		this.id_interestingpoint = id_interestingpoint;
	}


	public Long getId_itinerario() {
		return id_itinerario;
	}


	public void setId_itinerario(Long id_itinerario) {
		this.id_itinerario = id_itinerario;
	}


	public Double getLatitudine() {
		return latitudine;
	}


	public void setLatitudine(Double latitudine) {
		this.latitudine = latitudine;
	}


	public Double getLongitudine() {
		return longitudine;
	}


	public void setLongitudine(Double longitudine) {
		this.longitudine = longitudine;
	}


	public String getTitolo() {
		return titolo;
	}


	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	
	
	public String getDescrizione() {
		return descrizione;
	}


	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}


	public String getUrlfoto() {
		return urlfoto;
	}


	public void setUrlfoto(String urlfoto) {
		this.urlfoto = urlfoto;
	}
	
	/*********************************************************************************************/

}
