package in.co.nmsworks.exam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoginCredential {
    public static void main(String[] args) {
        LoginCredential credential = new LoginCredential();
        List<UserDetails> userDetailsList = credential.readFromDB();
        credential.checkValid(userDetailsList);
    }

    private void checkValid(List<UserDetails> userDetailsList) {

    }

    private List<UserDetails> readFromDB() {
        List<UserDetails> userDetailsList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection("jdbc:mysql/localhost:3306/exam2026", "nms-training", "");
        Statement stmt = connection.createStatement()) {
            ResultSet resultSet = stmt.executeQuery("select  * from user_details");
            while (resultSet.next()) {
                String empId = resultSet.getString(1);
                String name = resultSet.getString(2);
                String gender = resultSet.getString(3);
                String userName = resultSet.getString(4);
                String password = resultSet.getString(5);
                String status = resultSet.getString(6);
                UserDetails userDetails = new UserDetails(empId, name,gender,userName,password,status);
                userDetailsList.add(userDetails);
            }

            } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return userDetailsList ;

    }
}
