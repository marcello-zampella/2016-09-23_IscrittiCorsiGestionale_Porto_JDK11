package it.polito.tdp.gestionale.model;

public class Collegamento {
	
	Studente s;
	Corso c;
	public Collegamento(Studente s, Corso c) {
		super();
		this.s = s;
		this.c = c;
	}
	public Studente getS() {
		return s;
	}
	public void setS(Studente s) {
		this.s = s;
	}
	public Corso getC() {
		return c;
	}
	public void setC(Corso c) {
		this.c = c;
	}
	@Override
	public String toString() {
		return "Collegamento [s=" + s + ", c=" + c + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((c == null) ? 0 : c.hashCode());
		result = prime * result + ((s == null) ? 0 : s.hashCode());
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
		Collegamento other = (Collegamento) obj;
		if (c == null) {
			if (other.c != null)
				return false;
		} else if (!c.equals(other.c))
			return false;
		if (s == null) {
			if (other.s != null)
				return false;
		} else if (!s.equals(other.s))
			return false;
		return true;
	}
	
	

}
