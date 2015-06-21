package tarea1.entidades;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import tarea1.TipoMensaje;

@Entity
@NamedQueries({
    @NamedQuery(name="todosBuzones", query="SELECT b FROM Buzon b")
})
public class Buzon implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="id_buzon")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(nullable=false)
    @Enumerated(EnumType.STRING)
    private TipoMensaje tipo_mensaje;
    
    @Column(nullable=false)
    private String texto_mensaje;
    
    @Column(nullable=false)
    private Timestamp fecha;
    
    @ManyToOne
    @JoinColumn(name="usuario_fk", nullable=false)
    private Usuario emisor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoMensaje getTipo_mensaje() {
        return tipo_mensaje;
    }

    public void setTipo_mensaje(TipoMensaje tipo_mensaje) {
        this.tipo_mensaje = tipo_mensaje;
    }

    public String getTexto_mensaje() {
        return texto_mensaje;
    }

    public void setTexto_mensaje(String texto_mensaje) {
        this.texto_mensaje = texto_mensaje;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public Usuario getEmisor() {
        return emisor;
    }

    public void setEmisor(Usuario emisor) {
        this.emisor = emisor;
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
        final Buzon other = (Buzon) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    } 
    
}
