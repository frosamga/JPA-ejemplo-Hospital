package tarea2.request;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import tarea1.entidades.Buzon;
import tarea2.session.ControlAutorizacion;
import tarea3.interfaces.BuzonNegocio;

@Named("buzonController")
@RequestScoped
public class BuzonController implements Serializable {
   
    @EJB
    private BuzonNegocio buzonEjb;
    
    @Inject
    private ControlAutorizacion ca;
    
    private Buzon buzon;
    
    public BuzonController() {
        buzon = new Buzon();
    }
    
    public List<Buzon> listaBuzones(){
        return buzonEjb.listaBuzones();
    }
    
    
    public String agregarBuzon(){
        Date date = new Date(); 
        Timestamp fecha = new Timestamp (date.getTime());
        buzon.setFecha(fecha);
        buzon.setEmisor(ca.getUsuario());
        buzonEjb.agregarBuzon(buzon);
        return "enviadoCorrectamente.xhtml";
    }

    public Buzon getBuzon() {
        return buzon;
    }

    public void setBuzon(Buzon buzon) {
        this.buzon = buzon;
    }
}
