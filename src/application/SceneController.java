package application;

import java.util.ArrayList;
import java.util.List;


import factory.DAOFactory;
import factory.Persistance;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import pojo.Periodicite;
import pojo.Revue;

public class SceneController {
	
	@FXML
	private TextArea el_description;
	
	@FXML
	private TextField el_titre;
	
	@FXML
	private TextField el_tarif;
	
	@FXML
	private TextArea el_output;
	
	@FXML
	private ComboBox<String> el_periodicite;
	
	@FXML
	private ComboBox<String> el_persistance;
	
	private Persistance persistance = Persistance.LM;
	
	@FXML
	public void selectPersistance() {
		String choice = el_persistance.getSelectionModel().getSelectedItem().toString();
		
		if(choice.equals("MYSQL")) {
			persistance = Persistance.MYSQL;
		} else if(choice.equals("LM")) {
			persistance = Persistance.LM;
		}
	}
	
	@FXML
	protected void initialize() {
		// Set Persistance
		List<String> persist = new ArrayList<String>();
		persist.add(Persistance.MYSQL.toString());
		persist.add(Persistance.LM.toString());
		el_persistance.setItems(FXCollections.observableList(persist));
		
		// Set Periodicité
		List<Periodicite> perio = DAOFactory.getDAOFactory(persistance).getPeriodiciteDAO().getAll();
		List<String> perioStr = new ArrayList<String>();
		
		for(Periodicite p : perio) {
			perioStr.add(p.getLibelle());
		}
		
		el_periodicite.setItems(FXCollections.observableList(perioStr));
	}
	

	@FXML
	public void createRevue(MouseEvent event) {
		List<String> errors = new ArrayList<String>();
		
		// TITRE
		String titre = el_titre.getText().trim();
		
		if(titre.length() > 40) {
			errors.add("Titre trop long.");
		} else if(titre.length() == 0) {
			errors.add("Titre vide !");
		}		
		
		// DESCRIPTION
		String description = el_description.getText();
		
		if(description.length() > 400) {
			errors.add("Description trop long");
		} else if(description.length() == 0) {
			errors.add("Description vide !");
		}
		
		// TARIF
		float tarif_float = 0;
		try {
			tarif_float = Float.parseFloat(el_tarif.getText());
		} catch(NumberFormatException error) {
			errors.add("Le tarif n'est pas au bon format");
		}
		
		// PERIODICITE
		String periodicite_label = el_periodicite.getSelectionModel().getSelectedItem().toString();
		int periodicite_id = 0;
		try {
			List<Periodicite> periodicite = DAOFactory.getDAOFactory(persistance).getPeriodiciteDAO().getAll();
			for(Periodicite p : periodicite) {
				if(p.getLibelle().equals(periodicite_label)) {
					periodicite_id = p.getId();
				}
			}
		} catch(Exception error) {
			errors.add("Une erreur est survenue : " + error.getMessage());
		}
		
		if(errors.isEmpty()) {
			Revue revue = new Revue(-1, titre, description, tarif_float, "", periodicite_id);
			try {
				DAOFactory.getDAOFactory(persistance).getRevueDAO().create(revue);
				el_output.setText(revue.toString());
			} catch(Exception error) {
				el_output.setText("Une erreur est survenue : " + error.getMessage());
			}
		} else {
			String error = "";
			for(String s : errors) {
				error += s + "\n";
			}
			el_output.setText(error);
		}
	}
}