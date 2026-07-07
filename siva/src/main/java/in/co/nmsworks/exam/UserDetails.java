package in.co.nmsworks.exam;

public class UserDetails {
    private String id;
    private String name;
    private Gender gender;
    private String username;
    private String password;
    private AccountStatus accountStatus;

    public UserDetails() {
    }

    public UserDetails(String id, String name, Gender gender, String username, String password, AccountStatus accountStatus) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.username = username;
        this.password = password;
        this.accountStatus = accountStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
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

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", accountStatus=" + accountStatus +
                '}';
    }
}
