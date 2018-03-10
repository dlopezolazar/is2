package py.una.pol.gestprois2.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import py.una.pol.gestprois2.entities.UsuarioRol;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-10T12:12:06")
@StaticMetamodel(Rol.class)
public class Rol_ { 

    public static volatile SingularAttribute<Rol, Integer> idRol;
    public static volatile SingularAttribute<Rol, String> rolDescripcion;
    public static volatile ListAttribute<Rol, UsuarioRol> usuarioRolList;

}