package in.co.nmsworks.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Objects;

public class LoginCredentialRunner {
    public static void main(String[] args) {
        LoginCredentialRunner loginCredentialRunner = new LoginCredentialRunner();
        String username = "tantyukhinrr";
        String password = "dC1?BvIZz<&#Lh";
        loginCredentialRunner.checkDetails(username, password);
    }

    private void checkDetails(String username, String password) {

        try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam2026", "nms-training", "");
            PreparedStatement preparedStatement = con.prepareStatement("select username, password from user_details")){
            preparedStatement.executeQuery();
            ResultSet resultSet = preparedStatement.getResultSet();
            int matched = 0;

            while (resultSet.next()){
                if (resultSet.getString("username").equals(username) && resultSet.getString("password").equals(password)){
                    matched = 1;
                    break;
                } else if (resultSet.getString("username").equals(username)){
                    matched = 2;
                } else {
                    matched = 3;
                }
            }

            if (matched == 1){
                System.out.println("Password valid");
            } else if (matched == 2){
                System.out.println("Password invalid");
            } else {
                System.out.println("Username invalid");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
