package com.natour.Server.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="utente")
public class User implements Serializable {
	
	@Id
	@Column(name="username")
	String username;
	
	@Column(name="email")
	String email;
	@Column(name="nome")
	String nome;
	@Column(name="cognome")
	String cognome;
	
	//@Cloumn(name="photoLnk)
	//String photoLnk;
	
	//Constructor
	public User(String username, String email, String name, String surname) {
		super();
		this.username = username;
		this.email = email;
		this.nome = name;
		this.cognome = surname;
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
