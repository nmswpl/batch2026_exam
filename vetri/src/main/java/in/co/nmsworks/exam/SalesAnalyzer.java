package in.co.nmsworks.exam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SalesAnalyzer {

    public static void main(String[] args) {

        List<SaleInfo> salesList = getSaleInfoList();

        System.out.println("Average Price for Each Category");
        calculateAveragePrice(salesList);

        System.out.println("Highest Sold Product in Each Month");
        calculateHighestSoldByMonth(salesList);
    }

    private static List<SaleInfo> getSaleInfoList() {
        List<SaleInfo> salesList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("/home/nms-training/Downloads/Exam_2026/SALES_DATA.csv"))) {
            String line;
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 6) {
                    SaleInfo sale = new SaleInfo(
                            data[0].trim(),
                            data[1].trim(),
                            data[2].trim(),
                            data[3].trim(),
                            data[4].trim(),
                            data[5].trim()
                    );
                    salesList.add(sale);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return salesList;
    }

    public static void calculateAveragePrice(List<SaleInfo> salesList) {
        Map<String, List<Double>> categoryMap = new HashMap<>();

        for (SaleInfo sale : salesList) {
            String category = sale.getCategory();
            double price = Double.parseDouble(sale.getPrice());

            if (!categoryMap.containsKey(category)) {
                categoryMap.put(category, new ArrayList<>());
            }
            categoryMap.get(category).add(price);
        }

        for (String category : categoryMap.keySet()) {
            List<Double> prices = categoryMap.get(category);

            double sum = 0.0;
            for (double price : prices) {
                sum += price;
            }
            double average = sum / prices.size();

            System.out.println("Category: " + category + "Average Price: " + average);
        }
    }

    public static void calculateHighestSoldByMonth(List<SaleInfo> salesList) {
        Map<String, SaleInfo> topSaleMap = new HashMap<>();
        Map<String, Double> maxRevenueMap = new HashMap<>();

        for (SaleInfo sale : salesList) {
            String[] dateParts = sale.getSaleDate().split("-");
            if (dateParts.length < 3) continue;

            String month = dateParts[1] + "-" + dateParts[2];

            double price = Double.parseDouble(sale.getPrice());
            int itemsSold = Integer.parseInt(sale.getItemsSold());
            double totalRevenue = price * itemsSold;

            if (!maxRevenueMap.containsKey(month) || totalRevenue > maxRevenueMap.get(month)) {
                maxRevenueMap.put(month, totalRevenue);
                topSaleMap.put(month, sale);
            }
        }

        for (String month : topSaleMap.keySet()) {
            SaleInfo bestSale = topSaleMap.get(month);
            System.out.println("Month: " + month + "Highest Product: " + bestSale.getProductName() + "Details: " + bestSale);
        }
    }
}
