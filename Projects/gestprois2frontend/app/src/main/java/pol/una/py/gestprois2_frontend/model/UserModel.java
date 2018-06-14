package pol.una.py.gestprois2_frontend.model;

/**
 * Created by Diego on 13/05/2018.
 */

public class UserModel {

    private Integer userId;
    private String email;
    private String fullName;

    public UserModel() {
    }

    public UserModel(Integer userId, String email, String fullName) {
        this.userId = userId;
        this.email = email;
        this.fullName = fullName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
        final StringBuffer sb = new StringBuffer("UserModel{");
        sb.append("userId=").append(userId);
        sb.append(", email='").append(email).append('\'');
        sb.append(", fullName='").append(fullName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
