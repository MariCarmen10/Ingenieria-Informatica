/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.Persona;

/**
 * FXML Controller class
 *
 * @author jsoler
 */
public class FXMLPersonaController implements Initializable {

    @FXML
    private TextField nombreText;
    @FXML
    private TextField apellidosText;
    
    private boolean OK_pressed=false;
    private Persona persona;
    @FXML
    private TextField direccionText;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    boolean isOKPressed() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return OK_pressed;
    }
    
    
    
    
    
    public Persona getPersona(){
        return persona;
    }
    
    void setPersona(Persona selectedItem) {
        persona = new Persona(selectedItem.getNombre(), selectedItem.getApellidos(), selectedItem.getDireccion());
        nombreText.setText(persona.getNombre());
        apellidosText.setText(persona.getApellidos());
        direccionText.setText(persona.getDireccion());
    }
    
    
    
    

    @FXML
    private void okpressedd(ActionEvent event) {
        persona = new Persona(nombreText.getText(), apellidosText.getText(), direccionText.getText()); //crea persona al apretar botó OK
        OK_pressed=true;
        
        
        ((Stage)nombreText.getScene().getWindow()).close();   //tanca la finestra
        
    }

    
    @FXML
    private void cancelpressedd(ActionEvent event) {
        nombreText.getScene().getWindow().hide();  //tanca la finestra
        //altra forma de fer-ho -->  ((Stage)nombreText.getScene().getWindow()).close();   //tanca la finestra

    }

    
    
}
