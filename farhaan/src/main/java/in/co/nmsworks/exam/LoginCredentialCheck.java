package in.co.nmsworks.exam;

import java.sql.*;
import java.util.*;

public class LoginCredentialCheck {
    List<UserDetails> list = new ArrayList<>();
    public static void main(String[] args) {
        LoginCredentialCheck login = new LoginCredentialCheck();
       Map<String,String> credentials =  login.getUsernamePasswordFromDB();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the username :: ");
        String username = sc.nextLine();
        System.out.println("Enter the Password :: ");
        String password = sc.nextLine();
        login.checkCredentials(username,password,credentials);
        login.getDetails();
        Set<String> set = login.getActiveFemaleName(login.list);
        System.out.println("-----------------------------------------");
        System.out.println("The Active Females List are :: ");
        for (String s : set) {
            System.out.println(s + " ");
        }
    }

    private Set<String> getActiveFemaleName(List<UserDetails> list) {
        Set<String> females = new LinkedHashSet<>();
        for (UserDetails userDetails : list) {
            if("Female".equals(userDetails.getGender()) && "Active".equals(userDetails.getStatus())){
                females.add(userDetails.getName());
            }
        }
        return females;
    }

    private void getDetails() {
        try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam2026","nms-training","");
            Statement statement = con.createStatement()){
            ResultSet resultSet = statement.executeQuery("select  * from user_details");
            while(resultSet.next()) {
                UserDetails user = new UserDetails(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6));
                list.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void checkCredentials(String username, String password, Map<String, String> map) {
        if(map.containsKey(username)){
            if (password.equals(map.get(username))){
                System.out.println("Valid Password");
            }
            else {
                System.out.println("Invalid Password");
            }
        }
        else{
            System.out.println("Invalid Username");
        }
    }

    private Map<String, String> getUsernamePasswordFromDB() {
        try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam2026","nms-training","");
            Statement statement = con.createStatement()){
            Map<String,String> credentials = new HashMap<>();
            ResultSet rs = statement.executeQuery("select username,password from user_details");
            while(rs.next()){
                credentials.put(rs.getString("username"),rs.getString("password"));
            }
            return credentials;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
