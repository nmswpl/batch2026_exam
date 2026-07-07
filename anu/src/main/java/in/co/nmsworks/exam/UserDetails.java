package in.co.nmsworks.exam;


class UserDetails {
    private String name;
    private String gender;
    private boolean active;

    public UserDetails(String name, String gender, boolean active) {
        this.name = name;
        this.gender = gender;
        this.active = active;
    }

    public String getName() {
        return name;
    }
    public String getGender() {
        return gender;
    }
    public boolean isActive() {
        return active;
    }
}
