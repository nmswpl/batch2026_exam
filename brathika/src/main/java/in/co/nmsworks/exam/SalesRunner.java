package in.co.nmsworks.exam;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SalesRunner {
    public static void main(String[] args) {
        SalesRunner salesRunner = new SalesRunner();
        List<SalesInfo> salesInfos = salesRunner.readFromFile();
        salesRunner.printAveragePriceByCategory(salesInfos);
        salesRunner.printHighesSold(salesInfos);

    }


    private void printHighesSold(List<SalesInfo> salesInfos) {
        Map<String, List<SalesInfo>> productToSalesInfo = new HashMap<>();
        for (SalesInfo salesInfo : salesInfos) {
            String name = salesInfo.getProductName();
            List<SalesInfo> sales = productToSalesInfo.get(name);
            if (sales == null) {
                sales = new ArrayList<>();
                productToSalesInfo.put(name,sales);
            }
            sales.add(salesInfo);
        }
        for (Map.Entry<String, List<SalesInfo>> entry : productToSalesInfo.entrySet()) {
            Double max = 0.0;
            List<SalesInfo> sales = entry.getValue();
            for (SalesInfo sale : sales) {
                Double total = 0.0;
                for (int i = 1; i < 12; i++) {
                    if (sale.getDate().contains(i+"-")) {
                        Double priceSold = sale.getItemsSold() * sale.getPrice();
                        max = Math.max(priceSold,max);
                        System.out.println("Max for month is:"+max+" "+sale);
                    }
                }
            }

        }


    }

    private void printAveragePriceByCategory(List<SalesInfo> salesInfos) {
        Map<String, List<SalesInfo>> categoryToSalesInfo = new HashMap<>();
        for (SalesInfo salesInfo : salesInfos) {
            String category = salesInfo.getCategory();
            List<SalesInfo> sales = categoryToSalesInfo.get(category);
            if (sales == null) {
                sales = new ArrayList<>();
                categoryToSalesInfo.put(category,sales);
            }
            sales.add(salesInfo);
        }
        for (Map.Entry<String, List<SalesInfo>> entry : categoryToSalesInfo.entrySet()) {
            String category = entry.getKey();
            List<SalesInfo> sales = entry.getValue();
            Double total = 0.0;
            for (SalesInfo sale : sales) {
                total += sale.getPrice();
            }
            int n = sales.size();
            Double averagePrice = total / n;
            System.out.println("Category: "+entry.getKey()+" average Price: "+averagePrice);

        }
    }

    private List<SalesInfo> readFromFile() {
        List<SalesInfo> salesInfos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("/home/nms-training/Downloads/Exam_2026/SALES_DATA.csv"))){
            String text = "";
            reader.readLine();
            while ((text = reader.readLine()) != null) {
                String[] array = text.split(" , ");
                String salesId = array[0];
                String productName = array[1];
                String category = array[2];
                Double price = Double.valueOf(array[3]);
                Integer itemSold = Integer.parseInt(array[4]);
                String date = array[5];
                SalesInfo salesInfo = new SalesInfo(salesId, productName, category, price, itemSold, date);
                salesInfos.add(salesInfo);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return salesInfos;
    }
}
