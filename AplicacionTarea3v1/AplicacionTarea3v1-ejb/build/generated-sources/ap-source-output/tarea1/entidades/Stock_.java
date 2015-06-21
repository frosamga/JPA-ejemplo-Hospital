package tarea1.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import tarea1.entidades.CentroMedico;
import tarea1.entidades.Material;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-05-17T22:24:23")
@StaticMetamodel(Stock.class)
public class Stock_ { 

    public static volatile SingularAttribute<Stock, Long> id;
    public static volatile SingularAttribute<Stock, Integer> cantidad;
    public static volatile SingularAttribute<Stock, CentroMedico> centro;
    public static volatile SingularAttribute<Stock, Material> material;

}