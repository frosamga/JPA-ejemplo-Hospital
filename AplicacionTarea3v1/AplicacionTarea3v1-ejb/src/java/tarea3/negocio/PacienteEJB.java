package tarea3.negocio;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import tarea1.entidades.HistoriaClinica;
import tarea1.entidades.Paciente;

@Stateless
public class PacienteEJB {
    
    @PersistenceContext(unitName = "AplicacionTarea3")
    private EntityManager em;
    
    public void anadirHistorial(HistoriaClinica historial){
        em.persist(historial);
    }
    
    public void refrescar(Paciente paciente) {
        em.refresh(paciente);
    }
    
    
}
