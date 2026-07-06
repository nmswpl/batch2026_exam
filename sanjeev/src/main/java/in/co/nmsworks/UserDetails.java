package in.co.nmsworks;

public class UserDetails
{
    public UserDetails() {

    }

    public String getEmp_id() {
        return emp_id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getAccount_status() {
        return account_status;
    }

    String emp_id;
    String name;
    String gender;
    String username;
    String password;
    String account_status;

    public UserDetails(String emp_id, String name, String gender, String username, String password, String account_status) {
        this.emp_id = emp_id;
        this.name = name;
        this.gender = gender;
        this.username = username;
        this.password = password;
        this.account_status = account_status;
    }

}
