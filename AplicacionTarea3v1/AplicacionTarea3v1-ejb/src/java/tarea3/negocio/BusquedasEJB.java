package tarea3.negocio;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import tarea1.entidades.CentroMedico;
import tarea1.entidades.Paciente;
import tarea1.entidades.Profesional;
import tarea3.interfaces.BusquedasNegocio;

public class BusquedasEJB implements BusquedasNegocio {
    
    @PersistenceContext(unitName = "AplicacionTarea3")
    private EntityManager em;

    @Override
    public List<CentroMedico> buscarCentros() {
        TypedQuery<CentroMedico> centros = em.createNamedQuery("todosCentros",CentroMedico.class);
        return centros.getResultList();
    }

    @Override
    public List<Profesional> buscarProfesionales() {
        TypedQuery<Profesional> profesionales = em.createNamedQuery("todosProfesionales",Profesional.class);
        return profesionales.getResultList();
    }

    @Override
    public List<Paciente> buscarPacientes() {
         TypedQuery<Paciente> pacientes = em.createNamedQuery("todosPacientes",Paciente.class);
        return pacientes.getResultList();
    }
    
}
