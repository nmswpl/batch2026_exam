package in.co.nmsworks.exam;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserDetailsRunner {
    public static void main(String[] args) {
        UserDetailsRunner userDetailsRunner = new UserDetailsRunner();
        List<UserDetails>list = userDetailsRunner.addList();
        Set<String>femaleNamess = userDetailsRunner.getActiveFemaleName(list);
        System.out.println("active female namelist ::: ");
        for (String names : femaleNamess) {
            System.out.println(names);

        }


    }
    private Set<String> getActiveFemaleName(List<UserDetails>list){
        Set<String>names = new HashSet<>();
        for (UserDetails userDetails : list) {
            if (userDetails.getAccount_status().equalsIgnoreCase("active")){
                if (userDetails.getGender().equalsIgnoreCase("female")){
                    names.add(userDetails.getName());
                }
            }

        }
        return names;

    }
     public List<UserDetails> addList() {
         String sql = "select * from user_details";
         List<UserDetails> userDetailsList = new ArrayList<>();
         try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam2026", "nms-training", ""); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
             ResultSet resultSet = preparedStatement.executeQuery();
             while (resultSet.next()) {
                 userDetailsList.add(new UserDetails(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6)));
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }
         return  userDetailsList;

     }
}
