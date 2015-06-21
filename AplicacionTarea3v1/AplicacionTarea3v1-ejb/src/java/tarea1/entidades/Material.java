package tarea1.entidades;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
    @NamedQuery(name="todosMateriales", query="SELECT b FROM Material b")
})
public class Material implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_material")
    private String id;
    
    @Column(name="nombre_material",nullable = false)
    private String nombre;
    
    @Column(name="descripcion_material")
    private String descripcion;
    
    @OneToMany(mappedBy = "material")
    private Set<Solicitar> solicitar;
   
    @OneToMany(mappedBy = "material")
    private Set<Stock> stock;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<Solicitar> getSolicitar() {
        return solicitar;
    }

    public void setSolicitar(Set<Solicitar> solicitar) {
        this.solicitar = solicitar;
    }

    public Set<Stock> getStock() {
        return stock;
    }

    public void setStock(Set<Stock> stock) {
        this.stock = stock;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.id);
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
        final Material other = (Material) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
