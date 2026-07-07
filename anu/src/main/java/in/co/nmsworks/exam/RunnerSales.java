package in.co.nmsworks.exam;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class RunnerSales {
    public static void main(String[] args) {
        RunnerSales runnerSales = new RunnerSales();
        List<SaleInfo> saleInfoList =runnerSales.readCsvFile();
        runnerSales.printPrice(saleInfoList);
    }
    public void printPrice(List<SaleInfo> sales) {
        Map<String, Double> sum = new HashMap<>();
        Map<String, Integer> count = new HashMap<>();
        for (SaleInfo sale : sales) {
            String category = sale.getCategory();
            double price = sale.getPrice();
            if (sum.containsKey(category)) {
                sum.put(category, sum.get(category) + price);
            } else {
                sum.put(category, price);
            }
            if (count.containsKey(category)) {
                count.put(category, count.get(category) + 1);
            } else {
                count.put(category, 1);
            }
        }
        for (String category : sum.keySet()) {
            double totalPrice = sum.get(category);
            int totalCount = count.get(category);
            double average = totalPrice / totalCount;
            System.out.println(category+average);
        }
    }


    public  void printSold(List<SaleInfo> sales) {
        Map<String, SaleInfo> highestPerMonth = new HashMap<>();
        for (SaleInfo sale : sales) {
            String month = sale.getMonth();

        }
    }



    public static List<SaleInfo> readCsvFile() {
        List<SaleInfo> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("/home/nms-training/Downloads/Exam_2026/SALES_DATA.csv"))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String id =data[0];
                String product = data[1];
                String category =data[2];
                double price = Double.parseDouble(data[3]);
                String itemsSold = data[4];
                String month = data[5];
                list.add(new SaleInfo(id,product,category,price,itemsSold,month));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

}
