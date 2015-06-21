package tarea2.request;

import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import tarea1.entidades.CentroMedico;
import tarea1.entidades.DatosPersonales;
import tarea1.entidades.Profesional;
import tarea2.session.ControlAutorizacion;
import tarea3.interfaces.BusquedasNegocio;

@Named(value = "buscarMedicoController")
@RequestScoped
public class BuscarMedicoController {
    
    @EJB
    private BusquedasNegocio busquedaEjb;
    
    @Inject
    private ControlAutorizacion ctrl;
    
    private Profesional profesional;
    
    private DatosPersonales datosMedico;
    
    private CentroMedico centro;
    
    public BuscarMedicoController(){
        datosMedico = new DatosPersonales();
    }

    public String buscarMedico() {
        List<Profesional> profesionales = busquedaEjb.buscarProfesionales();
        for (Profesional prof: profesionales) {
            boolean nombre = prof.getDatosPersonales().getNombre().equalsIgnoreCase(datosMedico.getNombre());
            boolean apellido1 = prof.getDatosPersonales().getApellido1().equalsIgnoreCase(datosMedico.getApellido1());
            boolean apellido2 = prof.getDatosPersonales().getApellido2().equalsIgnoreCase(datosMedico.getApellido2());
                   
            if (nombre || apellido1 || apellido2) {
                profesional = prof;
                datosMedico = prof.getDatosPersonales();
                return "verDatosDeSanitario.xhtml";
            }            
        }
        return "errorbusqueda.xhtml";
    }

    public List<Profesional> listaProfesionales(){
         List<Profesional> profesionales = busquedaEjb.buscarProfesionales();
        centro = ctrl.getUsuario().getPaciente().getCentroAsignado();
        /*for(Profesional p: profesionales){
            if(!p.getDepartamento().getCentro().equals(centro)){
                profesionales.remove(p);
            }
        }
                */
        return profesionales;
    }    
    
    
    public Profesional getProfesional() {
        return profesional;
    }

    public void setProfesional(Profesional profesional) {
        this.profesional = profesional;
    }

    public DatosPersonales getDatosMedico() {
        return datosMedico;
    }

    public void setDatosMedico(DatosPersonales datosMedico) {
        this.datosMedico = datosMedico;
    }

    public CentroMedico getCentro() {
        return centro;
    }

    public void setCentro(CentroMedico centro) {
        this.centro = centro;
    }
    
}
