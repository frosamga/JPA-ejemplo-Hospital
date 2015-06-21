package tarea1.entidades;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@NamedQueries({
    @NamedQuery(name="todosPacientes", query="SELECT p FROM Paciente p")
})
public class Paciente implements Serializable {
    private static final long serialVersionUID = 1L;
        
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String numero_ss;
    
    @OneToOne
    @JoinColumn(name="usuario_fk", nullable=false)
    private Usuario usuario;
    
    @OneToOne
    @JoinColumn(name="datos_personales_fk", nullable=false)
    private DatosPersonales datosPersonales;
    
    @OneToMany(mappedBy="paciente")
    private List<Ocupa> ocupacion;
    
    @OneToMany(mappedBy="paciente")
    private List<HistoriaClinica> historialMedico;
   
    @ManyToOne
    @JoinColumn(name="profesional_asignado_fk", nullable=false)
    private Profesional medicoAsignado;
    
    @ManyToOne
    @JoinColumn(name="centro_asignado_fk", nullable=false)
    private CentroMedico centroAsignado;
    
    @OneToMany(mappedBy="paciente")
    private List<Notificacion> notificaciones;
    
    // Getters
    
    public String getNumero_ss() {
        return numero_ss;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public DatosPersonales getDatosPersonales() {
        return datosPersonales;
    }

    public List<Ocupa> getOcupacion() {
        return ocupacion;
    }

    public List<HistoriaClinica> getHistorialMedico() {
        return historialMedico;
    }

    public Profesional getMedicoAsignado() {
        return medicoAsignado;
    }

    public CentroMedico getCentroAsignado() {
        return centroAsignado;
    }

    public List<Notificacion> getNotificaciones() {
        return notificaciones;
    }

    // Setters
    
    public void setNumero_ss(String numero_ss) {
        this.numero_ss = numero_ss;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setDatosPersonales(DatosPersonales datosPersonales) {
        this.datosPersonales = datosPersonales;
    }

    public void setOcupacion(List<Ocupa> ocupacion) {
        this.ocupacion = ocupacion;
    }

    public void setHistorialMedico(List<HistoriaClinica> historialMedico) {
        this.historialMedico = historialMedico;
    }

    public void setMedicoAsignado(Profesional medicoAsignado) {
        this.medicoAsignado = medicoAsignado;
    }

    public void setCentroAsignado(CentroMedico centroAsignado) {
        this.centroAsignado = centroAsignado;
    }

    public void setNotificaciones(List<Notificacion> notificaciones) {
        this.notificaciones = notificaciones;
    }
    
    // Other
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.numero_ss);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Paciente other = (Paciente) obj;
        if (!Objects.equals(this.numero_ss, other.numero_ss)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Paciente{" + "numero_ss=" + numero_ss + ", usuario=" + usuario + ", datosPersonales=" + datosPersonales + ", ocupacion=" + ocupacion + ", historialMedico=" + historialMedico + ", medicoAsignado=" + medicoAsignado + ", centroAsignado=" + centroAsignado + ", notificaciones=" + notificaciones + '}';
    }
    
}
