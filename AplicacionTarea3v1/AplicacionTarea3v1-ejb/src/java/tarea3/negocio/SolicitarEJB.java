/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tarea3.negocio;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import tarea1.entidades.Solicitar;
import tarea3.interfaces.SolicitarNegocio;

/**
 *
 * @author Alan_2
 */
@Stateless
public class SolicitarEJB implements SolicitarNegocio {
        
    @PersistenceContext(unitName = "AplicacionTarea3")
    private EntityManager em;

    @Override
    public List<Solicitar> listaMaterialesSolicitar() {
        TypedQuery<Solicitar> listaSolicitar = em.createNamedQuery("todosSolicitar", Solicitar.class);
        return listaSolicitar.getResultList();
    }
    
    @Override
    public void solicitarMaterial(Solicitar s){
        em.persist(s);
    }
    
}
