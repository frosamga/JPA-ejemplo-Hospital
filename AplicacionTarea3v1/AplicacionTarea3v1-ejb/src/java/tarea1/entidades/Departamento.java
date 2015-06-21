package tarea1.entidades;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
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
    @NamedQuery(name="todosDepartamento", query="SELECT d FROM Departamento d")
})
public class Departamento implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_departamento")
    private Long id;
    
    @Column(name = "nombre_departamento", nullable = false)
    private String nombre;
    
    @ManyToOne
    @JoinColumn(name="centro_fk", nullable=false)
    private CentroMedico centro;
    
    @Column(name="telefono_departamento",nullable = false)
    private String telefono;
    
    @OneToMany (mappedBy="departamento")
    private List <Profesional> profesional;
    @OneToOne
    @JoinColumn(name="jefe_fk")
    private Profesional jefeDepartamento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CentroMedico getCentro() {
        return centro;
    }

    public void setCentro(CentroMedico centro) {
        this.centro = centro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Profesional> getProfesional() {
        return profesional;
    }

    public void setProfesional(List<Profesional> profesional) {
        this.profesional = profesional;
    }

    public Profesional getJefeDepartamento() {
        return jefeDepartamento;
    }

    public void setJefeDepartamento(Profesional jefeDepartamento) {
        this.jefeDepartamento = jefeDepartamento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Departamento other = (Departamento) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
}
