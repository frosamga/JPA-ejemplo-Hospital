package tarea3.interfaces;

import javax.ejb.Local;
import tarea1.entidades.DatosPersonales;
import tarea1.entidades.Usuario;

@Local
public interface DatosPersonalesNegocio {
    public enum ErrorDP{
        NO_ERROR,
        CALLE_VACIA,
        PROVINCIA_VACIA,
        CP_VACIO,
        CIUDAD_VACIA,
        EMAIL_INCORRECTO
    };
    
    public ErrorDP modificarDatosPersonales(DatosPersonales dp);
    public ErrorDP modificarEmail(Usuario u);
    public Usuario buscarUsuario(Usuario u);
    public DatosPersonales buscarDatosPersonales(DatosPersonales dp);
}
