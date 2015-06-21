package tarea3.negocio;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import tarea1.Direccion;
import tarea1.Rol;
import tarea1.TipoCentro;
import tarea1.entidades.Alerta;
import tarea1.entidades.CentroMedico;
import tarea1.entidades.DatosPersonales;
import tarea1.entidades.Departamento;
import tarea1.entidades.HistoriaClinica;
import tarea1.entidades.Notificacion;
import tarea1.entidades.Ocupa;
import tarea1.entidades.Paciente;
import tarea1.entidades.Profesional;
import tarea1.entidades.Usuario;
import tarea3.interfaces.LoginNegocio;

@Stateless
public class LoginEJB implements LoginNegocio{
    @PersistenceContext(unitName = "AplicacionTarea3")
    private EntityManager em;
    
    @Override
    public void crearUsuario() {
        
         CentroMedico centro = new CentroMedico();
        centro.setCodigo(1L);
        centro.setNombre("Carlos Haya");
        centro.setTelefono("93487547");
        centro.setTipo(TipoCentro.HOSPITAL);
         {
            Direccion d=new Direccion();
            d.setCalle("Avenida Carlos Haya");
            d.setCiudad("Malaga");
            d.setProvincia("Malaga");
            d.setCodigoPostal("29010");
            centro.setDireccion(d);
        }
        
        
        Usuario us_sanitario=new Usuario();
        Usuario us_administrativo=new Usuario();
        Usuario us_paciente=new Usuario();
    
        us_sanitario.setNombre("sanitario");
        us_sanitario.setPassword("sanitario");
        us_sanitario.setRol(Rol.SANITARIO);
        us_sanitario.setEstado(true);
        us_sanitario.setEmail("sanitario");
        us_sanitario.setFecha_alta(new Date(1));
        us_sanitario.setEmail("cancrejo@mail.com");

        us_paciente.setNombre("paciente");
        us_paciente.setPassword("paciente");
        us_paciente.setRol(Rol.PACIENTE);
        us_paciente.setEstado(true);
        us_paciente.setEmail("paciente");
        us_paciente.setFecha_alta(new Date(1));
        us_paciente.setEmail("adrian@mail.com");

        
        us_administrativo.setNombre("administrativo");
        us_administrativo.setPassword("administrativo");
        us_administrativo.setRol(Rol.ADMINISTRATIVO);
        us_administrativo.setEstado(true);
        us_administrativo.setEmail("administrativo");
        us_administrativo.setFecha_alta(new Date(1));
        us_administrativo.setEmail("kernel@mail.com");
   
        
        DatosPersonales dp_adrian = new DatosPersonales();
        dp_adrian.setDni("44665396");
        dp_adrian.setNombre("Adrian");
        dp_adrian.setApellido1("Gomez");
        dp_adrian.setApellido2("Jorge");
        dp_adrian.setFechaNacimiento(new Date(1));
        {
            Direccion d=new Direccion();
            d.setCalle("Av/ Pr. del Candado");
            d.setCiudad("Malaga");
            d.setProvincia("Malaga");
            d.setCodigoPostal("29018");
            dp_adrian.setDireccion(d);
        }
        
        DatosPersonales dp_zoiber = new DatosPersonales();
        dp_zoiber.setDni("77788866");
        dp_zoiber.setNombre("Zoiber");
        dp_zoiber.setApellido1("Crustaceo");
        dp_zoiber.setApellido2("Pauperrimo");
        dp_zoiber.setFechaNacimiento(new Date(1));
        {
            Direccion d=new Direccion();
            d.setCalle("Mar");
            d.setCiudad("Malaga");
            d.setProvincia("Malaga");
            d.setCodigoPostal("29018");
            dp_zoiber.setDireccion(d);
        }
        
        DatosPersonales dp_root = new DatosPersonales();
        dp_root.setDni("77788866");
        dp_root.setNombre("Root");
        dp_root.setApellido1("Linux");
        dp_root.setApellido2("Ubuntu");
        dp_root.setFechaNacimiento(new Date(1));
        {
            Direccion d=new Direccion();
            d.setCalle("Kernel");
            d.setCiudad("Malaga");
            d.setProvincia("Malaga");
            d.setCodigoPostal("29018");
            dp_root.setDireccion(d);
        }
        
        
        Departamento de0 = new Departamento();
        de0.setCentro(centro);
        de0.setNombre("Medico Cabecera");
        List<Profesional> listaP = new ArrayList();
        de0.setProfesional(listaP);
        de0.setTelefono("948478457");
        
        Profesional pr_zoiber = new Profesional();
        pr_zoiber.setId("Md-0001");
        pr_zoiber.setDatosPersonales(dp_zoiber);
        pr_zoiber.setDepartamento(de0);
        pr_zoiber.setFechaComienzo(new Date(1));
        {
            List<Alerta> l=new ArrayList();
            pr_zoiber.setAlerta(l);
        }
        us_sanitario.setProfesional(pr_zoiber);
        pr_zoiber.setUsuario(us_sanitario);
        
        
        
        Paciente pa_adrian = new Paciente();
        pa_adrian.setNumero_ss("65498465469984796854");
        pa_adrian.setDatosPersonales(dp_adrian);
        pa_adrian.setCentroAsignado(centro);
        pa_adrian.setMedicoAsignado(pr_zoiber);
        {
            List<HistoriaClinica> l=new ArrayList();
            pa_adrian.setHistorialMedico(l);
        }{
            List<Ocupa> l=new ArrayList();
            pa_adrian.setOcupacion(l);
        }{
            List<Notificacion> l=new ArrayList();
            pa_adrian.setNotificaciones(l);
        }
        us_paciente.setPaciente(pa_adrian);
        pa_adrian.setUsuario(us_paciente);
        
       
        
        
        Profesional pr_root = new Profesional();
        pr_root.setId("Ad-0008");
        pr_root.setDatosPersonales(dp_root);
        pr_root.setDepartamento(de0);
        pr_root.setFechaComienzo(new Date(1));
        us_administrativo.setProfesional(pr_root);
        pr_root.setUsuario(us_administrativo);
        
        em.merge(centro);
        em.merge(de0);
        
        
        em.merge(dp_root);        
        em.merge(pr_root);
        
        em.merge(dp_zoiber);
        em.merge(pr_zoiber);
        
        em.merge(dp_adrian);
        em.merge(pa_adrian);
        
        em.merge(us_sanitario);
        em.merge(us_administrativo);
        em.merge(us_paciente);
    }
    
    @Override
    public Usuario buscarUsuario(Usuario u){
        return em.find(Usuario.class,u.getNombre());
    }
    
    @Override
    public ErrorLogin registrar(Usuario u){
        Usuario user = buscarUsuario(u);
        if(user!=null){
            return ErrorLogin.USUARIO_REPETIDO;
        }
        em.merge(u);
        return ErrorLogin.NO_ERROR;
    }
    
    @Override
    public ErrorLogin compruebaLogin(Usuario usuario){
        
        Usuario user = buscarUsuario(usuario);
        
        if(user==null){
            return ErrorLogin.USUARIO_INEXISTENTE;
        }
        if(!user.isEstado()){
            return ErrorLogin.USUARIO_INACTIVO;
        }
        if(!user.getPassword().equals(usuario.getPassword())){
            return ErrorLogin.PASS_INVALIDO;
        }
        return ErrorLogin.NO_ERROR;
    }
    
    @Override
    public List<Usuario> asignarMedico(CentroMedico centro){
        TypedQuery<Usuario> profesional = em.createNamedQuery("todosUsuario",Usuario.class);
        List<Usuario> listaProfesionales =  profesional.getResultList();
        List<Usuario> candidatos = new ArrayList();
        for(Usuario user: listaProfesionales){
            if(user.getRol().equals(Rol.SANITARIO) && user.getProfesional().getDepartamento().getCentro().equals(centro)){
                candidatos.add(user);
            }
        }
        return candidatos;
    }
    
    @Override
    public List<CentroMedico> listaCentros(){
        TypedQuery<CentroMedico> centros = em.createNamedQuery("todosCentro",CentroMedico.class);
        return centros.getResultList();
    }
    
    @Override
    public List<Departamento> listaDepartamentos(){
        TypedQuery<Departamento> deartamentos = em.createNamedQuery("todosDepartamento",Departamento.class);
        return deartamentos.getResultList();
    }
}
