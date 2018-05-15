package pol.una.py.gestprois2_frontend.model;

/**
 * Created by Diego on 13/05/2018.
 */

public class UserModel {

    private String email;
    private String fullName;

    public UserModel() {
    }

    public UserModel(String email, String nombreCopleto) {
        this.email = email;
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
