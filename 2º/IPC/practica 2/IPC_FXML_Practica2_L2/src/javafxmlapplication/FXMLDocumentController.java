/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmlapplication;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import static javafxmlapplication.Utils.*;

/**
 *
 * @author jsoler
 */
public class FXMLDocumentController implements Initializable {
    private Label labelMessage;
    @FXML
    private GridPane migrid;
    @FXML
    private Circle mibola;
    
    //=========================================================
    // event handler, fired when button is clicked or 
    //                      when the button has the focus and enter is pressed
    //private void handleButtonAction(ActionEvent event) {
      //  labelMessage.setText("Hello, this is your first JavaFX project - IPC");
    //}
    
    //=========================================================
    // you must initialize here all related with the object 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void moverbola(KeyEvent event) {
        KeyCode teclaPolsada=event.getCode();
        switch(teclaPolsada) {
            case UP:
              GridPane.setRowIndex(mibola,
                      rowNorm(migrid, GridPane.getRowIndex(mibola)-1));
                break;
                
            case DOWN:
                GridPane.setRowIndex(mibola,
                      rowNorm(migrid, GridPane.getRowIndex(mibola)+1));  
                break;
            
            case LEFT:
                GridPane.setColumnIndex(mibola,
                      rowNorm(migrid, GridPane.getColumnIndex(mibola)-1));
                break;
            
            case RIGHT:
                GridPane.setColumnIndex(mibola,
                      rowNorm(migrid, GridPane.getColumnIndex(mibola)+1));
        
        
        }
        
        
    }

    @FXML
    private void presionarbola(MouseEvent event) {
       migrid.setConstraints(mibola, columnNorm(migrid, columnCalc(migrid, event.getSceneX())),
               rowNorm(migrid, rowCalc(migrid, event.getSceneY())));
        
        
    }

   double X_inicial;
   double Y_inicial;
    
    
    @FXML
    private void soltarBola(MouseEvent event) {
        mibola.setTranslateX(0);
        mibola.setTranslateY(0);
        double x = event.getSceneX();
        double y = event.getSceneY();
        int row = Utils.rowCalc(migrid, y);
        int column = Utils.columnCalc(migrid, x);
        
        if(row > 4) {
            row = 4;
        }
        
        if(column > 4) {
            column = 4;
        }
        
        GridPane.setConstraints(mibola, column, row);
        
        event.consume();
        
    }

    @FXML
    private void cercleArrastre(MouseEvent event) {
        
        mibola.setTranslateX(event.getSceneX() -X_inicial);
        mibola.setTranslateY(event.getSceneY() -Y_inicial);
       


    }


    @FXML
    private void circuloPulsado(MouseEvent event) {
        X_inicial =event.getSceneX();
        Y_inicial =event.getSceneY();  
      
    
    
    }
   

    
    
    
    
}
