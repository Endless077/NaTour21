package com.natour.Server.Model;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="compilation")
public class Compilation implements Serializable {

	//Class Primary Key
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_compilation")
	private Long id_compilation;

	//Class Foreign Key
	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_utente",
    			nullable = false,
    			referencedColumnName = "username")
	private User utente;
	
	//Campi Locali
	@Column(name="titolo")
	private String titolo;
	@Column(name="descrizione")
	private String descrizione;

	/*********************************************************************************************/

	//Constructor
	public Compilation(Long id_compilation, User utente, String titolo, String descrizione) {
		super();
		this.id_compilation = id_compilation;
		this.utente = utente;
		this.titolo = titolo;
		this.descrizione = descrizione;
	}

	public Compilation() {}

	/*********************************************************************************************/

	//Getter e Setter
	public Long getId_compilation() {
		return id_compilation;
	}
	public void setId_compilation(Long id_compilation) {
		this.id_compilation = id_compilation;
	}
	public User getId_utente() {
		return utente;
	}
	public void setId_utente(User utente) {
		this.utente = utente;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	/*********************************************************************************************/

}
