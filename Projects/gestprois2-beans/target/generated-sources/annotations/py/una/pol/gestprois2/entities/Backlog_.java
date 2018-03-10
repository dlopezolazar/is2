package py.una.pol.gestprois2.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import py.una.pol.gestprois2.entities.Proyecto;
import py.una.pol.gestprois2.entities.Requerimiento;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-10T12:12:06")
@StaticMetamodel(Backlog.class)
public class Backlog_ { 

    public static volatile SingularAttribute<Backlog, String> descripcion;
    public static volatile SingularAttribute<Backlog, Proyecto> idProyecto;
    public static volatile ListAttribute<Backlog, Requerimiento> requerimientoList;
    public static volatile SingularAttribute<Backlog, String> idBacklog;

}