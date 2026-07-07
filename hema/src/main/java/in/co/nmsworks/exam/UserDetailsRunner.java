package in.co.nmsworks.exam;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDetailsRunner {
    public static void main(String[] args) {
        List<UserDetails> userDetailsList;
        UserDetailsRunner runner = new UserDetailsRunner();
        userDetailsList = runner.readDB();
        System.out.println(userDetailsList.size());




    }

    private List<UserDetails> readDB() {
        List<UserDetails> userDetailsList = new ArrayList<>();

        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam2026","nms-training","");
            PreparedStatement preparedStatement = connection.prepareStatement("select * from user_details"))
        {
            ResultSet resultSet = preparedStatement.executeQuery();

            while ( resultSet !=  null )
            {

                String id = resultSet.getString("emp_id");
                String name = resultSet.getString("name");
                String gender = resultSet.getString("gender");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String accountStatus = resultSet.getString("account_status");

                userDetailsList.add(new UserDetails(id,name,gender,username,password,accountStatus));

            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return userDetailsList;
    }
}
