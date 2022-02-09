package com.example.test.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SearchFilter {

	//Filtri
	@Expose
	@SerializedName("id_tappa")
	private String titolo;
	@Expose
	@SerializedName("puntoinizio")
	private String puntoinizio;
	@Expose
	@SerializedName("puntofine")
	private String puntofine;
	@Expose
	@SerializedName("accessodisabili")
	private Boolean accessodisabili;
	@Expose
	@SerializedName("difficulty")
	private String difficulty;
	@Expose
	@SerializedName("durata")
	private String durata;
	@Expose
	@SerializedName("lunghezza")
	private Double lunghezza;
	@Expose
	@SerializedName("areageografica")
	private String areageografica;
	
	/*********************************************************************************************/
	
	//Constructor
	public SearchFilter(String titolo, String puntoinizio, String puntofine,
						Boolean accessodisabili, String difficulty, String durata, Double lunghezza, String areageografica) {
		super();
		this.titolo = titolo;
		this.puntoinizio = puntoinizio;
		this.puntofine = puntofine;
		this.accessodisabili = accessodisabili;
		this.difficulty = difficulty;
		this.durata = durata;
		this.lunghezza = lunghezza;
		this.areageografica = areageografica;
	}
	
	public SearchFilter() {}

	/*********************************************************************************************/
	
	//Getter e Setter
	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getPuntoinizio() {
		return puntoinizio;
	}

	public void setPuntoinizio(String puntoinizio) {
		this.puntoinizio = puntoinizio;
	}

	public String getPuntofine() {
		return puntofine;
	}

	public void setPuntofine(String puntofine) {
		this.puntofine = puntofine;
	}

	public Boolean getAccessodisabili() {
		return accessodisabili;
	}

	public void setAccessodisabili(Boolean accessodisabili) {
		this.accessodisabili = accessodisabili;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	public String getDurata() {
		return durata;
	}

	public void setDurata(String durata) {
		this.durata = durata;
	}

	public Double getLunghezza() {
		return lunghezza;
	}

	public void setLunghezza(Double lunghezza) {
		this.lunghezza = lunghezza;
	}

	public String getAreageografica() {
		return areageografica;
	}

	public void setAreageografica(String areageografica) {
		this.areageografica = areageografica;
	}

	/*********************************************************************************************/
	
}
