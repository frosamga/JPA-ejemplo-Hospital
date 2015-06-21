package tarea2.request;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Inject;
import tarea1.entidades.CentroMedico;
import tarea1.entidades.Paciente;
import tarea1.entidades.Usuario;
import tarea2.session.ControlAutorizacion;
import tarea3.interfaces.BusquedasNegocio;

public class BusquedasController {
    
    @EJB
    private BusquedasNegocio busquedaEjb;
    
    @Inject
    private ControlAutorizacion ca;
    
    private Usuario usuario;
    private CentroMedico centro;
    
    
    public List<Paciente> listaPacientes(){
        List<Paciente> pacientes = busquedaEjb.buscarPacientes();
        centro = ca.getProfesional().getDepartamento().getCentro();
        for(Paciente p: pacientes){
            if(!p.getCentroAsignado().equals(centro)){
                pacientes.remove(p);
            }
        }
        return pacientes;
    }
    
    

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public CentroMedico getCentro() {
        return centro;
    }

    public void setCentro(CentroMedico centro) {
        this.centro = centro;
    }
    
    
}
