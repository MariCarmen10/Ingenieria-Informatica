/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmlapplication;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.util.converter.DoubleStringConverter;
import static javafxmlapplication.Utils.*;

/**
 *
 * @author jsoler
 */
public class FXMLDocumentController implements Initializable {
    private Label labelMessage;
    @FXML
    private Slider conversionRateSlider;
    @FXML
    private Label conversionRateLabel;
    @FXML
    private TextField inputAmount;
    @FXML
    private Button convertButton;
    @FXML
    private Button clearButton;
    @FXML
    private CheckBox autoCheckBoxButton;
    @FXML
    private TextField outputAmount;
    
    //=========================================================
    // event handler, fired when button is clicked or 
    //                      when the button has the focus and enter is pressed
    private void handleButtonAction(ActionEvent event) {
        labelMessage.setText("Hello, this is your first JavaFX project - IPC");
    }
    
    
    
    
     /**
     * Utility object to convert from String to double.
     */
    private final static DoubleStringConverter DOUBLE_STRING_CONVERTER = new DoubleStringConverter();
    /**
     * Utility object to convert from double to String using a decimal format.
     */
    private final static DecimalFormat CURRENCY_FORMAT = new DecimalFormat("#0.00");
    
    
    /**
     * Listens for changes in the input amount and calls method {@link #convertAction(javafx.event.ActionEvent)} in response
     */
    private final ChangeListener<String> inputAmountChangeListener = (observable, oldValue, newValue) -> convertAction(null);
    private final ChangeListener conversionRateChangeListener = (observable, oldValue, newValue) -> convertAction(null);

    
    
    //=========================================================
    // you must initialize here all related with the object 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void convertAction(ActionEvent event) {
        double inputValue;
        if (!inputAmount.getText().equals("") && isNumeric(inputAmount.getText())) {
            inputValue = DOUBLE_STRING_CONVERTER.fromString(inputAmount.getText());
            double outputValue = inputValue * conversionRateSlider.getValue();
            outputAmount.setText(CURRENCY_FORMAT.format(outputValue));
        }
    
    }

    @FXML
    private void clearAction(ActionEvent event) {
        inputAmount.setText("");
        outputAmount.setText("");
    }

    
    
    
    @FXML
    private void switchAutomaticConversion(ActionEvent event) {
        if (autoCheckBoxButton.isSelected()) {
            convertButton.setDisable(true);
   
            inputAmount.textProperty().addListener(inputAmountChangeListener);
            conversionRateSlider.valueProperty().addListener(conversionRateChangeListener);
            convertAction(null);
        } else {
            convertButton.setDisable(false);
         
            inputAmount.textProperty().removeListener(inputAmountChangeListener);
            conversionRateSlider.valueProperty().removeListener(conversionRateChangeListener);
        }
       
        
    }
    
    
    /**
     * Checks whether a given string satisfies the criteria to be converted into a Java number
     *
     * @param str
     * @return
     */
    private static boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    
}
