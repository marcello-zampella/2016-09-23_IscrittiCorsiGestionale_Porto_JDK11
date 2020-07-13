package it.polito.tdp.gestionale.model;

public class Studente extends Nodo {

	private int matricola;
	private String cognome;
	private String nome;
	private String cds;
	private int numeroCorsi;
	
	
	
	

	public int getNumeroCorsi() {
		return numeroCorsi;
	}

	public void setNumeroCorsi(int numeroCorsi) {
		this.numeroCorsi = numeroCorsi;
	}

	public Studente(int matricola, String cognome, String nome, String cds, int numeroCorsi) {
		super();
		this.matricola = matricola;
		this.cognome = cognome;
		this.nome = nome;
		this.cds = cds;
		this.numeroCorsi = numeroCorsi;
	}

	public Studente(int matricola) {
		super();
		this.matricola = matricola;
	}

	public Studente(int matricola, String cognome, String nome, String cds) {
		this.matricola = matricola;
		this.cognome = cognome;
		this.nome = nome;
		this.cds = cds;
	}

	/*
	 * Getters and Setters
	 */

	public int getMatricola() {
		return matricola;
	}

	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}

	public String getCognome() {
		if (cognome == null)
			return "";
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		if (nome == null)
			return "";
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCds() {
		if (cds == null)
			return "";
		return cds;
	}

	public void setCds(String cds) {
		this.cds = cds;
	}
	
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + matricola;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Studente other = (Studente) obj;
		if (matricola != other.matricola)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Studente [matricola=" + matricola + ", cognome=" + cognome + ", nome=" + nome + ", cds=" + cds + "]";
	}

}
