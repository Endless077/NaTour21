package com.natour.Server.Model;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="fotoitinerario")
public class FotoItinerario implements Serializable {

	//Class Primary Key
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_photo")
	private Long id_photo;

	//Class Foreign Key
	@JsonManagedReference
	@ManyToOne(fetch = FetchType.LAZY)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "id_itinerario",
				nullable = false,
				referencedColumnName = "id_itinerario")
	private Itinerario itinerario;

	//Campi Locali
	@Column(name = "urlfoto", nullable = false)
	private String urlfoto;

	//altri attributi di foto (i.e Metadati)

	/*********************************************************************************************/

	//Constructor
	public FotoItinerario(Long id_photo, Itinerario itinerario, String urlfoto) {
		super();
		this.id_photo = id_photo;
		this.itinerario = itinerario;
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

	public Itinerario getItinerario() {
		return itinerario;
	}

	public void setItinerario(Itinerario itinerario) {
		this.itinerario = itinerario;
	}

	public String getUrlfoto() {
		return urlfoto;
	}

	public void setUrlfoto(String urlfoto) {
		this.urlfoto = urlfoto;
	}

	/*********************************************************************************************/

}
