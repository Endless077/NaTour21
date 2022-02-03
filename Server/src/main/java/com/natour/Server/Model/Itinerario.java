package com.natour.Server.Model;

import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="itinerario")
public class Itinerario implements Serializable {

	//Class Primary Key
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_itinerario")
	private Long id_itinerario;

	//Class Foreign Key
	@JsonManagedReference
	@ManyToOne(fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "id_utente",
				nullable = false,
				referencedColumnName = "username")
	private User utente;

	//Relationship
	@JsonBackReference
	@OneToMany(mappedBy = "itinerario",
				cascade = CascadeType.ALL,
				fetch = FetchType.LAZY)
	private List<InterestingPoint> interestingPoint = new ArrayList<InterestingPoint>();

	@JsonBackReference
	@OneToMany(mappedBy = "itinerario",
				cascade = CascadeType.ALL,
				fetch = FetchType.LAZY)
	private List<Tappa> tappe = new ArrayList<Tappa>();;
	
	@JsonBackReference
	@OneToMany(mappedBy = "itinerario",
				cascade = CascadeType.ALL,
				fetch = FetchType.LAZY)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<FotoItinerario> fotoItinerario = new ArrayList<FotoItinerario>();
	
	@JsonBackReference
	@ManyToMany(mappedBy = "itinerari",
				cascade = CascadeType.ALL,
				fetch = FetchType.LAZY)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Compilation> compilation = new ArrayList<Compilation>();
	
	//Campi Locali
	@Column(name="titolo", nullable = false)
	private String titolo;
	@Column(name="descrizione")
	private String descrizione;
	@Column(name="puntoinizio", nullable = false)
	private String puntoinizio;
	@Column(name="puntofine", nullable = false)
	private String puntofine;
	@Column(name="accessodisabili")
	private Boolean accessodisabili;
	@Column(name="difficulty")
	private String difficulty;
	@Column(name="durata")
	private Time durata;
	@Column(name="lunghezza")
	private Double lunghezza;
	@Column(name="mezzoditrasporto")
	private String mezzoditrasporto;
	@Column(name="areageografica")
	private String areageografica;

	/*********************************************************************************************/

	//Constructor
	public Itinerario(Long id_itinerario, User utente, String titolo, String descrizione, String puntoinizio,
			String puntofine, Boolean accessodisabili, String difficulty, Time durata, Double lunghezza, String mezzoditrasporto, String areageografica) {
		super();
		this.id_itinerario = id_itinerario;
		this.utente = utente;
		this.titolo = titolo;
		this.descrizione = descrizione;
		this.puntoinizio = puntoinizio;
		this.puntofine = puntofine;
		this.accessodisabili = accessodisabili;
		this.difficulty = difficulty;
		this.durata = durata;
		this.lunghezza = lunghezza;
		this.mezzoditrasporto = mezzoditrasporto;
		this.areageografica = areageografica;
	}

	public Itinerario() {}
	
	/*********************************************************************************************/
	
	//Getter e Setter
	public Long getId_itinerario() {
		return id_itinerario;
	}

	public void setId_itinerario(Long id_itinerario) {
		this.id_itinerario = id_itinerario;
	}

	public User getUtente() {
		return utente;
	}

	public void setUtente(User utente) {
		this.utente = utente;
	}

	public List<Tappa> getTappe() {
		return tappe;
	}

	public void setTappe(List<Tappa> tappe) {
		this.tappe = tappe;
	}

	public List<InterestingPoint> getInterestingPoint() {
		return interestingPoint;
	}

	public void setInterestingPoint(List<InterestingPoint> interestingPoint) {
		this.interestingPoint = interestingPoint;
	}

	public List<Compilation> getCompilation() {
		return compilation;
	}

	public void setCompilation(List<Compilation> compilation) {
		this.compilation = compilation;
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

	public String getPuntoinizio() {
		return puntoinizio;
	}

	public void setPuntoinizio(String puntoinizio) {
		this.puntoinizio = puntoinizio;
	}

	public String getPuntofine() {
		return puntofine;
	}

	public void setPuntofine(String puntofine) {
		this.puntofine = puntofine;
	}

	public Boolean getAccessodisabili() {
		return accessodisabili;
	}

	public void setAccessodisabili(Boolean accessodisabili) {
		this.accessodisabili = accessodisabili;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	public Time getDurata() {
		return durata;
	}

	public void setDurata(Time durata) {
		this.durata = durata;
	}

	public Double getLunghezza() {
		return lunghezza;
	}

	public void setLunghezza(Double lunghezza) {
		this.lunghezza = lunghezza;
	}

	public String getMezzoditrasporto() {
		return mezzoditrasporto;
	}

	public void setMezzoditrasporto(String mezzoditrasporto) {
		this.mezzoditrasporto = mezzoditrasporto;
	}

	public String getAreageografica() {
		return areageografica;
	}

	public void setAreageografica(String areageografica) {
		this.areageografica = areageografica;
	}
	
	/*********************************************************************************************/

}
