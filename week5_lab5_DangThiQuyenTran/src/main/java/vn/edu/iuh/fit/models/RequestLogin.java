package vn.edu.iuh.fit.models;

public class RequestLogin {
    private String type;
    private String email;
    private String phone;

    public RequestLogin(String type, String email, String phone) {
        this.type = type;
        this.email = email;
        this.phone = phone;
    }

    public RequestLogin() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
