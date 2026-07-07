package in.co.nmsworks.exam;

public class UserDetails {
    private String employeeId;
    private String name;
    private String gender;
    private String username;
    private String password;
    private String accountStatus;

    public UserDetails() {
    }

    public UserDetails(String employeeId, String name, String gender, String username, String password, String accountStatus) {
        this.employeeId = employeeId;
        this.name = name;
        this.gender = gender;
        this.username = username;
        this.password = password;
        this.accountStatus = accountStatus;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
                "employeeId='" + employeeId + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", accountStatus='" + accountStatus + '\'' +
                '}';
    }
}
