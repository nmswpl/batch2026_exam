package in.co.nmsworks.exam;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LoginCredentials {
    public static void main(String[] args) {
        LoginCredentials loginCredentials = new LoginCredentials();
        String username = "bmeacher0";
        String password = "lL5{&~og,yKtb|U";
        loginCredentials.verification(username, password);
        
    }

    private void verification(String username, String password) {
        String url = "jdbc:mysql://localhost:3306/exam2026";
        List<UserDetails> userDetailsList = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, "nms-training", "");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select * from user_details")) {


            while (rs.next()) {

                String id = rs.getString(1);
                String name = rs.getString(2);
                String gender = rs.getString(3);
                String username1 = rs.getString(4);
                String password1 = rs.getString(5);
                String status = rs.getString(6);

                UserDetails userDetails = new UserDetails(id, name, gender, username1, password1, status);

                userDetailsList.add(userDetails);

                if (username1.equals(username)) {
                    if (password1.equals(password)) {
                        System.out.println("valid username and password");
                        break;
                    } else {
                        System.out.println("invalid password");
                        break;
                    }
                } else {
                    System.out.println("invalid username");
                    break;
                }
            }
            System.out.println(userDetailsList.size());
            System.out.println("ACTIVE FEMALES:");
            System.out.println(activeFemale(userDetailsList));


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Set<String> activeFemale(List<UserDetails> userDetailsList) {

        Set<String> names = new HashSet<>();

        for (UserDetails userDetails : userDetailsList) {
            System.out.println(userDetails);
            String gender = userDetails.getGender();
            String status = userDetails.getStatus();
            System.out.println(gender);
            System.out.println(status);
            if ( gender.equals("Female") && status.equals("Active")){
                names.add(userDetails.getName());
            }
        }
        return names;
    }
}
