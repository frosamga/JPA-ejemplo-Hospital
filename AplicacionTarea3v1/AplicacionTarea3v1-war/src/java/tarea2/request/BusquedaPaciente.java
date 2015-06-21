package tarea2.request;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import tarea1.entidades.Usuario;

@Named(value = "buscarPaciente")
@RequestScoped
public class BusquedaPaciente {
    
    private String numSS;
    private String dni;
    private String nombre, apellido1, apellido2;
    
    private List<Usuario> listUsuarios;

    public String getNumSS() {
        return numSS;
    }

    public void setNumSS(String numSS) {
        this.numSS = numSS;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public List<Usuario> getListUsuarios() {
        return listUsuarios;
    }
    
    public String buscar() {
        // Implementar
        return "";
    }
    
}
