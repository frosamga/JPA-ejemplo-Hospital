package tarea3.negocio;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import tarea1.Direccion;
import tarea1.entidades.DatosPersonales;
import tarea1.entidades.Usuario;
import tarea3.interfaces.DatosPersonalesNegocio;

@Stateless
public class DatosPersonalesEJB implements DatosPersonalesNegocio{
    
    @PersistenceContext(unitName = "AplicacionTarea3")
    private EntityManager em;
    
    @Override
    public ErrorDP modificarDatosPersonales(DatosPersonales dp) {
        Direccion dir = dp.getDireccion();
        if(dir.getCalle().equals("")){
            return ErrorDP.CALLE_VACIA;
        }
        if(dir.getCiudad().equals("")){
            return ErrorDP.CIUDAD_VACIA;
        }
        if(dir.getProvincia().equals("")){
            return ErrorDP.PROVINCIA_VACIA;
        }
        if(dir.getCodigoPostal().equals("")){
            return ErrorDP.CP_VACIO;
        }
        em.merge(dp);
        return ErrorDP.NO_ERROR;
    }

    @Override
    public ErrorDP modificarEmail(Usuario u) {
        String email = u.getEmail();
        if(email.equals("")){
            em.merge(u);
            return ErrorDP.NO_ERROR;
        }
        
        Boolean emailOk = false;
        int i=0;
        
        while(i<email.length() && email.charAt(i) != '@' ){
            i++;
        }
        while(i<email.length() && (email.charAt(i) >= 'a' || email.charAt(i) <= 'z')){
            i++;
        }
        if(i<email.length() && email.charAt(i) == '.'){
            while(i<email.length() && (email.charAt(i) >= 'a' || email.charAt(i) <= 'z')){
                i++;
                emailOk = true;
            }
        }
        if(i>=email.length() && emailOk){
            return ErrorDP.NO_ERROR;
        }else{
            return ErrorDP.EMAIL_INCORRECTO;
        }
    }
    
    @Override
    public Usuario buscarUsuario(Usuario u){
        return em.find(Usuario.class,u.getNombre());
    }
    
    @Override
    public DatosPersonales buscarDatosPersonales(DatosPersonales dp){
        return em.find(DatosPersonales.class,dp.getDni());
    }
}
