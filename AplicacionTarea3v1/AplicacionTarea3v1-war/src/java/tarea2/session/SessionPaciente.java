package tarea2.session;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import tarea1.entidades.Paciente;

@Named(value = "myPaciente")
@SessionScoped
public class SessionPaciente implements Serializable {
    
    private Paciente paciente;

    public Paciente getPaciente() {
        return paciente;
    }
    
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    
}
