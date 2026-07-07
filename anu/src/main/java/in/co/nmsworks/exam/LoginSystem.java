package in.co.nmsworks.exam;

import java.sql.*;
import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args) {
        LoginSystem loginSystem = new LoginSystem();
        loginSystem.readtheDb();
    }

    private static void readtheDb() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("entere  name and password");
        //String inputUser = "bmeacher0";
        String inputUser = scanner.next();
        //String inputPass = "lL5{&~og,yKtb|U";
        String inputPass = scanner.next();
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam2026", "nms-training", "");
             PreparedStatement prep = conn.prepareStatement("SELECT password FROM user_details WHERE username = ?")) {
            prep.setString(1, inputUser);
            try (ResultSet rs = prep.executeQuery()) {
                if (rs.next()) {
                    String password = rs.getString("password");
                    if (password.equals(inputPass)) {
                        System.out.println("Password valid");
                    } else {
                        System.out.println("invalid password");
                    }
                } else {
                    System.out.println("invalid username");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

