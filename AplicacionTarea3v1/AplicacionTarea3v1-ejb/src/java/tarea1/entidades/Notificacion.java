package tarea1.entidades; 
  
import java.io.Serializable; 
import java.sql.Timestamp; 
import java.util.Objects;
import javax.persistence.Column;  
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id; 
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity 
public class Notificacion implements Serializable { 
    private static final long serialVersionUID = 1L; 
      
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_notificacion")
    private Long id ;
    
    @ManyToOne
    @JoinColumn(name="paciente_fk", nullable=false)
    private Paciente paciente;
    
    @Column(name="fecha_notificacion",nullable=false) 
    private Timestamp fecha;
    
    @Column(name="tipo_notificacion",nullable=false) 
    private String tipo;
    
    @Column(name="descripcion_notificacion",nullable = false) 
    private String descripcion; 
    
    @ManyToOne
    @JoinColumn(name="profesional_fk", nullable=false) 
    private Profesional profesional;
    
    @ManyToOne
    @JoinColumn(name="centro_fk", nullable=false) 
    private CentroMedico centroMedico; 

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Profesional getProfesional() {
        return profesional;
    }

    public void setProfesional(Profesional profesional) {
        this.profesional = profesional;
    }

    public CentroMedico getCentroMedico() {
        return centroMedico;
    }

    public void setCentroMedico(CentroMedico centroMedico) {
        this.centroMedico = centroMedico;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final Notificacion other = (Notificacion) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
      
}