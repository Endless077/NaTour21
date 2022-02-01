package com.natour.Server.Model;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="interestingpoint")
public class InterestingPoint implements Serializable {

	//Class Primary Key
	@Id
	@Column(name="id_interestingpoint")
	private Long id_interestingpoint;

	//Class Foreign Key
	@JsonManagedReference
	@ManyToOne(fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "id_itineraio",
				nullable = false,
				referencedColumnName = "id_itinerario")
	private Itinerario itinerario;

	//Relationship
	@JsonBackReference
	@OneToOne(mappedBy = "interestingPoint",
				cascade = CascadeType.ALL,
				fetch = FetchType.LAZY)
	private FotoInterestingPoint fotoInterestingPoint;

	//Campi Locali
	@Column(name="latitudine", nullable = false)
	private Double latitudine;
	@Column(name="longitudine", nullable = false)
	private Double longitudine;
	@Column(name="titolo")
	private String titolo;
	@Column(name="descrizione")
	private String descrizione;

	/*********************************************************************************************/

	//Constructor
	public InterestingPoint(Long id_interestingpoint, Itinerario itinerario, Double latitudine, Double longitudine,
			String descrizione, String titolo) {
		super();
		this.id_interestingpoint = id_interestingpoint;
		this.itinerario = itinerario;
		this.latitudine = latitudine;
		this.longitudine = longitudine;
		this.descrizione = descrizione;
		this.titolo = titolo;

		this.fotoInterestingPoint = new FotoInterestingPoint();
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

	public Itinerario getItinerario() {
		return itinerario;
	}

	public void setItinerario(Itinerario itinerario) {
		this.itinerario = itinerario;
	}

	public FotoInterestingPoint getFotoInterestingPoint() {
		return fotoInterestingPoint;
	}

	public void setFotoInterestingPoint(FotoInterestingPoint fotoInterestingPoint) {
		this.fotoInterestingPoint = fotoInterestingPoint;
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

	/*********************************************************************************************/

}
