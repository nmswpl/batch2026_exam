package in.co.nmsworks.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import java.util.stream.Collectors;

public class UserLogin {
    public static void main(String[] args) {
        UserLogin userLogin = new UserLogin();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username = " );
        String username = scanner.nextLine();
        System.out.println("Enter password = ");
        String password = scanner.nextLine();
        
        userLogin.validateCredentials(username, password);


        List<UserDetails> userDetailsList = userLogin.getUserDetails();
        Set<String> activeFemaleNames = userLogin.getActiveFemaleName(userDetailsList);

        System.out.println(activeFemaleNames);
    }

    private Set<String> getActiveFemaleName(List<UserDetails> userDetailsList) {
        List<UserDetails> activeFemaleList =  userDetailsList.stream().filter(user -> "Female".equals(user.getGender())).collect(Collectors.toList());
        Set<String> activeFemaleNames = new HashSet<>();
        activeFemaleList.forEach(female -> activeFemaleNames.add(female.getName()));
        return activeFemaleNames;
    }

    private List<UserDetails> getUserDetails() {
        List<UserDetails> userDetails = new ArrayList<>();
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam2026", "nms-training", "");
             PreparedStatement ps = con.prepareStatement("select * from user_details;")
        ){
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                UserDetails userDetail = new UserDetails();
                userDetail.setEmpId(resultSet.getString("emp_id"));
                userDetail.setName(resultSet.getString("name"));
                userDetail.setGender(resultSet.getString("gender"));
                userDetail.setUsername(resultSet.getString("username"));
                userDetail.setPassword(resultSet.getString("password"));
                userDetail.setAccStatus(Status.valueOf(resultSet.getString("account_status")));

                userDetails.add(userDetail);
            }
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("ERROR - VALIDATE CREDENTIALS : " + e.getMessage());
        }

        return userDetails;
    }

    private void validateCredentials(String uname, String pass) {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam2026", "nms-training", "");
             PreparedStatement ps = con.prepareStatement("select * from user_details where username = ?;")
        ){
            ps.setString(1, uname);

            ResultSet resultSet = ps.executeQuery();
            if (!resultSet.next()){
                System.out.println("Invalid Username");
            } else if (!resultSet.getString("password").equals(pass)) {
                System.out.println("Invalid Password");
            } else {
                System.out.println("Valid Password");
            }
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("ERROR - VALIDATE CREDENTIALS : " + e.getMessage());
        }
    }
}
