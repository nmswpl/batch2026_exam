package in.co.nmsworks.exam;

public class UserDetails {
    private String empId;
    private String name;
    private String gender;
    private String userName;
    private String password;
    private String accountStatus;

    public UserDetails(String empId, String name, String gender, String userName, String password, String accountStatus) {
        this.empId = empId;
        this.name = name;
        this.gender = gender;
        this.userName = userName;
        this.password = password;
        this.accountStatus = accountStatus;
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

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "empId='" + empId + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", accountStatus='" + accountStatus + '\'' +
                '}';
    }
}
