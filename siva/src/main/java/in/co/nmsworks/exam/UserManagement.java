package in.co.nmsworks.exam;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserManagement {
    public static void main(String[] args) {
        UserManagement userManagement = new UserManagement();
        userManagement.run();
    }

    private void run() {
        List<UserDetails> userDetailsList = readFromDB();
        authentication(userDetailsList,"john24","93a5fe6210bfcdb573ccd348e19e6a56");
        authentication(userDetailsList,"ntowerl","kQ7_Mt%_!K&'");
        authentication(userDetailsList,"ntowerl","kQ7_Mt%9_!K&'");
        Set<String> activeFemaleName = getActiveFemaleName(userDetailsList);
        printActiveFemaleName(activeFemaleName);
    }

    private void printActiveFemaleName(Set<String> activeFemaleName) {
        if (activeFemaleName == null || activeFemaleName.isEmpty()) {
            System.out.println("No data found");
            return;
        }
        System.out.println("Active Female Name List ");
        for (String name : activeFemaleName) {
            System.out.println(name);
        }
    }

    private Set<String> getActiveFemaleName(List<UserDetails> userDetailsList) {
        Set<String> activeFemaleName = new HashSet<>();
        for (UserDetails userDetail : userDetailsList) {
            if (AccountStatus.ACTIVE.equals(userDetail.getAccountStatus()) && Gender.FEMALE.equals(userDetail.getGender()))
                activeFemaleName.add(userDetail.getName());
        }
        return activeFemaleName;
    }

    private void authentication(List<UserDetails> userDetailsList, String userName, String password) {
        for (UserDetails userDetail : userDetailsList) {
            if (userDetail.getUsername().equals(userName)) {
                if (userDetail.getPassword().equals(password))
                    System.out.println("Password Valid");
                else
                    System.out.println("Invalid Password");
                return;
            }
        }
        System.out.println("Invalid Username");
    }

    private List<UserDetails> readFromDB() {
        List<UserDetails> userDetailsList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam2026","nms-training","");
             PreparedStatement ps = connection.prepareStatement("Select * from user_details");
             ResultSet resultSet = ps.executeQuery()){
            while (resultSet.next()) {
                AccountStatus accountStatus = null;
                Gender gender = null;
                if ("Male".equals(resultSet.getString(3)))
                    gender = Gender.MALE;
                else if ("Female".equals(resultSet.getString(3)))
                    gender = Gender.FEMALE;
                else if ("Others".equals(resultSet.getString(3)))
                    gender = Gender.OTHERS;
                if ("Active".equals(resultSet.getString(6)))
                    accountStatus = AccountStatus.ACTIVE;
                else if ("Inactive ".equals(resultSet.getString(6)))
                    accountStatus = AccountStatus.INACTIVE;
                else if ("Suspended ".equals(resultSet.getString(6)))
                    accountStatus = AccountStatus.SUSPENDED;
                userDetailsList.add(new UserDetails(resultSet.getString(1),resultSet.getString(2),gender,resultSet.getString(4),resultSet.getString(5),accountStatus));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return userDetailsList;
    }
}
