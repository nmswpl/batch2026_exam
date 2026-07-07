package in.co.nmsworks.exam;

import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SalesRunner {
    public static void main(String[] args) {
        SalesRunner salesRunner = new SalesRunner();
        salesRunner.calcAvgPrices();
        salesRunner.highestPrice();
    }

    private void highestPrice() {

    }

    private void calcAvgPrices() {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("/home/nms-training/Downloads/Exam_2026/SALES_DATA.csv"))) {
            String line ="";
            List<SaleInfo> list = new ArrayList<>();
            while ((line = bufferedReader.readLine())!= null){
                String[] str = line.split(",");
                list.add(new SaleInfo(str[0].trim(),str[1],str[2],Double.parseDouble(str[3]),Integer.parseInt(str[4].trim()), str[5]));
            }
            Map<String,List<Double>> map = new HashMap<>();
            for (SaleInfo saleInfo : list) {
                map.putIfAbsent(saleInfo.getCategory(),new ArrayList<>());
                map.get(saleInfo.getCategory()).add(saleInfo.getPrice());

            }
            Map<String,Double>averagePrices = new HashMap<>();
            for (SaleInfo saleInfo : list) {
                double sum = 0;
                List<Double> prices =  map.get(saleInfo.getCategory());
                for (Double price : prices) {
                    sum += price;
                }
               double avg =  sum / prices.size();
                averagePrices.put(saleInfo.getCategory(),avg);
            }
            for (Map.Entry<String, Double> stringDoubleEntry : averagePrices.entrySet()) {
                System.out.println("Category : "+stringDoubleEntry.getKey());
                System.out.println("Avg price : "+stringDoubleEntry.getValue());

            }



        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
