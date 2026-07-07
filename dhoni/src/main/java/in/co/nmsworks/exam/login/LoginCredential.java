package in.co.nmsworks.exam.login;

import java.sql.*;
import java.util.*;

public class LoginCredential {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/exam2026";
        String user = "nms-training";
        String password = "";
        LoginCredential runner = new LoginCredential();
        List<UserDetails> userDetailsList = runner.getUsersList(url,user,password);

//        for(UserDetails userDetails : userDetailsList){
//            System.out.println(userDetails);
//        }

        runner.checkValidUser(url,user,password);

        Set<String> getActiveFemaleName = runner.getActiveFemaleName(userDetailsList);

        for(String femaleName : getActiveFemaleName){
            System.out.println(femaleName);
        }


    }
    private Set<String> getActiveFemaleName(List<UserDetails> list){
        Set<String> set = new HashSet<>();

        for(UserDetails user : list){

            if(user.getGender().equals("Female") && user.getAccount_status().equals("Active")){
                set.add(user.getName());
            }
        }

        return set;
    }

    private void checkValidUser(String url, String user, String password) {
        ;

        try (Connection connection = DriverManager.getConnection(url,user,password);
             Scanner scanner = new Scanner(System.in)
        )
        {
            String findUser = "select * from user_details where username = ? and password = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(findUser);

            //System.out.println("Enter user name : ");
            String userName = "bmeacher0";
            //System.out.println("Enter user password");
            String userPassword = "lL5{&~og,yKtb|U";

            preparedStatement.setString(1,user);
            preparedStatement.setString(2,userPassword);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                System.out.println(resultSet.getString(4) + " " + resultSet.getString(5));
                System.out.println("valid Username, valid Password, Password Valid");
                return;
            }

            System.out.println("Invalid Username, Invalid Password, Password Valid");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private List<UserDetails> getUsersList(String url, String user, String password) {
        List<UserDetails> list  = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url,user,password))
        {
            String select = "select * from user_details";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(select);

            while(resultSet.next()){
                list.add(new UserDetails(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6)
                ));
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        return list;
    }
}
