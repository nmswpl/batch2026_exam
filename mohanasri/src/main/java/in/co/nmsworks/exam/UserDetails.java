package in.co.nmsworks.exam;

public class UserDetails {

    private String empId;
    private String name;
    private String gender;
    private String username;
    private String password;
    private String accountStatus;

    public UserDetails(String empId, String name, String gender, String username, String password, String accountStatus) {
        this.empId = empId;
        this.name = name;
        this.gender = gender;
        this.username = username;
        this.password = password;
        this.accountStatus = accountStatus;
    }

    public String getEmpId() { return empId; }
    public String getName() { return name; }
    public String getGender() { return gender; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getAccountStatus() { return accountStatus; }
}

