package tarea1.entidades;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@NamedQueries({
    @NamedQuery(name="todosProfesionales", query="SELECT p FROM Profesional p")
})
public class Profesional implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_profesional")
    private String id;

    @Column(name = "telefono_profesional")
    private String telefono;

    @Column(name = "email_profesional")
    private String email;

    @Column(name = "fecha_comienzo", nullable = false)
    private Date fechaComienzo;

    @Column(name = "fecha_fin")
    private Date fechaFin;

    @OneToOne
    @JoinColumn(name="datos_personales_fk", nullable = false)
    private DatosPersonales datosPersonales;

    @OneToOne
    @JoinColumn(name="usuario_fk", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name="departamento_fk", nullable = false)
    private Departamento departamento;
    
    @OneToMany(mappedBy="profesional")
    private List<Alerta> alerta;
    
    @OneToMany(mappedBy="profesional")
    private List<Solicitar> solicitar;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaComienzo() {
        return fechaComienzo;
    }

    public void setFechaComienzo(Date fechaComienzo) {
        this.fechaComienzo = fechaComienzo;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public DatosPersonales getDatosPersonales() {
        return datosPersonales;
    }

    public void setDatosPersonales(DatosPersonales datosPersonales) {
        this.datosPersonales = datosPersonales;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<Alerta> getAlerta() {
        return alerta;
    }

    public void setAlerta(List<Alerta> alerta) {
        this.alerta = alerta;
    }

    public List<Solicitar> getSolicitar() {
        return solicitar;
    }

    public void setSolicitar(List<Solicitar> solicitar) {
        this.solicitar = solicitar;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
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
        final Profesional other = (Profesional) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
}
