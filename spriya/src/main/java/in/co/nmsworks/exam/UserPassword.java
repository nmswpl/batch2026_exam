package in.co.nmsworks.exam;


import java.sql.*;
import java.util.*;

public class UserPassword {

   List< List<String> >list=new ArrayList<>();
    public void readDb(){

        try(Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/exam2026");
            PreparedStatement statement=con.prepareStatement("select username,password from user_details");
            Scanner sc=new Scanner(System.in);){

            ResultSet rs= statement.executeQuery();
            while(rs.next()){


                String userName=rs.getString(1);
                String password=rs.getString(2);
                List<String> smallList=new ArrayList<>();
                smallList.add(userName);
                smallList.add(password);

                list.add(smallList);


            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    public void check(String name,String secret){



        for (int i = 0; i < list.size(); i++) {
            String nameValue=list.get(i).get(0);
            String password=list.get(i).get(1);
            if(name.equals(nameValue)){

                if(secret.equals(password)){
                    System.out.println("Password Valid");
                    return;
                }
                else{
                    System.out.println("Invalid password");
                    return;
                }
            }

        }

            System.out.println("Invalid Username");

        }
    }

