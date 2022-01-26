package com.natour.Server.Model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="utente")
public class User implements Serializable {
	
	//Class Primary Key
	@Id
	@Column(name="username")
	private String username;
	
	//Campi Locali
	@Column(name="nome")
	private String nome;
	@Column(name="cognome")
	private String cognome;
	@Column(name="photolnk")
	private String photoLnk;
	@Column(name="email")
	private String email;
	
	//Constructor
	public User(String username, String email, String name, String surname, String photolnk) {
		super();
		this.username = username;
		this.nome = name;
		this.cognome = surname;
		this.photoLnk = photolnk;
		this.email = email;
	}
	
	public User() {}
	
	
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
	public String getName() {
		return nome;
	}
	public void setName(String name) {
		this.nome = name;
	}
	public String getSurname() {
		return cognome;
	}
	public void setSurname(String surname) {
		this.cognome = surname;
	}

}
