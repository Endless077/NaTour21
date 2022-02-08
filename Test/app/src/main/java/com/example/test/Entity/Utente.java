package com.example.test.Entity;

public class Utente {

	//Class Primary Key
	private String username;
	
	//Campi Locali
	private String email;
	private String nome;
	private String cognome;
	private String photolnk;
	
	/*********************************************************************************************/
	
	//Constructor
	public Utente(String username, String email, String nome, String cognome, String photolnk) {
		super();
		this.username = username;
		this.email = email;
		this.nome = nome;
		this.cognome = cognome;
		this.photolnk = photolnk;
	}
	
	public Utente() {}

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

	@Override
	public String toString() {
		return "User{" +
				"username='" + username + '\'' +
				", email='" + email + '\'' +
				", nome='" + nome + '\'' +
				", cognome='" + cognome + '\'' +
				", photolnk='" + photolnk + '\'' +
				'}';
	}

/*********************************************************************************************/
	
}
