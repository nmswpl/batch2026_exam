package in.co.nmsworks.Exam;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class LoginManagement {
    static String DB_URL = "jdbc:mysql://localhost:3306/exam2026";
    static String DB_USER = "nms-training";
    static String DB_PASSWORD = "";

    public static void main(String[] args) {
        LoginManagement use = new LoginManagement();
        use.verifyUserLogin();

        System.out.println("--- Fetching Active Female Users ---");


        List<UserDetails> userList = use.getAllUsersFromDb();
        Set<String> activeFemales = use.getActiveFemaleName(userList);

        System.out.println("Active Female Usernames: " + activeFemales);
    }

    public static void verifyUserLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String inputUser = scanner.nextLine().trim();
        System.out.print("Enter password: ");
        String inputPass = scanner.nextLine().trim();

        String query = "SELECT password FROM user_details WHERE username = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, inputUser);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String dbPassword = rs.getString("password");
                if (dbPassword.equals(inputPass)) {
                    System.out.println("Password is Valid");
                } else {
                    System.out.println("Invalid Password");
                }
            } else {
                System.out.println("Invalid Username");
            }
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        }
    }


    private List<UserDetails> getAllUsersFromDb() {
        List<UserDetails> userList = new ArrayList<>();
        String query = "SELECT username, gender, account_status FROM user_details";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String username = rs.getString("username");
                String gender = rs.getString("gender");
                String status = rs.getString("account_status");
                userList.add(new UserDetails(username, gender, status));
            }
        } catch (SQLException e) {
            System.err.println("Database fetch error: " + e.getMessage());
        }
        return userList;
    }

    private Set<String> getActiveFemaleName(List<UserDetails> users) {
        if (users == null) {
            return Collections.emptySet();
        }

        Set<String> activeFemales = new HashSet<>();

        for (UserDetails user : users) {
            if (user != null && "Female".equalsIgnoreCase(user.getGender()) && "Active".equalsIgnoreCase(user.getStatus())) {
                activeFemales.add(user.getUsername());
            }
        }

        return activeFemales;
    }
}