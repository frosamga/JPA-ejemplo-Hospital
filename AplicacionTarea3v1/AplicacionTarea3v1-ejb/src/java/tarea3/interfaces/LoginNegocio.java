package tarea3.interfaces;

import java.util.List;
import javax.ejb.Local;
import tarea1.entidades.CentroMedico;
import tarea1.entidades.Departamento;
import tarea1.entidades.Usuario;

@Local
public interface LoginNegocio {
    public static enum ErrorLogin{
        NO_ERROR,
        USUARIO_REPETIDO,
        USUARIO_INEXISTENTE,
        PASS_INVALIDO,
        USUARIO_INACTIVO
    }
    
    public ErrorLogin registrar(Usuario u);
    public ErrorLogin compruebaLogin(Usuario usuario);
    public void crearUsuario();
    public Usuario buscarUsuario(Usuario u);
    public List<Usuario> asignarMedico(CentroMedico centro);
    public List<CentroMedico> listaCentros();
    public List<Departamento> listaDepartamentos();
}
