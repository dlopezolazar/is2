package py.una.pol.gestprois2.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import py.una.pol.gestprois2.entities.Backlog;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-12T13:39:36")
@StaticMetamodel(Requerimiento.class)
public class Requerimiento_ { 

    public static volatile SingularAttribute<Requerimiento, String> descripcion;
    public static volatile SingularAttribute<Requerimiento, Integer> idRequerimiento;
    public static volatile SingularAttribute<Requerimiento, Backlog> idBacklog;

}