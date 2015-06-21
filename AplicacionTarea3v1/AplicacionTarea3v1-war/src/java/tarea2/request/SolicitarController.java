package tarea2.request;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import tarea1.entidades.Solicitar;
import tarea2.session.ControlAutorizacion;
import tarea3.interfaces.SolicitarNegocio;

/**
 *
 * @author Alan
 */
@Named("solicitarController")
@RequestScoped
public class SolicitarController implements Serializable {

    @EJB
    private SolicitarNegocio solicitarEjb;

    @Inject
    private ControlAutorizacion ca;

    private Solicitar solicitar;

    public SolicitarController() {
        solicitar = new Solicitar();
    }

    public List<Solicitar> listaMaterialesSolicitar() {
        return solicitarEjb.listaMaterialesSolicitar();
    }

    public String solicitarMaterial() {
        Date date = new Date();
        Timestamp fecha = new Timestamp(date.getTime());
        solicitar.setFecha(fecha);
        solicitar.setProfesional(ca.getProfesional());

        solicitarEjb.solicitarMaterial(solicitar);
        //puedo usar la misma vista?, ver mas tarde
        return "enviadoCorrectamente.xhtml";
    }

    public Solicitar getSolicitar() {
        return solicitar;
    }

    public void setSolicitar(Solicitar solicitar) {
        this.solicitar = solicitar;
    }
}
