package in.co.nmsworks.exam;

import java.util.Objects;

public class UserDetail {
    private String empid;
    private String name;
    private String gender;
    private String username;
    private String password;
    private String accountStatus;

    public UserDetail() {
    }

    public UserDetail(String empid, String name, String gender, String username, String password, String accountStatus) {
        this.empid = empid;
        this.name = name;
        this.gender = gender;
        this.username = username;
        this.password = password;
        this.accountStatus = accountStatus;
    }

    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
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
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserDetail that = (UserDetail) o;
        return Objects.equals(empid, that.empid) && Objects.equals(name, that.name) && Objects.equals(gender, that.gender) && Objects.equals(username, that.username) && Objects.equals(password, that.password) && Objects.equals(accountStatus, that.accountStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empid, name, gender, username, password, accountStatus);
    }

    @Override
    public String toString() {
        return "UserDetail{" +
                "empid='" + empid + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", accountStatus='" + accountStatus + '\'' +
                '}';
    }
}
