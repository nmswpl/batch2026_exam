package in.co.nmsworks.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class LoginCredential {
    public static void main(String[] args) {
        isUsernameAndPasswordValid();
        List<UserDetail> userDetails = readDataFromDb();
        List<UserDetail> activeUsersList = getActiveUsersList(userDetails);
        System.out.println("Active size : " + activeUsersList.size());
        Set<String> activeFemaleNameSet = getActiveFemaleName(activeUsersList);
        System.out.println("Size : " + activeFemaleNameSet.size());
    }

    private static Set<String> getActiveFemaleName(List<UserDetail> activeUsersList) {
        Set<String> activeFemaleNames = new HashSet<>();
        Map<String, List<UserDetail>> genderToUserMap = new HashMap<>();
        for (UserDetail userDetail : activeUsersList) {
            genderToUserMap.computeIfAbsent(userDetail.getGender(), v -> new ArrayList<>()).add(userDetail);
        }

        List<UserDetail> userDetails = genderToUserMap.get("Female");
        for (UserDetail userDetail : userDetails) {
            activeFemaleNames.add(userDetail.getName());
        }

        return activeFemaleNames;
    }


    private static List<UserDetail> getActiveUsersList(List<UserDetail> userDetails) {
        Map<String, List<UserDetail>> statusToUsers = new HashMap<>();

        for (UserDetail userDetail : userDetails) {
            statusToUsers.computeIfAbsent(userDetail.getAccountStatus(), v -> new ArrayList<>()).add(userDetail);
        }

        return statusToUsers.get("Active");
    }

    private static List<UserDetail> readDataFromDb() {

        List<UserDetail> userDetails = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam_2026", "nms-training", "");
            PreparedStatement ps = connection.prepareStatement("select * from user_details");){

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                String empId = resultSet.getString(1);
                String name = resultSet.getString(2);
                String gender = resultSet.getString(3);
                String username = resultSet.getString(4);
                String pwd = resultSet.getString(5);
                String status = resultSet.getString(6);
                UserDetail userDetail = new UserDetail(empId, name, gender, username, pwd, status);
                userDetails.add(userDetail);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

//        for (UserDetail userDetail : userDetails) {
//            System.out.println(userDetail);
//        }

        return userDetails;
    }

    private static void isUsernameAndPasswordValid() {
       try( Scanner scanner = new Scanner(System.in);
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam_2026", "nms-training", "");
            PreparedStatement ps = connection.prepareStatement("select * from user_details where username=?")) {

           System.out.println("Enter username : ");
           String username = scanner.nextLine();;

           System.out.println("Enter password : ");
           String enteredPassword = scanner.nextLine();

           ps.setString(1, username);

           ResultSet resultSet = ps.executeQuery();

           if (resultSet.getFetchSize() == 0) {
               System.out.println("Invalid username");
           }
           else {
               while (resultSet.next()) {
                   String pwd = resultSet.getString("password");

                   if (!enteredPassword.equals(pwd)) {
                       System.out.println("Invalid password");
                   }
                   else {
                       System.out.println("Valid password");
                   }
               }
           }
       } catch (Exception e) {
                  e.printStackTrace();
       }
    }
}
