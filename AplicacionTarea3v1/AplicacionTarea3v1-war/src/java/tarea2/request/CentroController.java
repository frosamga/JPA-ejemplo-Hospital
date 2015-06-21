package tarea2.request;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import tarea1.Direccion;
import tarea1.entidades.CentroMedico;
import tarea3.interfaces.CentroNegocio;
import tarea3.interfaces.CentroNegocio.ErrorCentro;

@Named(value = "centroController")
@RequestScoped
public class CentroController {
    
    @EJB 
    private CentroNegocio centroEjb;
    
    private CentroMedico centro;
    
    public CentroController(){
        centro = new CentroMedico();
        centro.setDireccion(new Direccion());
    }
    
    public List<CentroMedico> listaCentros(){
        return centroEjb.listaCentros();
    }
    
    
    public List<CentroMedico> buscarCentro(){
        List<CentroMedico> listaCentros = listaCentros();
        List<CentroMedico> centrosEncontrados = new ArrayList();
        for(CentroMedico c: listaCentros){
            if(centro.getNombre().equals(c.getNombre())){
                centrosEncontrados.add(c);
            }
        }
        return centrosEncontrados;
    
    }
    
    public String agregarCentro(){
        ErrorCentro e = centroEjb.agregarCentro(centro);
        FacesMessage fm = new FacesMessage();
        String error = "";
        
        switch(e){
            case CENTRO_REPETIDO_NOMBRE:
                error +="Ya existe un centro con el mismo nombre";
                break;
            case CENTRO_REPETIDO_CODIGO:
                error +="Ya exise un centro con el mismo código";
                break;
            case CENTRO_REPETIDO_DIRECCION:
                error +="Ya existe un centro en la misma dirección";
                break;
            case NO_ERROR:
                return "agregadoCorrectamente.xhtml";
        }
        
        fm.setSummary(error);
        FacesContext.getCurrentInstance().addMessage("agregar: centro",fm);
        return null;        
    }

    public CentroMedico getCentro() {
        return centro;
    }

    public void setCentro(CentroMedico centro) {
        this.centro = centro;
    }
    
}
