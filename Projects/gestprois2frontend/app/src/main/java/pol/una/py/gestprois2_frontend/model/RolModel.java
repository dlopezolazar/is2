package pol.una.py.gestprois2_frontend.model;

public class RolModel {
    private Integer id_rol;
    private String rol_descripcion;

    public RolModel() {
    }

    public RolModel(Integer Id_rol, String rol_descripcion) {
        this.id_rol = id_rol;
        this.rol_descripcion = rol_descripcion;
    }

    public Integer getId_rol() {
        return id_rol;
    }

    public void setId_rol(Integer id_rol) {
        this.id_rol = id_rol;
    }

    public String getRol_Descripcion() {
        return rol_descripcion;
    }

    public void setRol_descripcion(String rol_descripcion) {
        this.rol_descripcion = rol_descripcion;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("UserModel{");
        sb.append("id_rol=").append(id_rol);
        sb.append('}');
        return sb.toString();
    }
}
