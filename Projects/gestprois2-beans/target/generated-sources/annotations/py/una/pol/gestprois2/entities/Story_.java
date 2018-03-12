package py.una.pol.gestprois2.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import py.una.pol.gestprois2.entities.Sprint;
import py.una.pol.gestprois2.entities.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-12T13:39:36")
@StaticMetamodel(Story.class)
public class Story_ { 

    public static volatile SingularAttribute<Story, Sprint> sprintId;
    public static volatile SingularAttribute<Story, String> estado;
    public static volatile SingularAttribute<Story, Integer> idTarea;
    public static volatile SingularAttribute<Story, Usuario> idUsuario;

}