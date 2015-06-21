package tarea1.entidades;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
    @NamedQuery(name="todosSolicitar", query="SELECT s FROM Solicitar s")
})
public class Solicitar implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="num_solicitud")
    private Long id;
    
    @Column(name="fecha_solicitud",nullable=false)
    private Timestamp fecha;
    
    @Column(nullable=false)
    private Integer cantidad;
    
    @ManyToOne
    @JoinColumn(name="profesional_fk", nullable=false)
    private Profesional profesional;
    
    @ManyToOne
    @JoinColumn(name="material_fk", nullable=false)
    private Material material;
    
    // Getters
    
    public Long getId() {
        return id;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public Profesional getProfesional() {
        return profesional;
    }

    public Material getMaterial() {
        return material;
    }
    
    // Setters
    
    public void setId(Long id) {
        this.id = id;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public void setProfesional(Profesional profesional) {
        this.profesional = profesional;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }
    
    // Other
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Solicitar)) {
            return false;
        }
        Solicitar other = (Solicitar) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tarea1.entidades.Solicitar[ id=" + id + " ]";
    }
    
}
