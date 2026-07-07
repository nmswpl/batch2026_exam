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
        List<SalesInfo> salesList = new ArrayList<>();
        SalesInfoRunner info = new SalesInfoRunner();

        String[] columns = new String[0];
        try (BufferedReader br = new BufferedReader(new FileReader("/home/nms-training/Downloads/Exam_2026/SALES_DATA.csv"))) {
            String line = "";

            br.readLine();
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                columns = line.split(",");
                String productName = columns[1].trim();
                String category = columns[2].trim();
                double price = Double.parseDouble(columns[3].trim());
                int itemsSold = Integer.parseInt(columns[4].trim());
                String date = columns[5].trim();

                salesList.add(new SalesInfo(date, category, productName, itemsSold, price));
            }

            info.printAverage(salesList);
            info.highestSoldProduct(salesList);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void highestSoldProduct(List<SalesInfo> salesList) {
        Map<String, SalesInfo> monthlyTopSeller = new HashMap<>();

        for (SalesInfo sale : salesList) {
            String month = sale.getMonth();

            if (!monthlyTopSeller.containsKey(month)) {
                monthlyTopSeller.put(month, sale);
            } else {
                SalesInfo currentTop = monthlyTopSeller.get(month);
                if (sale.getTotalSales() > currentTop.getTotalSales()) {
                    monthlyTopSeller.put(month, sale);
                }
            }
        }

        System.out.println("=== Highest Sold Product Per Month ===");
        for (Map.Entry<String, SalesInfo> entry : monthlyTopSeller.entrySet()) {
            System.out.println("Month : " + entry.getKey() + "  -> " + entry.getValue());
        }
    }

    private void printAverage(List<SalesInfo> salesList) {
        Map<String, Double> categoryTotalSum = new HashMap<>();
        Map<String, Integer> categoryCount = new HashMap<>();

        for (SalesInfo sale : salesList) {
            categoryTotalSum.put(sale.getCategory(), categoryTotalSum.getOrDefault(sale.getCategory(), 0.0) + sale.getPrice());
            categoryCount.put(sale.getCategory(), categoryCount.getOrDefault(sale.getCategory(), 0) + 1);
        }

        System.out.println("=== Average Price Per Category ===");
        for (String category : categoryTotalSum.keySet()) {
            double average = categoryTotalSum.get(category) / categoryCount.get(category);
            System.out.printf("Category: " + category + " Average Price: " + average + "\n");
        }
    }
}



