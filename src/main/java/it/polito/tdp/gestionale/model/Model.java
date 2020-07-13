package it.polito.tdp.gestionale.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import it.polito.tdp.gestionale.db.DidatticaDAO;

public class Model {
	
	public Model() {
		dao=new DidatticaDAO();
	}
	
	private DidatticaDAO dao;
	private SimpleGraph<Nodo, DefaultEdge> grafo;
	private ArrayList<Studente> studenti;
	private ArrayList<Corso> corsi;
	private ArrayList<Collegamento> collegamenti;

	public void creaGrafo() {
		grafo=new SimpleGraph<Nodo, DefaultEdge>(DefaultEdge.class);
		studenti= dao.getAllStudenti();
		corsi=dao.getAllCorsi();
		Graphs.addAllVertices(grafo, studenti);
		Graphs.addAllVertices(grafo, corsi);
		collegamenti=dao.getAllCollegamenti();
		for(Collegamento c:collegamenti) {
			grafo.addEdge(c.getC(), c.getS());
		}

	}

	public LinkedList<Studente> getNumeroCorsiStudenti() {
		studentiNumero=dao.getAllStudentiConCorsi();
		return studentiNumero;
	}
	LinkedList<Studente> studentiNumero;
	HashSet<Studente> totali;

	public void cercaCamminoMinimo() {
		int livello=0;
		minore=0;
		totali=new HashSet<Studente>(studentiNumero);
		HashSet<Studente> raggiunti=new HashSet<Studente>();
		ArrayList<Corso> parziale=new ArrayList<Corso>();
		
		espandi(livello,parziale,raggiunti);
		System.out.println(migliore);
	}
	
	private int minore;
	private ArrayList<Corso> migliore;

	private void espandi(int livello, ArrayList<Corso> parziale, HashSet<Studente> raggiunti) { 
		if(raggiunti.size()>totali.size()) {
			System.out.println("OKAY BOOOOOOOOOOOOOOOOOOOMER");
			return;
		}
		if(raggiunti.size()==totali.size()) {
			//condizione di terminazione
			if(parziale.size()<minore) {
				minore=parziale.size();
				migliore=new ArrayList<Corso>(parziale);
				System.out.println(minore);
			}
			return;
		}
		
		for(Corso c: this.corsi) {
			if(!parziale.contains(c)) {
				parziale.add(c);
				HashSet<Studente> raggiuntiNuovi=new HashSet<Studente>();
				for(Corso temp:parziale) {
					for(Collegamento coll:collegamenti) {
					if(temp.equals(coll.getC())) {
						raggiuntiNuovi.add(coll.getS());
					}
					}
				}
				espandi(livello+1,parziale,raggiuntiNuovi);
			parziale.remove(c);
			}
		}
		
		
		
		
	}

}
