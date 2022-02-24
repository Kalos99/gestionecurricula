package it.gestionecurricula.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Esperienza {
	private Long id;
	private String descrizione;
	private Date dataInizio;
	private Date dataFine;
	private String conoscenzeAcquisite;
	private Curriculum curriculumDiAppartenenza;

	public Esperienza() {
	}

	public Esperienza(Long id, String descrizione, Date dataInizio, Date dataFine, String conoscenzeAcquisite,
			Curriculum curriculumDiAppartenenza) {
		this.id = id;
		this.descrizione = descrizione;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
		this.conoscenzeAcquisite = conoscenzeAcquisite;
		this.curriculumDiAppartenenza = curriculumDiAppartenenza;
	}

	public Esperienza(String descrizione, Date dataInizio, Date dataFine, String conoscenzeAcquisite,
			Curriculum curriculumDiAppartenenza) {
		this.descrizione = descrizione;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
		this.conoscenzeAcquisite = conoscenzeAcquisite;
		this.curriculumDiAppartenenza = curriculumDiAppartenenza;
	}

	public Esperienza(Long id, String descrizione, Date dataInizio, Date dataFine, String conoscenzeAcquisite) {
		this.id = id;
		this.descrizione = descrizione;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
		this.conoscenzeAcquisite = conoscenzeAcquisite;
	}

	public Esperienza(String descrizione, Date dataInizio, Date dataFine, String conoscenzeAcquisite) {
		this.descrizione = descrizione;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
		this.conoscenzeAcquisite = conoscenzeAcquisite;
	}

	public Esperienza(String descrizione) {
		this.descrizione = descrizione;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Date getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}

	public Date getDataFine() {
		return dataFine;
	}

	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}

	public String getConoscenzeAcquisite() {
		return conoscenzeAcquisite;
	}

	public void setConoscenzeAcquisite(String conoscenzeAcquisite) {
		this.conoscenzeAcquisite = conoscenzeAcquisite;
	}

	public Curriculum getCurriculumDiAppartenenza() {
		return curriculumDiAppartenenza;
	}

	public void setCurriculumDiAppartenenza(Curriculum curriculumDiAppartenenza) {
		this.curriculumDiAppartenenza = curriculumDiAppartenenza;
	}

	@Override
	public String toString() {
		String dateCreatedString1 = dataInizio != null ? new SimpleDateFormat("dd/MM/yyyy").format(dataInizio)
				: " N.D.";
		String dateCreatedString2 = dataInizio != null ? new SimpleDateFormat("dd/MM/yyyy").format(dataInizio)
				: " N.D.";
		return this.getId() + ") " + this.getDescrizione() + "\nInizio: " + dateCreatedString1 + ", fine: "
				+ dateCreatedString2 + "\nConoscenze acquisite: " + this.getConoscenzeAcquisite();
	}
}