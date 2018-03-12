package py.una.pol.gestprois2.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import py.una.pol.gestprois2.entities.Proyecto;
import py.una.pol.gestprois2.entities.Story;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-12T13:39:36")
@StaticMetamodel(Sprint.class)
public class Sprint_ { 

    public static volatile SingularAttribute<Sprint, Integer> sprintId;
    public static volatile SingularAttribute<Sprint, Proyecto> idProyecto;
    public static volatile SingularAttribute<Sprint, Date> fechaInicio;
    public static volatile SingularAttribute<Sprint, String> sprintDescription;
    public static volatile ListAttribute<Sprint, Story> storyList;
    public static volatile SingularAttribute<Sprint, String> fechaFin;

}