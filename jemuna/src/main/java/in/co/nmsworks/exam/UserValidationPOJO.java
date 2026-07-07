package in.co.nmsworks.exam;

public class UserValidationPOJO {
    String name ;
    String password;

    public UserValidationPOJO(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public UserValidationPOJO() {
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
