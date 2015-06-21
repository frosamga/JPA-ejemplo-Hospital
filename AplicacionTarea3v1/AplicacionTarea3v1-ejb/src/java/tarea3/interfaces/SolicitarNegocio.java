package tarea3.interfaces;

import java.util.List;
import tarea1.entidades.Solicitar;

/**
 *
 * @author Alan
 */

public interface SolicitarNegocio{
    
    public List<Solicitar> listaMaterialesSolicitar();
    
    public void solicitarMaterial(Solicitar s);
}
