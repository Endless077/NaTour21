package com.natour.Server.Model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="itinerario")
public class Itinerario implements Serializable {

	//Class Primary Key
	@Id
	@Column(name="id_itinerario")
	private Long id_itinerario;

	//Class Foreign Key
	@Column(name = "id_utente")
	private String id_utente;

	//Campi Locali
	@Column(name="titolo")
	private String titolo;
	@Column(name="descrizione")
	private String descrizione;
	@Column(name="puntoinizio")
	private String puntoinizio;
	@Column(name="puntofine")
	private String puntofine;
	@Column(name="accessibilitadisabili")
	private Boolean accessibilitadisabili;
	@Column(name="difficolta")
	private String difficoltà;
	@Column(name="durata")
	private String durata;
	@Column(name="lunghezza")
	private Double lunghezza;
	@Column(name="areageografica")
	private String areageografica;

	/*********************************************************************************************/

	//Constructor
	public Itinerario(Long id_itinerario, String id_utente, String titolo, String descrizione, String puntoinizio,
			String puntofine, Boolean accessibilitadisabili, String difficoltà, String durata, Double lunghezza, String areageografica) {
		super();
		this.id_itinerario = id_itinerario;
		this.id_utente = id_utente;
		this.titolo = titolo;
		this.descrizione = descrizione;
		this.puntoinizio = puntoinizio;
		this.puntofine = puntofine;
		this.accessibilitadisabili = accessibilitadisabili;
		this.difficoltà = difficoltà;
		this.durata = durata;
		this.lunghezza = lunghezza;
		this.areageografica = areageografica;
	}

	public Itinerario() {}

	/*********************************************************************************************/

	//Getter e Setter
	public Long getId_itinerario() {
		return id_itinerario;
	}

	public void setId_itinerario(Long id_itinerario) {
		this.id_itinerario = id_itinerario;
	}

	public String getId_utente() {
		return id_utente;
	}
	public void setId_utente(String id_utente) {
		this.id_utente = id_utente;
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
	public Boolean isAccessibilitadisabili() {
		return accessibilitadisabili;
	}
	public void setAccessibilitadisabili(Boolean accessibilitadisabili) {
		this.accessibilitadisabili = accessibilitadisabili;
	}
	public String getDifficoltà() {
		return difficoltà;
	}
	public void setDifficoltà(String difficoltà) {
		this.difficoltà = difficoltà;
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
