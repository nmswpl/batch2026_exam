package in.co.nmsworks;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SaleInfo
{
    public static void main(String[] args) throws IOException {
        String file = "/home/nms-training/git/batch2025_exam/sheik/src/main/resources/SALES_DATA.csv";
        try(BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            List<String> categories = new ArrayList<>();

            String ln ;
            br.readLine();
            while((ln=br.readLine())!=null){
                String[] arr = ln.split(",");
                categories.add(arr[2]);
            }
            for (String category : categories) {
                averagePriceOfCat(category);
            }
        }

    }
    public static void averagePriceOfCat(String cat){
        System.out.println(cat);
        String file = "/home/nms-training/git/batch2025_exam/sheik/src/main/resources/SALES_DATA.csv";
        try(BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            String line;
            br.readLine();
            //String cat = "Food - Spices";
            int sum =0;
            int count =0;
            int avg = 0;
            while((line=br.readLine())!=null){
                String[] arr = line.split(",");
                if(arr[2].equals(cat)){

                    sum = sum + Integer.parseInt(arr[3]);
                    count++;
                }
            }
            avg = sum/count;
            System.out.println("Average Price Of " + cat + " : " + avg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printHighestSoldProduct(){

    }
}
