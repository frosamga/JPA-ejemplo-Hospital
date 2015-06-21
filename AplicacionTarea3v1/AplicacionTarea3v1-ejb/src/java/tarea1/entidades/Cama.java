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
import javax.persistence.OneToMany;

@Entity
public class Cama implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_cama")
    private Long id;
    
    @Column(nullable=false)
    private String num_cama;
    
    @Column(nullable=false)
    private boolean libre;
    
    @ManyToOne
    @JoinColumn(name="centro_fk", nullable=false)
    private CentroMedico centro;
    
    @OneToMany(mappedBy="cama")
    private List <Ocupa> ocupa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNum_cama() {
        return num_cama;
    }

    public void setNum_cama(String num_cama) {
        this.num_cama = num_cama;
    }

    public CentroMedico getCentro() {
        return centro;
    }

    public void setCentro(CentroMedico centro) {
        this.centro = centro;
    }

    public List<Ocupa> getOcupa() {
        return ocupa;
    }

    public void setOcupa(List<Ocupa> ocupa) {
        this.ocupa = ocupa;
    }

    public boolean isLibre() {
        return libre;
    }

    public void setLibre(boolean libre) {
        this.libre = libre;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.id);
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
        final Cama other = (Cama) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
}