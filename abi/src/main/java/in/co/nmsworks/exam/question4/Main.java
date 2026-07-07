package in.co.nmsworks.exam.question4;

import java.util.*;
import java.sql.*;

public class Main {

    private static final String Url = "jdbc:mysql://localhost:3306/exam2026";
    private static final String User = "nms-training";
    private static final String Password = "";

    public static void main(String[] args) {

        if (args.length >= 2) {
            String inputUser = args[0];
            String inputPass = args[1];
            validateUser(inputUser, inputPass);
        } else {
            validateUser("tantyukhinrr", "dC1?BvIZz<&#Lh");
        }
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

    private static Set<String> getActiveFemaleName(List<UserDetails> users) {
        Set<String> activeFemaleNames = new HashSet<>();
        if (users == null) {
            return activeFemaleNames;
        }

        for (UserDetails user : users) {
            if ("Female".equalsIgnoreCase(user.getGender()) && user.isActive()) {
                activeFemaleNames.add(user.getUsername());
            }
        }
        return activeFemaleNames;
    }
}

