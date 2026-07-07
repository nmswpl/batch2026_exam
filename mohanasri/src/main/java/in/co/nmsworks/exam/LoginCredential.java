 package in.co.nmsworks.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

 public class LoginCredential {

    private static final String URL = "jdbc:mysql://localhost:3306/your_database_name";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        LoginCredential lc = new LoginCredential();
        lc.checkLogin();

        List<UserDetails> userList = lc.readDB();
    }

    private List<UserDetails> readDB() {
        List<UserDetails> list = new ArrayList<>();
        String query = "SELECT emp_id, name, gender, username, password, account_status FROM user_details";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                list.add(new UserDetails(
                        rs.getString("emp_id"),
                        rs.getString("name"),
                        rs.getString("gender"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("account_status")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }


    public void checkLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String inputUser = scanner.nextLine();
        System.out.print("Enter password: ");
        String inputPass = scanner.nextLine();

        String query = "SELECT password FROM user_details WHERE username = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, inputUser);
            try (ResultSet rs = stmt.executeQuery()) {
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
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    }





