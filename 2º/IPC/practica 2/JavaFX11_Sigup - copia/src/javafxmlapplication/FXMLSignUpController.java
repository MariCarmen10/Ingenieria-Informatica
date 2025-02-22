/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmlapplication;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


/**
 *
 * @author svalero
 */
public class FXMLSignUpController implements Initializable {


 
    //properties to control valid fieds values. 
    private BooleanProperty validPassword;
    private BooleanProperty validEmail;
    private BooleanProperty equalPasswords;  

    //private BooleanBinding validFields;
    
    //When to strings are equal, compareTo returns zero
    private final int EQUALS = 0;  
    
    
    @FXML
    private TextField eemail;
    @FXML
    private PasswordField ppassword;
    @FXML
    private PasswordField ppassword2;
    @FXML
    private Button bAccept;
    @FXML
    private Button bCancel;
    @FXML
    private Label lIncorrectEmail;
    @FXML
    private Label lIncorrectPassword;
    
    @FXML
    private Label lPassDifferent;
    
    
   
   
    

    /**
     * Updates the boolProp to false.Changes to red the background of the edit. 
     * Makes the error label visible and sends the focus to the edit. 
     * @param errorLabel label added to alert the user
     * @param textField edit text added to allow user to introduce the value
     * @param boolProp property which stores if the value is correct or not
     */
    private void manageError(Label errorLabel,TextField textField, BooleanProperty boolProp ){
        boolProp.setValue(Boolean.FALSE);
        showErrorMessage(errorLabel,textField);
        textField.requestFocus();
 
    }
    /**
     * Updates the boolProp to true. Changes the background 
     * of the edit to the default value. Makes the error label invisible. 
     * @param errorLabel label added to alert the user
     * @param textField edit text added to allow user to introduce the value
     * @param boolProp property which stores if the value is correct or not
     */
    private void manageCorrect(Label errorLabel,TextField textField, BooleanProperty boolProp ){
        boolProp.setValue(Boolean.TRUE);
        hideErrorMessage(errorLabel,textField);
        
    }
    /**
     * Changes to red the background of the edit and
     * makes the error label visible
     * @param errorLabel
     * @param textField 
     */
    private void showErrorMessage(Label errorLabel,TextField textField)
    {
        errorLabel.visibleProperty().set(true);
        textField.styleProperty().setValue("-fx-background-color: #FCE5E0");    
    }
    /**
     * Changes the background of the edit to the default value
     * and makes the error label invisible.
     * @param errorLabel
     * @param textField 
     */
    private void hideErrorMessage(Label errorLabel,TextField textField)
    {
        errorLabel.visibleProperty().set(false);
        textField.styleProperty().setValue("");
    }

    
     private void checkEditEmail(){ 
            if(!Utils.checkEmail(eemail.textProperty().getValueSafe()))
                 //Incorrect email
                 manageError(lIncorrectEmail, eemail,validEmail);
            else
                manageCorrect(lIncorrectEmail, eemail,validEmail);
            } 

    private void checkEditPassword(){
            if(!Utils.checkPassword(ppassword.textProperty().getValueSafe()))
               //Incorrect password
               manageError(lIncorrectPassword, ppassword,validPassword);
            else
                manageCorrect(lIncorrectPassword, ppassword,validPassword);
            }
    
     
    
    
    
    
    //si las dos contraseñas son la misma
    private void checkEquals(){ 
        if(ppassword.textProperty().getValueSafe().compareTo(
           ppassword2.textProperty().getValueSafe()) != EQUALS){
            
                showErrorMessage(lPassDifferent,ppassword2); 
                equalPasswords.setValue(Boolean.FALSE); 
                ppassword.textProperty().setValue(""); 
                ppassword2.textProperty().setValue(""); 
                ppassword.requestFocus();
        } else // no hace falta la { } porque es solo una sentencia
        manageCorrect(lPassDifferent, ppassword2, equalPasswords);  
            
    }
    

   
    
    
    //=========================================================
    // you must initialize here all related with the object 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        validEmail = new SimpleBooleanProperty();
        validPassword = new SimpleBooleanProperty();   
        equalPasswords = new SimpleBooleanProperty();
        
        validPassword.setValue(Boolean.FALSE);
        validEmail.setValue(Boolean.FALSE);
        equalPasswords.setValue(Boolean.FALSE);
        
       
        
       
        BooleanBinding validFields = Bindings.and(validEmail, validPassword)
                 .and(equalPasswords);
        
        
        bAccept.disableProperty().bind(
                       Bindings.not(validFields)
                );
        
        bCancel.setOnAction( (event) ->{
                    bCancel.getScene().getWindow().hide();
                });
        
        
        
        eemail.focusedProperty().addListener((observable, oldValue, newValue)->{
            if(!newValue){ //focus lost.
                checkEditEmail();
               
            }
        });
            
         
      
        
        ppassword.focusedProperty().addListener((observable, oldValue, newValue)->{
            if(!newValue){ //focus lost.
                checkEditPassword();
                
            }
        });
        

       
        
        ppassword2.focusedProperty().addListener((observable, oldValue, newValue)->{
            if(!newValue){ //focus lost.
                checkEquals();
                
            }
        });
         
    }  
 
    
    // va fuera o dentro del inicialize y porque el otro fuera?
    @FXML
    private void handleBAcceptOnAction(ActionEvent event) {
        eemail.textProperty().setValue(""); 
        ppassword.textProperty().setValue(""); 
        ppassword2.textProperty().setValue("");
        
        validEmail.setValue(Boolean.FALSE); 
        validPassword.setValue(Boolean.FALSE); 
        equalPasswords.setValue(Boolean.FALSE);
    
    
    }

   
   
 
    
}