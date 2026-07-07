package in.co.nmsworks.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FemaleList {
    List<ActiveFemaleName> femaleList=new ArrayList<>();


    public void readDbForActiveList(){
        try(Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/exam2026");
            PreparedStatement statement=con.prepareStatement("select emp_id,name,gender,username,password,account_status from user_details");){


            ResultSet rs= statement.executeQuery();
            while (rs.next()){

                ActiveFemaleName activeFemaleName=new ActiveFemaleName(rs.getString(1),rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5)
                        ,rs.getString(6));
                femaleList.add(activeFemaleName);

            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Set<String> getActiveFemaleName() {

        Set<String> nameList=new HashSet<>();
        for (int i = 0; i < femaleList.size(); i++) {
            String gender=femaleList.get(i).getGender().toLowerCase();
            String status=femaleList.get(i).getAccount_status().toLowerCase();
            String name=femaleList.get(i).getName();

            if(gender.equals("female")){
                if(status.equals("active")){
                    nameList.add(name);
                }
            }
        }
        return nameList;

    }


}
