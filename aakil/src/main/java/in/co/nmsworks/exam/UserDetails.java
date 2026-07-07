package in.co.nmsworks.exam;

public class UserDetails {
    private String empId;
    private String name;
    private String username;
    private String gender;
    private String password;
    private Status accStatus;

    public UserDetails() {
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Status getAccStatus() {
        return accStatus;
    }

    public void setAccStatus(Status accStatus) {
        this.accStatus = accStatus;
    }
}
