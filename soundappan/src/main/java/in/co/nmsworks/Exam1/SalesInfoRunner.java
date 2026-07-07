package in.co.nmsworks.Exam1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SalesInfoRunner {
    public static void main(String[] args) {
        List<SalesInfo>sales=fetchData();
      Map<String,List<Double>>splitProduct= priceSplit(sales);
      Map<String,Double>price=groupProduct(splitProduct);
      Map<String,Double>month=monthProduct(splitProduct);

    }

    private static Map<String, Double> monthProduct(Map<String, List<Double>> splitProduct) {
        Map<String, Double>value=new HashMap<>();
        return value;
    }

    private static Map<String, Double> groupProduct(Map<String, List<Double>> splitProduct) {
        Map<String, Double> data = new HashMap<>();
        for (Map.Entry<String, List<Double>> entry : splitProduct.entrySet()) {
            System.out.println("Product : " + entry.getKey());
            double sum = 0;
            for (Double d : entry.getValue()) {
                sum += d;
            }
            data.put(entry.getKey(), sum);
            System.out.println(sum);
        }
        return data;
    }

    private static Map<String, List<Double>> priceSplit(List<SalesInfo> sales) {
        Map<String,List<Double>>category=new HashMap<>();
        for(SalesInfo sale:sales){
            String product= sale.getCategory();
            double price= sale.getPrice();
            if(category.get(product)==null){
                List<Double>val=new ArrayList<>();
                category.put(product,val);
            }
            System.out.println(sale);
            category.get(product).add(price);
        }
        return category;
    }


    private static List<SalesInfo> fetchData() {
        List<SalesInfo>value=new ArrayList<>();
        try ( BufferedReader br=new BufferedReader(new FileReader("/home/nms-training/Downloads/Exam_2026/SALES_DATA.csv"));){
            String line="";
            br.readLine();
            while((line=br.readLine())!=null){
                String []word=line.split(",");
                String id=word[0].trim();
                String name=word[1];
                String category=word[2];
                double price=Integer.parseInt(word[3]);
                int item=Integer.parseInt(word[4]);
                String dates=word[5];
                System.out.println(id+name+category+price);
                value.add(new SalesInfo(id,name,category,price,item,dates));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
return value;
    }
}
