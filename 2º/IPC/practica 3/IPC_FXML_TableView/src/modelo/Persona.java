package modelo;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Persona {
	
    private final StringProperty nombre = new SimpleStringProperty();
    private final StringProperty apellidos = new SimpleStringProperty();
	
    private String direccion;

    /**
     * Get the value of direccion
     *
     * @return the value of direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Set the value of direccion
     *
     * @param direccion new value of direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

        
        
   // public Persona(String nombre, String apellidos) {
       // this.nombre.setValue(nombre);
       // this.apellidos.setValue(apellidos);
   // }

    public final StringProperty NombreProperty() {
        return this.nombre;
    }

    public final java.lang.String getNombre() {
        return this.NombreProperty().get();
    }

    public final void setNombre(final java.lang.String Nombre) {
        this.NombreProperty().set(Nombre);
    }

    public final StringProperty ApellidosProperty() {
        return this.apellidos;
    }

    public final java.lang.String getApellidos() {
        return this.ApellidosProperty().get();
    }

    public final void setApellidos(final java.lang.String Apellidos) {
        this.ApellidosProperty().set(Apellidos);
    }

    
    
    
    
    public Persona(String nombre, String apellidos, String direccion) {

        this.nombre.setValue(nombre);
        this.apellidos.setValue(apellidos);
        this.direccion = direccion;

    }
         
         
 }
        
        

