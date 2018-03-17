package py.una.pol.gestprois2.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import py.una.pol.gestprois2.entities.Backlog;
import py.una.pol.gestprois2.entities.Sprint;
import py.una.pol.gestprois2.entities.UsuarioRol;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-17T16:44:45")
@StaticMetamodel(Proyecto.class)
public class Proyecto_ { 

    public static volatile SingularAttribute<Proyecto, Integer> idProyecto;
    public static volatile ListAttribute<Proyecto, Backlog> backlogList;
    public static volatile SingularAttribute<Proyecto, Date> fechaInicio;
    public static volatile ListAttribute<Proyecto, Sprint> sprintList;
    public static volatile ListAttribute<Proyecto, UsuarioRol> usuarioRolList;
    public static volatile SingularAttribute<Proyecto, String> nombre;
    public static volatile SingularAttribute<Proyecto, Date> fechaFin;

}