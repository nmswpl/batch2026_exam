package in.co.nmsworks.exam;

import java.sql.*;

public class Sql {
    public static void main(String[] args) {
        Sql sql = new Sql();
        String username = "greek3";
        String password = "wT2\">M01U*38r";
        sql.checkPWAndUser(username,password);
    }

    private void checkPWAndUser(String username, String password) {
        String sql = "select * from user_details where username = ? and password =?";
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam2026","nms-training",""); PreparedStatement preparedStatement=connection.prepareStatement(sql)){
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();
           if (resultSet.next()){
               String user = resultSet.getString(1);
               String pw = resultSet.getString(2);
               boolean t = resultSet.getString(1).equalsIgnoreCase(user);
               boolean g = resultSet.getString(2).equalsIgnoreCase(pw);
               if (t == g){
                   System.out.println("valid password ");
               }else{
                   System.out.println("invalid password");
               }

           }



        } catch (SQLException e) {
            e.printStackTrace();
        }
     ;
    }
}
