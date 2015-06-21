package tarea1.entidades;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import tarea1.Rol;

@Entity
@NamedQueries({
    @NamedQuery(name="todosUsuario", query="SELECT u FROM Usuario u")
})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="nombre_usuario")
    private String nombre;
    @Column(nullable=false)
    private String password;
    @Column(nullable=false)
    private Date fecha_alta;
    @Column(nullable=false)
    private Boolean estado;
    @Column(nullable=false)
    @Enumerated(EnumType.STRING)
    private Rol rol;
    private String email;
    @OneToOne(mappedBy="usuario")
    private Paciente paciente;
    @OneToOne(mappedBy="usuario")
    private Profesional profesional;
    
    
    // Getters
    
    public String getNombre() {
        return nombre;
    }
    
    public String getPassword() {
        return password;
    }


    public Date getFecha_alta() {
        return fecha_alta;
    }

    public Boolean isEstado() {
        return estado;
    }

    public String getEmail() {
        return email;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Profesional getProfesional() {
        return profesional;
    }

    public Rol getRol() {
        return rol;
    }
    
    
    // Setters
    
    public void setNombre(String id) {
        this.nombre = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public void setFecha_alta(Date fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public void setProfesional(Profesional profesional) {
        this.profesional = profesional;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
    // Other

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nombre != null ? nombre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((nombre == null && other.nombre != null) || (nombre != null && !nombre.equals(other.nombre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tarea0.Usuario[ id=" + nombre + " ]";
    }
    
}
