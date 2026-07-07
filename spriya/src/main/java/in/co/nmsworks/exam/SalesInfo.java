package in.co.nmsworks.exam;

import java.io.BufferedReader;
import java.io.FileReader;


public class SalesInfo {
    public int cnt=0;
    public double sum=0;

    public void readFile(){

        try(BufferedReader reader=new BufferedReader(new FileReader("/home/nms-training/Downloads/Exam_2026/SALES_DATA.csv"))){

            String line="";
            reader.readLine();

           while((line= reader.readLine())!=null){
               String[] res=line.split(",");

               cnt++;
               String priceValue=res[3].trim();
               double price=Double.parseDouble(priceValue);
               sum+=price;

               String month=res[res.length-1];



           }
           calculateAverage(sum,cnt);
        } catch (Exception e) {
            e.printStackTrace();
        }



    }
    public void highestSoldProduct(){

    }






    public void calculateAverage(double sum,int cnt){

        double avgSalary=sum/(double) cnt;
        System.out.println("Average Salary :"+avgSalary);
    }


}
