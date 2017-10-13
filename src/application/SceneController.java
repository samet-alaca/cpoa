package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resources;

import dao.DAO;
import factory.DAOFactory;
import factory.Persistance;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
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
	private Label el_errors;
	
	@FXML
	private Label el_output;
	
	@FXML
	private ComboBox<String> el_periodicite;
	
	private Persistance persistance = Persistance.LM;
	
	
	@FXML
	protected void initialize() {
		List<Periodicite> liste = DAOFactory.getDAOFactory(persistance).getPeriodiciteDAO().getAll();
		List<String> liste2 = new ArrayList<String>();
		
		for(Periodicite p : liste) {
			liste2.add(p.getLibelle());
		}
		
		ObservableList<String> observableList = FXCollections.observableList(liste2);
		el_periodicite.setItems(observableList);
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
		List<Periodicite> periodicite = DAOFactory.getDAOFactory(persistance).getPeriodiciteDAO().getAll();
		for(Periodicite p : periodicite) {
			if(p.getLibelle().equals(periodicite_label)) {
				periodicite_id = p.getId();
			}
		}
		
		if(errors.isEmpty()) {
			Revue r = new Revue(-1, titre, description, tarif_float, "", periodicite_id);
			DAOFactory.getDAOFactory(persistance).getRevueDAO().create(r);
			el_output.setText(r.toString());
		} else {
			String error = "";
			for(String s : errors) {
				error += s + "\n";
			}
			el_output.setText(error);
		}
	}
}