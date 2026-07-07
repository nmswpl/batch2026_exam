package in.co.nmsworks.exam
;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDetails {
    public static void main(String[] args) {
        //Scanner sc=new Scanner();
        UserDetails ur=new UserDetails();
        ur.userValidator();

    }
    private void userDatailList() {
        String username="nms-training";
        String url="jdbc:mysql://localhost:3306/exam2026";
        String password="";
        String query="SELECT emp_id,name,gender,username,password,account_status FROM user_details";
        List<UserDetail> userlist=new ArrayList<>();
        try (Connection conn= DriverManager.getConnection(url,username,password);
             PreparedStatement pstm = conn.prepareStatement(query)){

            try (ResultSet rs = pstm.executeQuery()){
                while (rs.next()){
                    String empid = rs.getString(1);
                    String name = rs.getString(2);
                    String gender = rs.getString(3);
                    String user = rs.getString(4);
                    String passwords = rs.getString(5);
                    String accountStatus = rs.getString(6);

                    UserDetail u1=new UserDetail(empid,name,gender,user,passwords,accountStatus);

                    userlist.add(u1);




                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void userValidator() {
        String username="nms-training";
        String url="jdbc:mysql://localhost:3306/exam2026";
        String password="";
        String query="SELECT username,password FROM user_details WHERE username=?";
        try (Connection conn= DriverManager.getConnection(url,username,password);
             PreparedStatement pstm = conn.prepareStatement(query)){

            pstm.setString(1,"john24");
            //pstm.setString(2,"93a5fe6210bfcdb573ccd348e19e6a56");

            try (ResultSet rs = pstm.executeQuery()){
                while (rs.next()){
                    String userName = rs.getString(1);
                    if (userName.isEmpty()){
                        System.out.println("Invalid Username");
                    }
                    String passWord = rs.getString(2);
                    if (passWord.isEmpty()){
                        System.out.println("Invalid Password");
                    }
                    if (!userName.isEmpty() && passWord.isEmpty()){
                        System.out.println("Password Valid");
                    }
                    System.out.println("UserName :" + userName + " | " + "Password is: "+ passWord);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
