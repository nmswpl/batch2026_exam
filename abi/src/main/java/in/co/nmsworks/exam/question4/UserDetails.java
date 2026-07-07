package in.co.nmsworks.exam.question4;

class UserDetails {
    private String username;
    private String password;
    private String gender;
    private boolean active;

    public UserDetails(String username, String password, String gender, boolean active) {
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.active = active;
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getGender() { return gender; }
    public boolean isActive() { return active; }
}

