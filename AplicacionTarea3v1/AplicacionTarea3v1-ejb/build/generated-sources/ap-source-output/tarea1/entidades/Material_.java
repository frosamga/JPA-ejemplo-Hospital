package tarea1.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import tarea1.entidades.Solicitar;
import tarea1.entidades.Stock;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-05-17T22:24:23")
@StaticMetamodel(Material.class)
public class Material_ { 

    public static volatile SingularAttribute<Material, String> id;
    public static volatile SingularAttribute<Material, String> nombre;
    public static volatile SetAttribute<Material, Stock> stock;
    public static volatile SetAttribute<Material, Solicitar> solicitar;
    public static volatile SingularAttribute<Material, String> descripcion;

}