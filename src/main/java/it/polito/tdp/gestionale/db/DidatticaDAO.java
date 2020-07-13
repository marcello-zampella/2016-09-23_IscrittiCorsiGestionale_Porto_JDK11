package it.polito.tdp.gestionale.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

import it.polito.tdp.gestionale.model.Collegamento;
import it.polito.tdp.gestionale.model.Corso;
import it.polito.tdp.gestionale.model.Studente;

public class DidatticaDAO {

	/*
	 * Dato un codice insegnamento, ottengo il corso
	 */
	public Corso getCorso(String codins) {

		final String sql = "SELECT * FROM corso where codins=?";

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, codins);

			ResultSet rs = st.executeQuery();

			if (rs.next()) {

				Corso corso = new Corso(rs.getString("codins"), rs.getInt("crediti"), rs.getString("nome"),
						rs.getInt("pd"));
				return corso;
			}

			return null;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}

	/*
	 * Data una matricola ottengo lo studente.
	 */
	public Studente getStudente(int matricola) {

		final String sql = "SELECT * FROM studente where matricola=?";

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, matricola);

			ResultSet rs = st.executeQuery();

			if (rs.next()) {

				Studente studente = new Studente(rs.getInt("matricola"), rs.getString("cognome"), rs.getString("nome"),
						rs.getString("cds"));
				return studente;
			}

			return null;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}

	public ArrayList<Studente> getAllStudenti() {

		final String sql = "SELECT * FROM studente";

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();
			ArrayList<Studente> studenti=new ArrayList<Studente>();

			while(rs.next()) {

				Studente studente = new Studente(rs.getInt("matricola"), rs.getString("cognome"), rs.getString("nome"),
						rs.getString("cds"));
				studenti.add(studente);
			}
			
			return studenti;			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}

	public ArrayList<Corso> getAllCorsi() {

		final String sql = "SELECT * FROM corso ";

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();
			ArrayList<Corso> corsi=new ArrayList<Corso>();

			while(rs.next()) {

				Corso corso = new Corso(rs.getString("codins"), rs.getInt("crediti"), rs.getString("nome"),
						rs.getInt("pd"));
				corsi.add(corso);
			}
			
			return corsi;			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}

	public ArrayList<Collegamento> getAllCollegamenti() {

		final String sql = "SELECT * " + 
				"from iscrizione ";

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();
			ArrayList<Collegamento> collegamenti=new ArrayList<Collegamento>();

			while(rs.next()) {

				Collegamento coll = new Collegamento(
						new Studente(rs.getInt("matricola")),
						new Corso(rs.getString("codins"))
						);
				collegamenti.add(coll);
			}
			
			return collegamenti;			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}

	public LinkedList<Studente> getAllStudentiConCorsi() {

		final String sql = "SELECT s.matricola,s.cognome,s.nome,s.CDS, COUNT(*) AS numero " + 
				"from iscrizione i,studente s " + 
				"WHERE i.matricola=s.matricola " + 
				"GROUP BY matricola " + 
				"ORDER BY numero";

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();
			LinkedList<Studente> studenti=new LinkedList<Studente>();

			while(rs.next()) {

				Studente studente = new Studente(rs.getInt("matricola"), rs.getString("cognome"), rs.getString("nome"),
						rs.getString("cds"),rs.getInt("numero"));
				studenti.add(studente);
			}
			
			return studenti;			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}



}
