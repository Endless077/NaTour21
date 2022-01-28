package com.natour.Server.Model.DTO;

public class UserDTO {

	//Class Primary Key
	private String username;

	//Campi Locali
	private String email;
	private String nome;
	private String cognome;
	private String photoLnk;
	
	/*********************************************************************************************/
	
	//Constructor
	public UserDTO(String username, String email, String nome, String cognome, String photoLnk) {
		super();
		this.username = username;
		this.email = email;
		this.nome = nome;
		this.cognome = cognome;
		this.photoLnk = photoLnk;
	}
	
	public UserDTO() {}

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

	/*********************************************************************************************/
	
}
