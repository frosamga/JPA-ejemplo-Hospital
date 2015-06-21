package tarea3.interfaces;

import java.util.List;
import tarea1.entidades.CentroMedico;
import tarea1.entidades.Paciente;
import tarea1.entidades.Profesional;

public interface BusquedasNegocio {
    
    public List<CentroMedico> buscarCentros();
    public List<Profesional> buscarProfesionales();
    public List<Paciente> buscarPacientes();
    
}
