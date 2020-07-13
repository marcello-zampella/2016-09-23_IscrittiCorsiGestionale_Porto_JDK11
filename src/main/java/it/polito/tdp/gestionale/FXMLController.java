package it.polito.tdp.gestionale;

import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ResourceBundle;

import it.polito.tdp.gestionale.model.Model;
import it.polito.tdp.gestionale.model.Studente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

//controller del turno A --> switchare al master_turnoB per turno B

public class FXMLController {
	
	private Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    

    @FXML
    private Button bottone;


    @FXML
    private TextArea txtResult;

    @FXML
    void doCorsiFrequentati(ActionEvent event) {
    	LinkedList<Studente> adiacenze=this.model.getNumeroCorsiStudenti();
    	for(Studente s: adiacenze) {
    		this.txtResult.appendText(s.getMatricola()+" "+s.getNumeroCorsi()+"\n");
    	}
    	
		this.bottone.setDisable(false);


    }

    @FXML
    void doVisualizzaCorsi(ActionEvent event) {
    	model.cercaCamminoMinimo();

    }

    @FXML
    void initialize() {
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'DidatticaGestionale.fxml'.";

    }

	public void setModel(Model model) {
		this.model = model;
		this.model.creaGrafo();
		this.bottone.setDisable(true);
		
		}
}
