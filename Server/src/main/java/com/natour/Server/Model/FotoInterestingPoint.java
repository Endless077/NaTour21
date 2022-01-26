package com.natour.Server.Model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="fotointerestingpoint")
public class FotoInterestingPoint implements Serializable {

	//Class Primary Key
	@Id
	@Column(name="id_photo")
	private Long id_photo;

	//Class Foreign Key
	@JoinColumn(name = "id_interestingpoint")
	private Long id_itinerario;

	//Campi Locali
	@Column(name = "foto")
	private String foto;

	/*********************************************************************************************/

	//Constructor
	public FotoInterestingPoint(Long id_photo, Long id_itinerario, String foto) {
		super();
		this.id_photo = id_photo;
		this.id_itinerario = id_itinerario;
		this.foto = foto;
	}

	public FotoInterestingPoint() {}

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

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	/*********************************************************************************************/

}
