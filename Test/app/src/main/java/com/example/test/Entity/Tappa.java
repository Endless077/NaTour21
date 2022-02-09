package com.example.test.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tappa {

	//Class Primary Key
	@Expose
	@SerializedName("id_tappa")
	private Long id_tappa;

	//Class Foreign Key
	@Expose
	@SerializedName("id_itinerario")
	private Long id_itinerario;

	//Campi Locali
	@Expose
	@SerializedName("nometappa")
	private String nometappa;
	@Expose
	@SerializedName("latitudine")
	private Double latitudine;
	@Expose
	@SerializedName("longitudine")
	private Double longitudine;
	@Expose
	@SerializedName("tipotappa")
	private String tipotappa;
	@Expose
	@SerializedName("sequenza")
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
