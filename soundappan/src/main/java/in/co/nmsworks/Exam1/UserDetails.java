package in.co.nmsworks.Exam1;

import java.util.Objects;

public class UserDetails {
    @Override
    public String toString() {
        return "UserDetails{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", active='" + active + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserDetails that = (UserDetails) o;
        return Objects.equals(name, that.name) && Objects.equals(gender, that.gender) && Objects.equals(active, that.active);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gender, active);
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

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public UserDetails(String name, String gender, String active) {
        this.name = name;
        this.gender = gender;
        this.active = active;
    }

    private String name;
    private String gender;
    private String active;


}
