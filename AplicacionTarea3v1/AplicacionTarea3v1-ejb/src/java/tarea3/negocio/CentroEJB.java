package tarea3.negocio;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import tarea1.entidades.CentroMedico;
import tarea3.interfaces.CentroNegocio;

@Stateless
public class CentroEJB implements CentroNegocio{
    @PersistenceContext(unitName = "AplicacionTarea3")
    private EntityManager em;

    
    @Override
    public List<CentroMedico> listaCentros(){
        TypedQuery<CentroMedico> consultaCentro = em.createNamedQuery("todosCentros",CentroMedico.class);
        return consultaCentro.getResultList();
    }
    
    @Override
    public ErrorCentro agregarCentro(CentroMedico c){
        List<CentroMedico> listaCentros = listaCentros();
        
        for(CentroMedico centro: listaCentros){
            if(centro.getCodigo().equals(c.getCodigo())){
                return ErrorCentro.CENTRO_REPETIDO_CODIGO;
            }
            if(centro.getNombre().equals(c.getNombre())){
                return ErrorCentro.CENTRO_REPETIDO_NOMBRE;
            }
            if(centro.getDireccion().equals(c.getDireccion())){
                return ErrorCentro.CENTRO_REPETIDO_DIRECCION;
            }
        }
        em.merge(c);
        return ErrorCentro.NO_ERROR;
    }
    
}
