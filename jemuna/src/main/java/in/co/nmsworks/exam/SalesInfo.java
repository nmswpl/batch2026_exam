package in.co.nmsworks.exam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static jdk.nashorn.internal.objects.NativeMath.max;

public class SalesInfo {
    public static void main(String[] args) {
        SalesInfo salesinfo = new SalesInfo();
        Set<String> categorySet = new HashSet<>();
        salesinfo.averagePrice(categorySet);
        SalesEntry sales = new SalesEntry();
    }

    private void averagePrice(Set<String> categorySet) {

        try(BufferedReader reader = new BufferedReader(new FileReader("/home/nms-training/Downloads/Exam_2026/SALES_DATA.csv"))){
            String line;
            int averagePrice = 0;
            int sum = 0;
            int wordlength;
            reader.readLine();
            while((line = reader.readLine())!=null){
                String[] words = line.split(",");
                for (String word : words) {
                    System.out.println(word);
                    word.trim();
                }
                wordlength = words.length;
                for (int i = 0; i < words.length; i++) {
                    String sales_id = words[0];
                    String product_name = words[1];
                    String category = words[2];
                    categorySet.add(words[2]);
                    int price = Integer.parseInt(words[3].trim());
                    float items_sold = Float.parseFloat(words[4].trim());
                    String date = words[5];
                    SalesEntry sales = new SalesEntry(sales_id,product_name,category,price,items_sold,date);
                    for (String eachCategory : categorySet) {
                        if(sales.category.equals(eachCategory)){
                            sum+=sales.getPrice();
                            averagePrice = sum/wordlength;
                            System.out.println("Average of Price by Category :"+averagePrice);
                        }
                    }
                    int maxSoldItems = (int) max(sales.getItems_sold());
                    System.out.println("Max Sold item :"+maxSoldItems);
                }

            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


}
