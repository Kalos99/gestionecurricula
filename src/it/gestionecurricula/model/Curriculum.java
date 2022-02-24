package it.gestionecurricula.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Curriculum {
	private Long id;
	private String nome;
	private String cognome;
	private Date dataDiNascita;
	private String telefono;
	private String email;
	private List<Esperienza> esperienze = new ArrayList<Esperienza>();

	public Curriculum() {
	}

	public Curriculum(Long id, String nome, String cognome, Date dataDiNascita, String telefono, String email,
			List<Esperienza> esperienze) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
		this.telefono = telefono;
		this.email = email;
		this.esperienze = esperienze;
	}

	public Curriculum(Long id, String nome, String cognome, Date dataDiNascita, String telefono, String email) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
		this.telefono = telefono;
		this.email = email;
	}

	public Curriculum(String nome, String cognome, Date dataDiNascita, String telefono, String email,
			List<Esperienza> esperienze) {
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
		this.telefono = telefono;
		this.email = email;
		this.esperienze = esperienze;
	}

	public Curriculum(String nome, String cognome, Date dataDiNascita, String telefono, String email) {
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
		this.telefono = telefono;
		this.email = email;
	}

	public Curriculum(String nome, String cognome) {
		this.nome = nome;
		this.cognome = cognome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Date getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(Date dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Esperienza> getEsperienze() {
		return esperienze;
	}

	public void setEsperienze(List<Esperienza> esperienze) {
		this.esperienze = esperienze;
	}

	@Override
	public String toString() {
		String dateCreatedString = dataDiNascita != null ? new SimpleDateFormat("dd/MM/yyyy").format(dataDiNascita)
				: " N.D.";

		return "ID Curriculum: " + this.getId() + "\n" + this.getNome() + " " + this.getCognome() + ", "
				+ dateCreatedString + "\nTelefono: " + this.getTelefono() + "\nEmail:" + this.getEmail()
				+ "\n\nEsperienze aquisite\n\n" + this.getEsperienze().toString();
	}

}
