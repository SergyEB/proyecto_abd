package grupo05abd.modelo;

public class User {
    private int C_user;
    private String D_first_name;
    private String D_last_name;
    private String D_email;
    private String D_password;
    private int T_role;

    // Constructor vacío
    public User() {
    }

    // Constructor completo
    public User(int C_user, String D_first_name, String D_last_name, String D_email, String D_password, int T_role) {
        this.C_user = C_user;
        this.D_first_name = D_first_name;
        this.D_last_name = D_last_name;
        this.D_email = D_email;
        this.D_password = D_password;
        this.T_role = T_role;
    }

    // Getters y Setters
    public int getC_user() {
        return C_user;
    }

    public void setC_user(int C_user) {
        this.C_user = C_user;
    }

    public String getD_first_name() {
        return D_first_name;
    }

    public void setD_first_name(String D_first_name) {
        this.D_first_name = D_first_name;
    }

    public String getD_last_name() {
        return D_last_name;
    }

    public void setD_last_name(String D_last_name) {
        this.D_last_name = D_last_name;
    }

    public String getD_email() {
        return D_email;
    }

    public void setD_email(String D_email) {
        this.D_email = D_email;
    }

    public String getD_password() {
        return D_password;
    }

    public void setD_password(String D_password) {
        this.D_password = D_password;
    }

    public int getT_role() {
        return T_role;
    }

    public void setT_role(int T_role) {
        this.T_role = T_role;
    }
}