package in.co.nmsworks.exam.question4;

import java.util.*;
import java.sql.*;

public class Main {

    private static final String Url = "jdbc:mysql://localhost:3306/exam2026";
    private static final String User = "nms-training";
    private static final String Password = "";

    public static void main(String[] args) {

        validateUser("tantyukhinrr", "dC1?BvIZz<&#Lh");
        List<UserDetails> list = new ArrayList<>();
        Set<String> activeFemaleName = getActiveFemaleName();
        System.out.println(activeFemaleName);
    }

    private static void validateUser(String username, String password) {
        String query = "SELECT password FROM user_details WHERE username = ?";

        try (Connection conn = DriverManager.getConnection(Url, User, Password);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, username);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next())
                {
                    String dbPassword = rs.getString("password");

                    if (dbPassword.equals(password))
                    {
                        System.out.println("Password Valid");
                    }
                    else
                    {
                        System.out.println("Invalid Password");
                    }
                }
                else
                {
                    System.out.println("Invalid Username");
                }
            }
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        }
    }

    private static Set<String> getActiveFemaleName() {

        Set<String> activeFemaleNames = new HashSet<>();

        String query = "SELECT username FROM user_details WHERE gender = ? AND account_status = ?";

        try (Connection conn = DriverManager.getConnection(Url, User, Password);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, "Female");
            stmt.setString(2, "Active");

            try (ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    activeFemaleNames.add(rs.getString("username"));
                }
            }

        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        }

        return activeFemaleNames;
    }
}

