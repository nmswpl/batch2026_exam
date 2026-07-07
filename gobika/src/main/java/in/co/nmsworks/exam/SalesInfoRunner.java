package in.co.nmsworks.exam;

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
        SalesInfoRunner salesInfoRunner = new SalesInfoRunner();

        salesInfoRunner.calculateAndPrintAveragePrice();
        salesInfoRunner.highestSoldProductInEachMonth();


    }

    private void highestSoldProductInEachMonth() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("/home/nms-training/Downloads/Exam_2026/SALES_DATA.csv"))){
            String line = bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null){
                String[] product = line.split(",");

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void calculateAndPrintAveragePrice() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("/home/nms-training/Downloads/Exam_2026/SALES_DATA.csv"))){
            Map<String, List<Double>> categoryToPriceOfEachItem = new HashMap<>();
            Map<String,Double> categoryToAveragePrice = new HashMap<>();
            String line = bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null){
                String[] product = line.split(",");
                String category = product[2];
                List<Double> priceOfItem = categoryToPriceOfEachItem.get(category);
                if ( priceOfItem == null ){
                    priceOfItem = new ArrayList<>();
                    categoryToPriceOfEachItem.put(category,priceOfItem);
                }
                priceOfItem.add(Double.valueOf(product[3]));
            }
            Double sumOfPrice = 0.0;
            Double averagePrice = 0.0;
            for(Map.Entry<String,List<Double>> category : categoryToPriceOfEachItem.entrySet()){
                for (Double price : category.getValue()) {
                    sumOfPrice += price;
                }
                averagePrice = sumOfPrice/category.getValue().size();
                categoryToAveragePrice.put(category.getKey(),averagePrice);

            }

            for(Map.Entry<String,Double> category : categoryToAveragePrice.entrySet()){
                System.out.println("Category : "+category.getKey() + "  AveragePrice : "+category.getValue());

            }



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
