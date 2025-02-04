/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package vista;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.Persona;

/**
 * FXML Controller class
 *
 * @author maricarmen
 */
public class FXMLPersonaController implements Initializable {

    @FXML
    private TextField nombreefxID;
    @FXML
    private TextField apellidossfxID;

   
    public void initPersona( Persona p) {
        nombreefxID.setText(p.getNombre());
        apellidossfxID.setText(p.getApellidos());
    
    
    }
    
   
    
    
    
    
    /**
     * Initializes the controller class.
     */
   @Override
   public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
}
