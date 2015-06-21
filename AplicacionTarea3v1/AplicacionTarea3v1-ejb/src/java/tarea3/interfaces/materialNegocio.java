


package tarea3.interfaces;

import java.util.List;
import tarea1.entidades.Material;

/**
 *
 * @author Alan
 */

public interface materialNegocio{
    
    public List<Material> listaMateriales();
    
    public void agregarMaterial(Material m);
}
