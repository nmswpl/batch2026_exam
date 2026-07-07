package in.co.nmsworks.sample.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRunner {
    public static void main(String[] args) {

        UserRunner runnerObj = new UserRunner();
        List<User> usersList = runnerObj.userDBParser("jdbc:mysql://localhost:3306/exam2026", "nms-training", "");
        Map<String,User> userMap = mapUsers(usersList);



        runnerObj.checkValidUsernameAndPassword("lhaycock1","hZ3?)}8nz+lO",userMap);


    }

    private void checkValidUsernameAndPassword(String username, String password, Map<String,User> userMap) {


        String retrievedPassword = userMap.get(username).getPassword();
//        System.out.println("retrieved password : " + retrievedPassword);
        if (retrievedPassword != null) {
            if(retrievedPassword.equals(password)){
                System.out.println("Password is Valid !");
            }
            else{
                System.out.println("Invalid Credentials");
            }
        }
        else{
            System.out.println("Invalid !!!");
        }


    }

    private static Map<String, User> mapUsers(List<User> usersList) {
        Map<String, User> usersMap = new HashMap<>();
        for (User user : usersList) {
            usersMap.put(user.getUsername(), user);
//            System.out.println(user.getName() + " : " + user.getPassword());
        }
        return usersMap;

    }

    public List<User> userDBParser(String url,String dbUsername,String dbPassword){

        List<User> usersList = new ArrayList<>();
        try(Connection con = DriverManager.getConnection(url,dbUsername,dbPassword);
            Statement stmt = con.createStatement(); ){

            ResultSet result = stmt.executeQuery("SELECT * FROM user_details");
            while(result.next()){
//                System.out.println( result.getString(1) + " , " +
//                                    result.getString(2) + " , " +
//                                    result.getString(3) + " , " +
//                                    result.getString(4) + " , " +
//                                    result.getString(5) + " , " +
//                                    result.getString(6) + " , ");

                String id = result.getString(1);
                String name =  result.getString(2);
                String gender = result.getString(3);
                String username = result.getString(4);
                String password = result.getString(5);
                String account_status = result.getString(6);

                usersList.add(new User(id,name,gender,username,password,account_status));

            }

        }catch(Exception e){
            e.printStackTrace();
        }


        return usersList;
    }
}
