package in.co.nmsworks.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class LoginCredential {
    public static void main(String[] args) {
        LoginCredential credential = new LoginCredential();
        Scanner sc = new Scanner(System.in);
        String userName = sc.nextLine();
        String password = sc.nextLine();

        credential.checkCredential(userName,password);

    }

    private void checkCredential(String userName, String password) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam2026","nms-training","");
             PreparedStatement preparedStatement = connection.prepareStatement("Select * From user_details;")){



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
