package Bean;

public class Users {
    private Integer id;
    private String u_name;
    private String password;
    private Integer gender;
    private String email;
    private String role;

    public Users(Integer id, String username, String password, Integer gender, String email, String role) {
        this.id = id;
        this.u_name = username;
        this.password = password;
        this.gender = gender;
        this.email = email;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return u_name;
    }

    public void setUsername(String username) {
        this.u_name = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + u_name + '\'' +
                ", password='" + password + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}

