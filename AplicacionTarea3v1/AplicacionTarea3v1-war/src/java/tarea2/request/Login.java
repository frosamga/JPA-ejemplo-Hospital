package tarea2.request;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import tarea1.entidades.Usuario;
import tarea2.session.ControlAutorizacion;
import tarea3.interfaces.LoginNegocio;
import tarea3.interfaces.LoginNegocio.ErrorLogin;


@Named(value = "login")
@RequestScoped
public class Login {

    @EJB
    private LoginNegocio loginEjb;
    
    @Inject
    private ControlAutorizacion ca;
    
    private Usuario usuario;

    public Login() {
        usuario = new Usuario();
    }

    public String autenticar() {
        loginEjb.crearUsuario();
        ErrorLogin e = loginEjb.compruebaLogin(usuario);
        usuario = loginEjb.buscarUsuario(usuario);
        FacesMessage fm;
        String error = "";
        
        switch(e){
            case NO_ERROR:
                ca.setUsuario(usuario);
                return ca.home();
            case USUARIO_INEXISTENTE:
                error += "La cuenta no existe";
                break;
            case PASS_INVALIDO:
                error += "La contraseña no es correcta";
                break;
            case USUARIO_INACTIVO:
                error += "La cuenta está inactiva";
                break;
        }
        
        fm = new FacesMessage(error); 
        FacesContext.getCurrentInstance().addMessage(null,fm);
        
        return null;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
}

