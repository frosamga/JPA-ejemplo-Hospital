package tarea1.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import tarea1.Direccion;
import tarea1.TipoCentro;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-05-17T22:24:23")
@StaticMetamodel(CentroMedico.class)
public class CentroMedico_ { 

    public static volatile SingularAttribute<CentroMedico, Long> codigo;
    public static volatile SingularAttribute<CentroMedico, String> nombre;
    public static volatile SingularAttribute<CentroMedico, Direccion> direccion;
    public static volatile SingularAttribute<CentroMedico, TipoCentro> tipo;
    public static volatile SingularAttribute<CentroMedico, String> telefono;

}