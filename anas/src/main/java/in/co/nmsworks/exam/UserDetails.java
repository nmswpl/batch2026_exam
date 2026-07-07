package in.co.nmsworks.exam;

public class UserDetails {
    String empId;
    String name;
    String gender;
    String userName;
    String password;
    String status;

    public UserDetails(String empId, String name, String gender, String userName, String password, String status) {
        this.empId = empId;
        this.name = name;
        this.gender = gender;
        this.userName = userName;
        this.password = password;
        this.status = status;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
