package in.co.nmsworks.exam;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.concurrent.ExecutionException;

public class LoginCredentials {
    public static void main(String[] args) {
        try(Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/exam2026");
            PreparedStatement preparedStatement=connection.prepareStatement("select * from user_details where username=? and password=?"))
        {
            preparedStatement.setString(1,"john24");
            preparedStatement.setString(2,"93a5fe6210bfcdb573ccd348e19e6a56");
            ResultSet rs=preparedStatement.executeQuery();

            while(rs.next())
            {
                System.out.println(rs);
            }


        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
