package in.co.nmsworks.exam;

import java.sql.*;

public class UserValidation {
    public static void main(String[] args) throws SQLException {
        UserValidationPOJO user = new UserValidationPOJO();
        String usernamer = "Brit Meacher";
        String userPassword = "lL5{&~og,yKtb|U";
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam2026","nms-training","");
            PreparedStatement preparedStatement = con.prepareStatement("select name,password from students");
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                String name = rs.getString(1);
                String password = rs.getString(2);
            }
            if(usernamer.equals(user.getName())){
                System.out.println("Valid UserName");
            }
            else{
                System.out.println("Invalid UserName");
            }


            if(userPassword.equals(user.getPassword())){
                System.out.println("Valid Password");
            }
            else{
                System.out.println("Invalid Password");
            }
        }
        catch (Exception e){
            e.printStackTrace();

        }
    }
}
