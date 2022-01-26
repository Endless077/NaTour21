package com.natour.Server.Model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="tappa")
public class Tappa implements Serializable {

	//Class Primary Key
	@Id
	@Column(name="id_tappa")
	private Long id_tappa;

	//Class Foreign Key
	@JoinColumn(name="id_itinerario")
	private Long id_itinerario;

	//Campi Locali
	@Column(name="nometappa")
	private String nometappa;
	@Column(name="latitudine")
	private Double latitudine;
	@Column(name="longitudine")
	private Double longitudine;
	@Column(name="tipotappa")
	private String tipotappa;
	@Column(name="sequenza")
	private Integer sequenza;

	/*********************************************************************************************/

	//Constructor
	public Tappa(Long id_tappa, Long id_itinerario, String nometappa, Double latitudine, Double longitudine,
			String tipotappa, Integer sequenza) {
		super();
		this.id_tappa = id_tappa;
		this.id_itinerario = id_itinerario;
		this.nometappa = nometappa;
		this.latitudine = latitudine;
		this.longitudine = longitudine;
		this.tipotappa = tipotappa;
		this.sequenza = sequenza;
	}

	public Tappa() {}

	/*********************************************************************************************/

	//Getter e Setter
	public Long getId_tappa() {
		return id_tappa;
	}

	public void setId_tappa(Long id_tappa) {
		this.id_tappa = id_tappa;
	}

	public Long getId_itinerario() {
		return id_itinerario;
	}

	public void setId_itinerario(Long id_itinerario) {
		this.id_itinerario = id_itinerario;
	}

	public String getNometappa() {
		return nometappa;
	}

	public void setNometappa(String nometappa) {
		this.nometappa = nometappa;
	}

	public double getLatitudine() {
		return latitudine;
	}

	public void setLatitudine(Double latitudine) {
		this.latitudine = latitudine;
	}

	public double getLongitudine() {
		return longitudine;
	}

	public void setLongitudine(Double longitudine) {
		this.longitudine = longitudine;
	}

	public String getTipotappa() {
		return tipotappa;
	}

	public void setTipotappa(String tipotappa) {
		this.tipotappa = tipotappa;
	}

	public Integer getSequenza() {
		return sequenza;
	}

	public void setSequenza(Integer sequenza) {
		this.sequenza = sequenza;
	}

	/*********************************************************************************************/
}
