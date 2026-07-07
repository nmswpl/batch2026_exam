package in.co.nmsworks.exam;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoginCredential {
    public static void main(String[] args) {
        LoginCredential login = new LoginCredential();
        List<Users> users = login.readFromDatabase();
        login.checkValidUsername(users,"tantyukhinrr","dC1?BvIZz<&#Lh");
    }

    private void checkValidUsername(List<Users> users, String username, String password) {
        boolean isFound = false;
        for (Users user : users) {
            if (user.getUsername().contains(username)) {
                if (user.getName().equals(username) && user.getPassword().equals(password)) {
                    isFound = true;
                }
                break;
            }
            else {
                isFound = false;

            }
        }
        if (isFound) {
            System.out.println("Valid credential");
        }
        else {
            System.out.println("Invalid credential");
        }
    }

    private List<Users> readFromDatabase() {
        List<Users> users = new ArrayList<>();
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Exam_2026","nms-training","");
             PreparedStatement statement = con.prepareStatement("SELECT * from user_details")){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString(1);
                String name = resultSet.getString(2);
                String gender = resultSet.getString(3);
                String username = resultSet.getString(4);
                String password = resultSet.getString(5);
                String status = resultSet.getString(6);
                Users user = new Users(id, name, gender, username, password, status);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}
