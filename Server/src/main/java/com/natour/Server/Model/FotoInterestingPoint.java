package com.natour.Server.Model;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="fotointerestingpoint")
public class FotoInterestingPoint implements Serializable {

	//Class Primary Key
	@Id
	@Column(name="id_photo")
	private Long id_photo;

	//Class Foreign Key
	@JsonManagedReference
	@OneToOne(fetch = FetchType.LAZY)
	@OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_interestingpoint",
    			nullable = false,
    			referencedColumnName = "id_interestingpoint")
	private InterestingPoint interestingPoint;

	//Campi Locali
	@Column(name = "foto", nullable = false)
	private String foto;

	/*********************************************************************************************/

	//Constructor
	public FotoInterestingPoint(Long id_photo, InterestingPoint interestingPoint, String foto) {
		super();
		this.id_photo = id_photo;
		this.interestingPoint = interestingPoint;
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

	public InterestingPoint getInterestingPoint() {
		return interestingPoint;
	}

	public void setInterestingPoint(InterestingPoint interestingPoint) {
		this.interestingPoint = interestingPoint;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	/*********************************************************************************************/

}
