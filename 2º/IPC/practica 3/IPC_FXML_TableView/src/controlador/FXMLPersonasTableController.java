/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.Persona;

/**
 * FXML Controller class
 *
 * @author jsoler
 */
public class FXMLPersonasTableController implements Initializable {

    
    private ObservableList<Persona> datos = null; // Colecci�n vinculada a la vista.
    
    @FXML
    private Button addButton;
    @FXML
    private Button modButton;
    @FXML
    private Button delButton;
    @FXML
    private TableView<Persona> personasTable;
    @FXML
    private TableColumn<Persona, String> nomColum;
    @FXML
    private TableColumn<Persona, String> apellColum;
    @FXML
    private TableColumn<Persona, String> dirColum;

    
    private void inicializaModelo() {
        ArrayList<Persona> misdatos = new ArrayList<Persona>();
        misdatos.add(new Persona("Pepe", "García", "Valencia"));
        misdatos.add(new Persona("María", "Pérez", "Madrid"));
        datos = FXCollections.observableList(misdatos);

    }
    
    /**
     * Initializes the controller class.
     */ 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        inicializaModelo();
        personasTable.setItems(datos);
        nomColum.setCellValueFactory(celda -> celda.getValue().NombreProperty()); //no se pone new pq ya agarra el primer string y no hace falta los demas
        apellColum.setCellValueFactory(celda -> 
                new SimpleStringProperty(celda.getValue().getApellidos()));
        dirColum.setCellValueFactory(celda -> 
                new SimpleStringProperty(celda.getValue().getDireccion()));
        // apellColum.setCellValueFactory(celda -> celda.getValue().ApellidosProperty());)
    }    


    @FXML
    private void modificar(ActionEvent event) throws IOException {
    
        //======================================================================
        // 1- creación del grafo de escena a partir del fichero FXML
        FXMLLoader loader= new  FXMLLoader(getClass().getResource("/vista/FXMLPersona.fxml"));
        Parent root = loader.load();
        //======================================================================
        // 2- creación de la escena con el nodo raiz del grafo de escena
        Scene scene = new Scene(root);
        //======================================================================
        // 3- asiganación de la escena al Stage que recibe el metodo 
        //     - configuracion del stage
        //     - se muestra el stage de manera no modal mediante el metodo show()
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Modificar Persona");
        
        stage.initModality(Modality.APPLICATION_MODAL);
        FXMLPersonaController controladorPersona = loader.getController();
        
        //stage.show();
        controladorPersona.setPersona(personasTable.getSelectionModel().getSelectedItem());
        stage.showAndWait();
        if(controladorPersona.isOKPressed()){
            Persona cambio = controladorPersona.getPersona();
            personasTable.getSelectionModel().getSelectedItem().setNombre(cambio.getNombre());
            personasTable.getSelectionModel().getSelectedItem().setApellidos(cambio.getApellidos());
            personasTable.getSelectionModel().getSelectedItem().setDireccion(cambio.getDireccion());
        
        }
   
    
    }

    @FXML
    private void borrar(ActionEvent event) throws IOException {
        int i = personasTable.getSelectionModel().getSelectedIndex();

        if (i>=0) datos.remove(i);


    }
    
    

    @FXML
    private void anyadir(ActionEvent event) throws IOException {
    
        //======================================================================
        // 1- creación del grafo de escena a partir del fichero FXML
        FXMLLoader loader= new  FXMLLoader(getClass().getResource("/vista/FXMLPersona.fxml"));
        Parent root = loader.load();
        //======================================================================
        // 2- creación de la escena con el nodo raiz del grafo de escena
        Scene scene = new Scene(root);
        //======================================================================
        // 3- asiganación de la escena al Stage que recibe el metodo 
        //     - configuracion del stage
        //     - se muestra el stage de manera no modal mediante el metodo show()
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Anyadir Persona");
        
        stage.initModality(Modality.APPLICATION_MODAL);
        FXMLPersonaController controladorPersona = loader.getController();
        
        //stage.show();
        stage.showAndWait();
        if(controladorPersona.isOKPressed()){
            datos.add(controladorPersona.getPersona());
        
        }
        
    
    
    }
    
}
