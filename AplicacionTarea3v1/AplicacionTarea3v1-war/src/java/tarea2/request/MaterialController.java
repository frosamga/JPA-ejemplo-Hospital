package tarea2.request;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import tarea1.entidades.Material;
import tarea2.session.ControlAutorizacion;
import tarea3.interfaces.materialNegocio;

/**
 *
 * @author Alan
 */
@Named("materialController")
@RequestScoped
public class MaterialController implements Serializable {

    @EJB
    private materialNegocio materialEjb;

    @Inject
    private ControlAutorizacion ca;

    private Material material;

    public MaterialController() {
        material = new Material();
    }

    public List<Material> listaMateriales() {
        return materialEjb.listaMateriales();
    }

    public String agregarMaterial() {
        //material.setId(null);
        materialEjb.agregarMaterial(material);
        //puedo usar la misma vista, ver mas tarde
        return "enviadoCorrectamente.xhtml";
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }
}
