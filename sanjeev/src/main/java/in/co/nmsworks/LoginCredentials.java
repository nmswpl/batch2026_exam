
package in.co.nmsworks;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LoginCredentials
{

    public static void main(String[] args) throws SQLException{
        LoginCredentials lc=  new LoginCredentials();
        List<UserDetails> userset = new ArrayList<>();
        try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/training","nms-training" , "nms-training")) {
            PreparedStatement ps = con.prepareStatement("select * from user_details");

            ResultSet rs= ps.executeQuery();

            while (rs.next()){
                userset.add(new UserDetails(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(5)));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        lc.activeFemale(userset);

    }

    public Set<String> activeFemale(List<UserDetails> userDetails){
        Set<String > user = new HashSet<>();

        for (UserDetails userDetail : userDetails) {
            if(userDetail.getAccount_status().equals("Active")){
                user.add(userDetail.getUsername());
            }
        }

        return user;
    }
}

