package tarea2.request;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import tarea1.Direccion;
import tarea1.entidades.CentroMedico;
import tarea1.entidades.DatosPersonales;
import tarea1.entidades.Departamento;
import tarea1.entidades.Paciente;
import tarea1.entidades.Profesional;
import tarea1.entidades.Usuario;
import tarea2.session.ControlAutorizacion;
import tarea3.interfaces.LoginNegocio;
import static tarea3.interfaces.LoginNegocio.ErrorLogin.USUARIO_REPETIDO;


@Named(value = "registrar")
@RequestScoped
public class Registrar {
    
    @EJB
    private LoginNegocio loginEjb;

    @Inject
    private ControlAutorizacion ca;
    
    private Usuario usuario;
    private DatosPersonales datosPersonales;
    private String repass;
    private String fechaNacimiento;
    
    public Registrar() {
        usuario = new Usuario();
        datosPersonales = new DatosPersonales();
        datosPersonales.setDireccion(new Direccion());
    }
    
    public void asignarMedico(CentroMedico centro){
        List<Usuario> candidatos = loginEjb.asignarMedico(centro);
        boolean asignado = false;
        while(!asignado && candidatos.size()>0){
            Random r = new Random();
            int i = r.nextInt(candidatos.size());
            Usuario user = candidatos.get(i);
             //Comprueba que no se asigne un médico a él mismo como médico de cabecera
            if(!user.getProfesional().getDatosPersonales().equals(usuario.getPaciente().getDatosPersonales())){
                usuario.getPaciente().setMedicoAsignado(user.getProfesional());
            }
            asignado = true;
        }
    }
    
    public CentroMedico asignarCentro(){
        List<CentroMedico> centros = loginEjb.listaCentros();
        List<CentroMedico> centroCiudad = new ArrayList();
        for(CentroMedico c: centros){
            if(!c.getDireccion().getProvincia().equals(datosPersonales.getDireccion().getProvincia())){
                centros.remove(c);
            }else if(c.getDireccion().getCiudad().equals(datosPersonales.getDireccion().getCiudad())){
                centroCiudad.add(c);
            }
        }
        Random r = new Random();
        int tamList = centroCiudad.size();
        if(tamList>0){
            int i = r.nextInt(tamList);
            return centroCiudad.get(i);
        }else{
            tamList = centros.size();
            if(tamList>0){
                int i = r.nextInt(tamList);
                return centros.get(i);
            }else{
                FacesMessage fm = new FacesMessage("No se ha encontrado ningun centro en su provincia");
                FacesContext.getCurrentInstance().addMessage(null,fm);
                return null;
            }
        }
    }

    public void asignarDepartamento(){
        List<Departamento> departamentos = loginEjb.listaDepartamentos();
        List<Departamento> depCiudad = new ArrayList();
        for(Departamento d: departamentos){
            if(!d.getCentro().getDireccion().getProvincia().equals(datosPersonales.getDireccion().getProvincia())){
                departamentos.remove(d);
            }else if(d.getCentro().getDireccion().getCiudad().equals(datosPersonales.getDireccion().getCiudad())){
                depCiudad.add(d);
            }
        } 
        
        Random r = new Random();
        int tamList = depCiudad.size();
        
        if(tamList>0){
            int i = r.nextInt(tamList);
            usuario.getProfesional().setDepartamento(depCiudad.get(i));
        }else{
            tamList = departamentos.size();
            if(tamList>0){
                int i = r.nextInt(tamList);
                usuario.getProfesional().setDepartamento(departamentos.get(i));
            }else{
                FacesMessage fm = new FacesMessage("No se ha encontrado ningun centro en su provincia, no se le puede asignar un departamento");
                FacesContext.getCurrentInstance().addMessage(null,fm);
            }
        }
    }
    
    public String registro() throws ParseException {
        if(usuario.getPassword().equals(repass)){
           usuario.setEstado(true);
            switch(usuario.getRol()){
               case PACIENTE:
                   Paciente paciente = new Paciente();
                   paciente.setUsuario(usuario);
                   paciente.setDatosPersonales(datosPersonales);
                   paciente.setHistorialMedico(new ArrayList());
                   CentroMedico centroAsig = asignarCentro();
                   paciente.setCentroAsignado(centroAsig);
                   asignarMedico(centroAsig);
                   paciente.setNotificaciones(new ArrayList());
                   break;
               case SANITARIO:
               case ADMINISTRATIVO:
                   Profesional profesional = new Profesional();
                   profesional.setDatosPersonales(datosPersonales);
                   
                   Date fechaActual = new Date();
                   java.sql.Date fechaComienzo = new java.sql.Date(fechaActual.getDate(),fechaActual.getMonth(),fechaActual.getYear());
                   profesional.setFechaComienzo(fechaComienzo);
                   asignarDepartamento();
                   profesional.setAlerta(new ArrayList());
                   profesional.setSolicitar(new ArrayList());
                   break;
            }
            
            
            SimpleDateFormat formatoFecha = new SimpleDateFormat();
            Date fechaN = formatoFecha.parse(fechaNacimiento);
            datosPersonales.setFechaNacimiento((java.sql.Date) fechaN);
            
            Date fechaActual = new Date();
            java.sql.Date fechaAlta = new java.sql.Date(fechaActual.getDate(),fechaActual.getMonth(),fechaActual.getYear());
            usuario.setFecha_alta(fechaAlta);
            
            if(loginEjb.registrar(usuario).equals(USUARIO_REPETIDO)){
                FacesMessage fm = new FacesMessage("Existe un usuario con la misma cuenta");
                FacesContext.getCurrentInstance().addMessage(null,fm);
                return null;
            }
            return "login.xhtml";
        }
        FacesMessage fm = new FacesMessage("Las contraseñas deben coincidir");
        FacesContext.getCurrentInstance().addMessage(null,fm);
        return null;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public DatosPersonales getDatosPersonales() {
        return datosPersonales;
    }

    public void setDatosPersonales(DatosPersonales datosPersonales) {
        this.datosPersonales = datosPersonales;
    }

    public String getRepass() {
        return repass;
    }

    public void setRepass(String repass) {
        this.repass = repass;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
}

