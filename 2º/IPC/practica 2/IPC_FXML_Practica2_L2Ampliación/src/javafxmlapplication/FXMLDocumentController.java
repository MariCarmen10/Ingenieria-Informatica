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
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import static javafxmlapplication.Utils.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.input.*;
import javafx.scene.control.*;
import java.util.Set;


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
    @FXML
    private ToggleButton color;
    @FXML
    private Slider slider;
    @FXML
    private ColorPicker colorPick;
   
    
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
        mibola.radiusProperty().bind(slider.valueProperty());
        slider.focusedProperty().addListener((property, oldValue, newValue) -> {if(newValue){mibola.requestFocus();}});
    
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
       //if(event.getCode() == KeyCode.UP){
           //int row = GridPane.getRowIndex(mibola);
           //GridPane.setRowIndex(mibola , row-1);
       //}   
       //if(event.getCode() == KeyCode.DOWN){
           //int row = GridPane.getRowIndex(mibola);
           //if(row < 4){
           //GridPane.setRowIndex(mibola, row+1);}
       //}
       //if(event.getCode() == KeyCode.RIGHT){
          // int column = GridPane.getColumnIndex(mibola);
          // if(column < 4){
          // GridPane.setColumnIndex(mibola, column+1);}
      // }
      // if(event.getCode() == KeyCode.LEFT){
          // int column = GridPane.getColumnIndex(mibola);
           //GridPane.setColumnIndex(mibola, column-1);
      // }

        
        
        
    }

    @FXML
    private void presionarbola(MouseEvent event) {
       migrid.setConstraints(mibola, columnNorm(migrid, columnCalc(migrid, event.getSceneX())),
               rowNorm(migrid, rowCalc(migrid, event.getSceneY())));
        
        
    }

   double X_inicial;
   double Y_inicial;
    

   
   @FXML
    private void circuloPulsado(MouseEvent event) {
        X_inicial =event.getSceneX();
        Y_inicial =event.getSceneY();  
    
    }
   

    @FXML
    private void cercleArrastre(MouseEvent event) {
        
        mibola.setTranslateX(event.getSceneX()-X_inicial);
        mibola.setTranslateY(event.getSceneY()-Y_inicial);
       


    }


    

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
    private void cambioColor(ActionEvent event) {
        if(color.isSelected()){
           mibola.setFill(Color.TRANSPARENT);
           mibola.setStroke(colorPick.getValue());
        } else {
           mibola.setFill(colorPick.getValue());
           mibola.setStroke(Color.BLACK);
       }
    
    }

    @FXML
    private void selectColor(ActionEvent event) {
        if(color.isSelected()){
           mibola.setStroke(colorPick.getValue());
       } else {
           mibola.setFill(colorPick.getValue());

       }
    
    }

    @FXML
    private void cambiarTamaño(MouseEvent event) {
       
        
       
    
    
    
    }

   
    
}
