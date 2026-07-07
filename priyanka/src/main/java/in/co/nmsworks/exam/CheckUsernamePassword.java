package in.co.nmsworks.exam;

import com.mysql.cj.jdbc.result.ResultSetImpl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CheckUsernamePassword {
    public static void main(String[] args) {

        fileParsing("Priyanka","priya@2025");
        fileParsing("tantyukhinrr","dC1?BvIZz<&#Lh");
        fileParsing("bmeacher0","lL5{&~og,yKtb|U");

    }
    public static void fileParsing(String usrname,String pwd){
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam2026","nms-training","");
            PreparedStatement preparedStatement= connection.prepareStatement("select username,password from user_details");
            PreparedStatement preparedStatement1 = connection.prepareStatement("Select * from user_details")){
            List<String > usernameList = new ArrayList<>();
            List<String> passwordList = new ArrayList<>();
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                String username = resultSet.getString("username");
                usernameList.add(username);
                String password = resultSet.getString("password");
                passwordList.add(password);
            }
            ResultSet resultSet1 = preparedStatement1.executeQuery();
            List<UserDEtails> userDEtailsList = new ArrayList<>();


            while (resultSet1.next()){
                String emp_id = resultSet1.getString("emp_id");
                String name = resultSet1.getString("name");
                String gender = resultSet1.getString("gender");
                String username = resultSet1.getString("username");
                String password = resultSet1.getString("password");
                String account_status = resultSet1.getString("account_status");
                UserDEtails user = new UserDEtails(emp_id,name,gender,username,password,account_status);
                userDEtailsList.add(user);
            }


            Set<String> femaleSet = getActiveFemaleName(userDEtailsList);
            System.out.println("Active female set: ");
            for (String s : femaleSet) {
                System.out.println(s);
            }
            System.out.println();
            System.out.println();

            for (String username : usernameList) {
                for (String password : passwordList) {
                    if(usrname.equals(username)){
                        if(pwd.equals(password)){
                            System.out.println("valid login");
                            return;
                        }
                        else{
                            System.out.println("invalid pwd");
                            return;
                        }
                    }
                    else{
                        System.out.println("invalid usrname");
                        return;
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Set<String> getActiveFemaleName(List<UserDEtails> userDEtailsList) {
        Set<String> activeFemaleSet = new HashSet<>();
        for (UserDEtails userDEtails : userDEtailsList) {
            String gender = userDEtails.getGender();
            if(gender.equals("Female")){
                String status = userDEtails.getAccount_status();
                if(status.equals("Active")){
                    activeFemaleSet.add(userDEtails.getName());
                }
            }
        }

        return activeFemaleSet;
    }


}
