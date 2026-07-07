package in.co.nmsworks.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserDetailsRunner {
    public static void main(String[] args) {
        UserDetailsRunner userDetailsRunner = new UserDetailsRunner();
        List<UserDetails> userDetailsList = userDetailsRunner.readFromDb();
//        for (UserDetails userDetails : userDetailsList) {
//            System.out.println(userDetails);
//        }
        System.out.println("Active females list: ");
        Set<String> activeFemaleNameSet = userDetailsRunner.getActiveFemaleName(userDetailsList);
        for (String string : activeFemaleNameSet) {
            System.out.println(string);
        }
    }

    private List<UserDetails> readFromDb() {
        List<UserDetails> userDetailsList = new ArrayList<>();
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam2026", "nms-training", "");
             PreparedStatement preparedStatement = con.prepareStatement("select * from user_details")) {
            preparedStatement.executeQuery();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()){
                String employeeId = resultSet.getString("emp_id");
                String name = resultSet.getString("name");;
                String gender = resultSet.getString("gender");;
                String username = resultSet.getString("username");;
                String password = resultSet.getString("password");;
                String accountStatus = resultSet.getString("account_status");
                UserDetails userDetails = new UserDetails(employeeId, name, gender, username, password, accountStatus);
                userDetailsList.add(userDetails);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return userDetailsList;
    }

    private Set<String> getActiveFemaleName(List<UserDetails> userDetailsList){
        Set<String> activeFemaleNames = new HashSet<>();
        for (UserDetails userDetails : userDetailsList) {
            if (userDetails.getGender().equals("Female") && userDetails.getAccountStatus().equals("Active")){
                activeFemaleNames.add(userDetails.getName());
            }
        }
        return activeFemaleNames;

    }
}
