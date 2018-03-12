package py.una.pol.gestprois2.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import py.una.pol.gestprois2.entities.Proyecto;
import py.una.pol.gestprois2.entities.Rol;
import py.una.pol.gestprois2.entities.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-12T13:39:36")
@StaticMetamodel(UsuarioRol.class)
public class UsuarioRol_ { 

    public static volatile SingularAttribute<UsuarioRol, Integer> idUsuarioRol;
    public static volatile SingularAttribute<UsuarioRol, Proyecto> idProyecto;
    public static volatile SingularAttribute<UsuarioRol, Rol> idRol;
    public static volatile SingularAttribute<UsuarioRol, Usuario> idUsuario;

}