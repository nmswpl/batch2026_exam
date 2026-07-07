package in.co.nmsworks.exam;

import java.sql.*;
import java.util.*;

public class UserDetailsRunner {
    public static void main(String[] args) {
        List<UserDetails> userDetailsList;
        UserDetailsRunner runner = new UserDetailsRunner();
        userDetailsList = runner.readDB();
        System.out.println(userDetailsList.size());

        String userName = "tantyukhinrr";
        String password = "dC1?BvIZz<&#Lh";
        runner.checkValid(userDetailsList, userName,password);

        Set<String> activeFemaleDetails = new LinkedHashSet<>();
        activeFemaleDetails = runner.getActiveFemaleName(userDetailsList);

        for (String detail : activeFemaleDetails) {
            System.out.println(detail);
        }

    }

    private Set<String> getActiveFemaleName(List<UserDetails> userDetailsList) {

        Set<String> activeFemales = new LinkedHashSet<>();

        for (UserDetails details : userDetailsList) {
            if("Female".equals(details.getGender()) && "Active".equals(details.getAccountStatus()))
            {
                activeFemales.add(details.getName());
            }
        }


        return activeFemales;
    }

    private void checkValid(List<UserDetails> userDetails, String username, String password) {

        boolean user = false;
        boolean pass = false;
        for (UserDetails detail : userDetails) {
            if( username.equals(detail.getUserName()))
            {
                user = true;
                if(password.equals(detail.getPassword()))
                {
                    user = true;
                    System.out.println("Password Valid");
                    return;
                }

            }
        }
        if(!user)
            System.out.println("Invalid user");
        else
            System.out.println("Invalid password");


    }

    private List<UserDetails> readDB() {
        List<UserDetails> userDetailsList = new ArrayList<>();

        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam2026","nms-training","");
            PreparedStatement preparedStatement = connection.prepareStatement("select * from user_details"))
        {
            ResultSet resultSet = preparedStatement.executeQuery();

            while ( resultSet.next() )
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
