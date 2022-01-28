package com.natour.Server.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="utente")
public class User implements Serializable {

	//Class Primary Key
	@Id
	@Column(name="username")
	private String username;

	//Relationship
	//@JsonIgnore
	@JsonManagedReference 
	@OneToMany(mappedBy = "utente",
				cascade = CascadeType.ALL,
			 	fetch = FetchType.LAZY)
	List<Compilation> compilation;
	
	//Campi Locali
	@Column(name="email")
	private String email;
	@Column(name="nome")
	private String nome;
	@Column(name="cognome")
	private String cognome;
	@Column(name="photolnk")
	private String photolnk;

	/*********************************************************************************************/

	//Constructor
	public User(String username, String email, String nome, String cognome, String photolnk) {
		super();
		this.username = username;
		this.email = email;
		this.nome = nome;
		this.cognome = cognome;
		this.photolnk = photolnk;
		
		this.compilation = new ArrayList<Compilation>();
	}

	public User() {}

	/*********************************************************************************************/

	//Getter e Setter
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getPhotolnk() {
		return photolnk;
	}

	public void setPhotolnk(String photolnk) {
		this.photolnk = photolnk;
	}

	public List<Compilation> getCompilation() {
		return compilation;
	}

	public void setCompilation(List<Compilation> compilation) {
		this.compilation = compilation;
	}

	/*********************************************************************************************/

}
