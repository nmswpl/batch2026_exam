package in.co.nmsworks.Exam1;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Login {
    public static void main(String[] args) {
        Login log = new Login();
        log.fetchData();
        List<UserDetails> female = splitActiveFemale();
        Set<UserDetails> activeFemale = splitActiveFemaleSet(female);
        printDetails(activeFemale);

    }

    private static void printDetails(Set<UserDetails> activeFemale) {
        System.out.println(activeFemale);
    }

    private static Set<UserDetails> splitActiveFemaleSet(List<UserDetails> female) {
        Set<UserDetails> set = new HashSet<>();
        for (UserDetails u : female) {
            if (u.getGender().equals("female") && u.getActive().equals("Active")) {
                set.add(new UserDetails(u.getName(), u.getGender(), u.getActive()));
            }
        }
        return set;
    }

    private static List<UserDetails> splitActiveFemale() {
        List<UserDetails> list = new ArrayList<>();
        String url = "jdbc:mysql://localhost:3306/exam2026";
        String name = "nms-training";
        String pass = "";
        String query = "select * from user_details";
        String insertQuery = "insert into user_detail values(?,?,?)";
        try (Connection con = DriverManager.getConnection(url, name, pass);
             PreparedStatement pr = con.prepareStatement(query);) {
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                String gender = rs.getString(3);
                String username = rs.getString(4);
                String accountStatus = rs.getString(6);
                list.add(new UserDetails(username, gender, accountStatus));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    private void fetchData() {
        String url = "jdbc:mysql://localhost:3306/exam2026";
        String name = "nms-training";
        String pass = "";
        String query = "select * from user_details";
        String insertQuery = "insert into user_detail values(?,?,?)";
        try (Connection con = DriverManager.getConnection(url, name, pass);
             PreparedStatement pr = con.prepareStatement(query);
             PreparedStatement pw = con.prepareStatement(insertQuery)) {
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                String username = rs.getString(4);
                String password = rs.getString(5);
                if (username.equals("john24") && password.equals("93a5fe6210bfcdb573ccd348e19e6a56")) {
                    pw.setString(1, username);
                    pw.setString(2, password);
                    pw.setString(3, "Valid");
                    pw.executeUpdate();
                } else {
                    pw.setString(1, username);
                    pw.setString(2, password);
                    pw.setString(3, "Invalid");
                    pw.executeUpdate();
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
