package tarea2.session;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import tarea1.Rol;
import tarea1.entidades.DatosPersonales;
import tarea1.entidades.Profesional;
import tarea1.entidades.Usuario;
import tarea3.interfaces.DatosPersonalesNegocio;

@Named(value = "controlAutorizacion")
@SessionScoped
public class ControlAutorizacion implements Serializable {

    private Usuario usuario;
    private DatosPersonales datosPersonales;
    private Profesional profesional;
    
    @EJB
    private DatosPersonalesNegocio datosPersonalesEjb;
    
    @Inject
    private SessionPaciente sessionPaciente;
    
    public ControlAutorizacion() {
    }
    
    
    /**
     * Crea las sessiones correspondientes al usuario
     */
    
    private void actualizarSession() {
        switch(usuario.getRol()){
            case PACIENTE:
                sessionPaciente.setPaciente(usuario.getPaciente());
                break;
            case SANITARIO:
            case ADMINISTRATIVO:
                // Asignar session de profesional
                // - Completar -
                break;
        }
    }
    
    
    
// Devuelven la página Home si no esta logueado o no esta autorizado

    public String agregarCentro(){
        if (usuario == null){
            return "login.xhtml";
        }
        
        switch (usuario.getRol()) {
            case PACIENTE:
                return "paciente.xhtml";
            case SANITARIO:
                 return "sanitario.xhtml";
            case ADMINISTRATIVO:
                return "agregarCentro.xhtml";
            default:
                return null;
        }
        
    }
    
    public String verMateriales(){
        switch(usuario.getRol()){
            case PACIENTE:
                return "paciente.xhtml";
            case SANITARIO:
                return "materiales.xhtml"; 
            case ADMINISTRATIVO:
                return "materiales.xhtml";
            default:
                return null;
        }
    }
    
    public String agregarUsuario(){
        if(usuario.getRol().equals(Rol.ADMINISTRATIVO)){
            return "agregarUsuario.xhtml";
        }
        return null;
    }

    public String historialPropioPaciente() {
        switch(usuario.getRol()){
            case PACIENTE:
                return "historialclinicopropio.xhtml";
            default:
                return null;
        }
    }

    public String verAlertas(){
         if (usuario == null){
            return "login.xhtml";
         }
        switch (usuario.getRol()) {
            case PACIENTE:
                return "paciente.xhtml";
            case SANITARIO:
            case ADMINISTRATIVO:
                return "verAlertas.xhtml";
            default:
                return null;
        }
    }
    
    public String crearNotificacion(){
        if (usuario == null){
            return "login.xhtml";
         }else{
            switch (usuario.getRol()){
                 case PACIENTE:
                    return "paciente.xhtml";
                case SANITARIO:
                    return "crearNotificacion.xhtml";
                case ADMINISTRATIVO:
                    return "crearNotificacion.xhtml";
                default:
                    return null;
            }
        }
    }
    
    public String verNotificacion(){
         if (usuario == null){
            return "login.xhtml";
         }else{
             return "verNotificacion.xhtml";
         }
    }
    
    public String verBuzon(){
        switch(usuario.getRol()){
            case PACIENTE:
                return "paciente.xhtml";
            case SANITARIO:
                return "sanitario.xhtml";
            case ADMINISTRATIVO:
                return "mostrarEntradaBuzon.xhtml";
            default:
                return null;
        }
    }
    
    public String datosProfesionales(){
        switch(usuario.getRol()){
            case PACIENTE:
                return "paciente.xhtml";
            case SANITARIO:
            case ADMINISTRATIVO:
                return "datosProfesionales.xhtml";
            default:
                return null;
        }
    }
    
    public String crearAlerta(){
        switch(usuario.getRol()){
            case PACIENTE:
                return "paciente.xhtml";
            case SANITARIO:
            case ADMINISTRATIVO:
                return "crearAlerta.xhtml";
            default:
                return null;
        }
    }
    
    public String leerdatos() {
        
        if (usuario == null)
            return "login.xhtml";
        
        switch (usuario.getRol()) {
            case SANITARIO:
                return "datossanitario.xhtml";
            case PACIENTE:
                return "datospaciente.xhtml";
            case ADMINISTRATIVO:
                return "datosadministrativo.xhtml";
            default:
                return null;
        }
    }

    public String buscarPaciente() {
        
        if (usuario == null) {
            return "login.xhtml";
        }
        
        switch (usuario.getRol()) {
            case SANITARIO:
                return "buscarPaciente.xhtml";
            case PACIENTE:
                return "paciente.xhtml";
            case ADMINISTRATIVO:
                return "buscarPaciente.xhtml";
            default:
                return null;
        }
    }
     public String buscarMedico() {
        
        if (usuario == null) {
            return "login.xhtml";
        }
        return "buscarMedico.xhtml";
    }
     public String errorBusqueda() {

                return "errorbusqueda.xhtml";

    }
    public String buscarPacientes() {
      
        if (usuario == null) {
            return "login.xhtml";
        }
        switch (usuario.getRol()) {
            case SANITARIO:
                return "buscarPaciente.xhtml";
            case PACIENTE:
                return "paciente.xhtml";
            case ADMINISTRATIVO:
                return "buscarPaciente.xhtml";
            default:
                return null;
        }
    }
    
    
    public boolean esPaciente(){
        return usuario.getRol().equals(Rol.PACIENTE);
    }
    
    public boolean esAdministrativo(){
        return usuario.getRol().equals(Rol.ADMINISTRATIVO);
    }
    
    public String home() {
        if (usuario == null) {
            return "login.xhtml";
        }
        switch (usuario.getRol()) {
            case SANITARIO:
                return "sanitario.xhtml";
            case PACIENTE:
                return "paciente.xhtml";
            case ADMINISTRATIVO:
                return "administrativo.xhtml";
            default:
                return null;
        }
    }    
   
    public String logout() {
        // Destruye la sesión (y con ello, el ámbito de este bean)
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.getExternalContext().invalidateSession();
        usuario = null;
        return "login.xhtml";
    }

    public void logoutbus() {
        // Destruye la sesión (y con ello, el ámbito de este bean)
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.getExternalContext().invalidateSession();
        usuario = null;
        home();
    }
    
    public String modificarDatosPersonales(){
        DatosPersonalesNegocio.ErrorDP e = datosPersonalesEjb.modificarDatosPersonales(datosPersonales);
        String error = "";
        String var = "";
        
        DatosPersonalesNegocio.ErrorDP errorEmail = datosPersonalesEjb.modificarEmail(usuario);
        if(errorEmail.equals(DatosPersonalesNegocio.ErrorDP.EMAIL_INCORRECTO)){
            FacesMessage fm = new FacesMessage("El e-mail introducido es incorrecto, introduzca un e-mail válido");
            FacesContext.getCurrentInstance().addMessage("Modificar: e-mail",fm);
            return null;
        }
        
        switch(e){
            case NO_ERROR:
                return "enviadoCorrectamente.xhtml";
            case CALLE_VACIA:
                error += "El campo 'Calle' no puede ser vacío";
                var += "Calle";
                break;
            case PROVINCIA_VACIA:
                error += "El campo 'Provincia' no puede ser vacío";
                var += "Provincia";
                break;
            case CIUDAD_VACIA:
                error += "El campo 'Ciudad' no puede ser vacío";
                var += "Ciudad";
                break;
            case CP_VACIO:
                error += "El campo 'Codigo Postal' no pued ser vacío";
                var += "CodigoPostal";
                break;
        }
        
        FacesMessage fm = new FacesMessage(error);
        FacesContext.getCurrentInstance().addMessage("Modificar: "+var,fm);
        return null;
    }

    private void actualizarDatosPersonales(){
        switch(usuario.getRol()){
            case PACIENTE:
                setDatosPersonales(usuario.getPaciente().getDatosPersonales());
                break;
            case SANITARIO:
            case ADMINISTRATIVO:
                setDatosPersonales(usuario.getProfesional().getDatosPersonales());
                break;
            default:
               setDatosPersonales(null); 
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
        actualizarDatosPersonales();
        setProfesional(usuario.getProfesional());
        actualizarSession();
    }

    public Profesional getProfesional() {
        return profesional;
    }

    public void setProfesional(Profesional profesional) {
        this.profesional = profesional;
    }
    
    public DatosPersonales getDatosPersonales() {
        return datosPersonales;
    }

    public void setDatosPersonales(DatosPersonales datosPersonales) {
        this.datosPersonales = datosPersonales;
    }
}