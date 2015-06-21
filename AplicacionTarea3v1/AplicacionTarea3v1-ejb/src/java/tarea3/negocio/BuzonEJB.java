package tarea3.negocio;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import tarea1.entidades.Buzon;
import tarea3.interfaces.BuzonNegocio;

@Stateless
public class BuzonEJB implements BuzonNegocio {
        
    @PersistenceContext(unitName = "AplicacionTarea3")
    private EntityManager em;

    @Override
    public List<Buzon> listaBuzones() {
        TypedQuery<Buzon> listaBuzones = em.createNamedQuery("todosBuzones", Buzon.class);
        return listaBuzones.getResultList();
    }
    
    @Override
    public void agregarBuzon(Buzon b){
        em.persist(b);
    }
    
}
