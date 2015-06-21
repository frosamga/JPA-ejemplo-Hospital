package tarea3.interfaces;

import java.util.List;
import tarea1.entidades.Buzon;


public interface BuzonNegocio {
    
    public List<Buzon> listaBuzones();
    
    public void agregarBuzon(Buzon b);
}
