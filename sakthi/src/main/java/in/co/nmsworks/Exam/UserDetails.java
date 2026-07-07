package in.co.nmsworks.Exam;

class UserDetails {
    private String username;
    private String gender;
    private String status;

    public UserDetails(String username, String gender, String status) {
        this.username = username;
        this.gender = gender;
        this.status = status;
    }

    public String getUsername() {
        return username;
    }
    public String getGender() {
        return gender;
    }
    public String getStatus() {
        return status;
    }
}
