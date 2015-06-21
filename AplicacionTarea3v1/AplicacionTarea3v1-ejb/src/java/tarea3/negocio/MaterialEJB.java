package tarea3.negocio;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import tarea1.entidades.Material;
import tarea3.interfaces.materialNegocio;

/**
 *
 * @author Alan
 */
@Stateless
public class MaterialEJB implements materialNegocio {
        
    @PersistenceContext(unitName = "AplicacionTarea3")
    private EntityManager em;

    @Override
    public List<Material> listaMateriales() {
        TypedQuery<Material> listaMaterial = em.createNamedQuery("todosMateriales", Material.class);
        return listaMaterial.getResultList();
    }
    
    @Override
    public void agregarMaterial(Material m){
        em.persist(m);
    }
    
}
