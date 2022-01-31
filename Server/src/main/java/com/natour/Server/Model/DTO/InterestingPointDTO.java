package com.natour.Server.Model.DTO;

public class InterestingPointDTO {

	//Class Primary Key
	private Long id_interestingpoint;

	//Class Foreign Key
	private Long id_itinerario;

	//Campi Locali
	private Double latitudine;
	private Double longitudine;
	private String descrizione;
	private String titolo;
	
	/*********************************************************************************************/
	
	//Constructor
	public InterestingPointDTO(Long id_interestingpoint, Long id_itinerario, Double latitudine, Double longitudine,
			String descrizione, String titolo) {
		super();
		this.id_interestingpoint = id_interestingpoint;
		this.id_itinerario = id_itinerario;
		this.latitudine = latitudine;
		this.longitudine = longitudine;
		this.descrizione = descrizione;
		this.titolo = titolo;
	}
	
	public InterestingPointDTO() {}

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

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	
	
	/*********************************************************************************************/

}
