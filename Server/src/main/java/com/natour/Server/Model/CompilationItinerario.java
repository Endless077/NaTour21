package com.natour.Server.Model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="compilationitinerario")
public class CompilationItinerario implements Serializable {

	//Class Primary Key
	@Id
	@Column(name="id_compilation_itinerario")
	private Long username;

	//Class Foreign Key
	@Column(name = "id_compilation")
	private Long id_compilation;
	@Column(name = "id_itinerario")
	private Long id_itinerario;

	/*********************************************************************************************/

	//Constructor
	public CompilationItinerario(Long username, Long id_compilation, Long id_itinerario) {
		super();
		this.username = username;
		this.id_compilation = id_compilation;
		this.id_itinerario = id_itinerario;
	}

	public CompilationItinerario() {}

	/*********************************************************************************************/

	//Getter e Setter
	public Long getUsername() {
		return username;
	}

	public void setUsername(Long username) {
		this.username = username;
	}

	public Long getId_compilation() {
		return id_compilation;
	}

	public void setId_compilation(Long id_compilation) {
		this.id_compilation = id_compilation;
	}

	public Long getId_itinerario() {
		return id_itinerario;
	}

	public void setId_itinerario(Long id_itinerario) {
		this.id_itinerario = id_itinerario;
	}

	/*********************************************************************************************/
}
