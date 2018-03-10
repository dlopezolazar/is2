package py.una.pol.gestprois2.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import py.una.pol.gestprois2.entities.Story;
import py.una.pol.gestprois2.entities.UsuarioRol;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-10T12:12:06")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, Integer> idUsuario;
    public static volatile SingularAttribute<Usuario, String> correo;
    public static volatile ListAttribute<Usuario, UsuarioRol> usuarioRolList;
    public static volatile ListAttribute<Usuario, Story> storyList;
    public static volatile SingularAttribute<Usuario, String> nombre;

}