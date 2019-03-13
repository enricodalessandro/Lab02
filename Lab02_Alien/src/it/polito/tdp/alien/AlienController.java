package it.polito.tdp.alien;

/**
 * Sample Skeleton for 'Alien.fxml' Controller Class
 */



import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {
	
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TextField txtWord;
    @FXML
    private TextArea txtResult;
    @FXML
    private Button btnTranslate;
    @FXML
    private Button btnReset;
    private Dizionario d=new Dizionario();
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnTranslate != null : "fx:id=\"bntTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";
    	
    }
  
    
    @FXML
    void doTranslate(ActionEvent event) {
    	String intera=txtWord.getText();
    	if (!intera.contains(" ")&& intera.matches("[a-zA-Z]*"))
    	{
    		String s=d.getTraduzione(intera);
			txtResult.appendText("La traduzione trovata per la parola"+intera+"  e' :"+s+"\n");
			txtWord.clear();
    	}
    	String p[] = intera.split(" ");
    	String parola=p[0];
    	String traduzione=p[1];
    	if (p[0].matches("[a-zA-Z]*")&& p[1].matches("[a-zA-Z]*")) 
    	{
    		
    			Word temp= new Word (parola,traduzione);
    			if (p.length==2)
    				{
    				d.addParola(temp);
    				txtWord.clear();
    				txtResult.appendText("Parola inserita correttamente\n");
    				}
    			
    			
    	}
    	
    	
    	    	
    }
    
    
    @FXML
    void doReset(ActionEvent event) {
    	txtResult.clear();

    }
    
}
