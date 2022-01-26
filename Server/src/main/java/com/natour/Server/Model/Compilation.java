package com.natour.Server.Model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="compilation")
public class Compilation {

		//Class Primary Key
		@Id
		@Column(name="id_compilation")
		private Long id_compilation;
		
		//Class Foreign Key
		@JoinColumn(name = "id_utente")
		private String id_utente;
		
		//Campi Locali
		@Column(name="titolo")
		private String titolo;
		@Column(name="descrizione")
		private String descrizione;
		
		
		public Compilation() {
			
		}

		public Compilation(Long id_compilation, String id_utente, String titolo, String descrizione) {
			super();
			this.id_compilation = id_compilation;
			this.id_utente = id_utente;
			this.titolo = titolo;
			this.descrizione = descrizione;
		}
		
		
		
		public Long getId_compilation() {
		return id_compilation;
		}
		public void setId_compilation(Long id_compilation) {
			this.id_compilation = id_compilation;
		}
		public String getId_utente() {
			return id_utente;
		}
		public void setId_utente(String id_utente) {
			this.id_utente = id_utente;
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
		
}
