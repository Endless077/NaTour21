package com.natour.Server.Model;

import java.io.Serializable;

import javax.persistence.*;

//import java.util.ArrayList;
//import java.util.List;
//import com.natour.Server.Model.Compilation;

@Entity
@Table(name="utente")
public class User implements Serializable {

	//Class Primary Key
	@Id
	@Column(name="username")
	private String username;

	//Relations
	//@OneToMany(mappedBy="utente",targetEntity=Compilation.class)
	//private List<Compilation> compilation;

	//Campi Locali
	@Column(name="email")
	private String email;
	@Column(name="nome")
	private String nome;
	@Column(name="cognome")
	private String cognome;
	@Column(name="photolnk")
	private String photoLnk;

	/*********************************************************************************************/

	//Constructor
	public User(String username, String email, String name, String surname, String photolnk) {
		super();
		this.username = username;
		this.email = email;
		this.nome = name;
		this.cognome = surname;
		this.photoLnk = photolnk;
		
		//this.compilation = new ArrayList<Compilation>();
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

	public String getPhotoLnk() {
		return photoLnk;
	}

	public void setPhotoLnk(String photoLnk) {
		this.photoLnk = photoLnk;
	}

	//Relations
//	public List<Compilation> getCompilation() {
//		return compilation;
//	}
//
//	public void setCompilation(List<Compilation> compilation) {
//		this.compilation = compilation;
//	}
	
	/*********************************************************************************************/

}
