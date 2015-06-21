/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea1.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import tarea1.Direccion;
import tarea1.TipoCentro;

@Entity
@NamedQueries({
    @NamedQuery(name="todosCentros", query="SELECT c FROM CentroMedico c")
})
public class CentroMedico implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="id_centro")
    private Long codigo;
    @Column(name="nombre_centro",nullable=false)
    private String nombre;
    @Enumerated(EnumType.STRING)
    @Column(name="tipo_centro",nullable=false)
    private TipoCentro tipo;
    @Embedded
    private Direccion direccion;
    @Column (name="telefono_centro",nullable=false)
    private String telefono;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoCentro getTipo() {
        return tipo;
    }

    public void setTipo(TipoCentro tipo) {
        this.tipo = tipo;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

   

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CentroMedico)) {
            return false;
        }
        CentroMedico other = (CentroMedico) object;
        if ((codigo == null && other.codigo != null) || (codigo != null && !codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Centro Medico[ id=" + codigo + " ]";
    }
    
}
