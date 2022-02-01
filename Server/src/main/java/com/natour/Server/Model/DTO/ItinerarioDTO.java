package com.natour.Server.Model.DTO;


public class ItinerarioDTO {

	//Class Primary Key
	private Long id_itinerario = -1L;

	//Class Foreign Key
	private String id_utente;

	//Campi Locali
	private String titolo;
	private String descrizione;
	private String puntoinizio;
	private String puntofine;
	private Boolean accessibilitadisabili;
	private String difficoltà;
	private String durata;
	private Double lunghezza;
	private String mezzoditrasporto;
	private String areageografica;

	/*********************************************************************************************/

	//Constructor
	public ItinerarioDTO(Long id_itinerario, String id_utente, String titolo, String descrizione, String puntoinizio,
			String puntofine, Boolean accessibilitadisabili, String difficoltà, String durata, Double lunghezza,
			String mezzoditrasporto, String areageografica) {
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
		this.mezzoditrasporto = mezzoditrasporto;
		this.areageografica = areageografica;
	}	

	public ItinerarioDTO() {}

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

	public Boolean getAccessibilitadisabili() {
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

	public String getMezzoditrasporto() {
		return mezzoditrasporto;
	}

	public void setMezzoditrasporto(String mezzoditrasporto) {
		this.mezzoditrasporto = mezzoditrasporto;
	}

	public String getAreageografica() {
		return areageografica;
	}

	public void setAreageografica(String areageografica) {
		this.areageografica = areageografica;
	}


	/*********************************************************************************************/

}
