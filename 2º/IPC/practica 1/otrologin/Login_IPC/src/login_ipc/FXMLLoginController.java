/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login_ipc;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 *
 * @author jsoler
 */
public class FXMLLoginController implements Initializable {
    //========================================================
    // objects defined into FXML file with fx:id 
    @FXML
    private TextField texto_usuario;
    @FXML
    private Text mensaje_usuario;
    
    //=========================================================
    // event handler, fired when button is clicked or 
    //                      when the button has the focus and enter is pressed
//    private void handleButtonAction(ActionEvent event) {
//       labelMessage.setText("Hello, this is your first JavaFX project - IPC");
//    }
    
    //=========================================================
    // you must initialize here all related with the object 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void pulsadoIniciar(ActionEvent event) {
        mensaje_usuario.setText("Bienvenido " + texto_usuario.getText());
    }
    
}
