package pol.una.py.gestprois2_frontend.model;

public class RolModel {
    private Integer idRol;
    private String rolDescription;

    public RolModel() {
    }

    public RolModel(Integer idRol, String rolDescription) {
        this.idRol = idRol;
        this.rolDescription = rolDescription;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getRolDescription() {
        return rolDescription;
    }

    public void setRolDescription(String rolDescription) {
        this.rolDescription = rolDescription;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("RolModel{");
        sb.append("idRol=").append(idRol);
        sb.append(", rolDescription='").append(rolDescription).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
