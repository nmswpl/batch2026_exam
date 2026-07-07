package in.co.nmsworks.Exam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class SaleInfoRunner {

    public static void main(String[] args) {
        String filePath = "/home/nms-training/Downloads/Exam_2026/SALES_DATA.csv";
        SaleInfo[] sales = loadFromCSV(filePath);

        if (sales != null && sales.length > 0) {
            printAveragePriceByCategory(sales);
            printHighestSoldProductPerMonth(sales);
        }
    }

    public static SaleInfo[] loadFromCSV(String filePath) {
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();
            while (br.readLine() != null) {
                count++;
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            return new SaleInfo[0];
        }

        SaleInfo[] sales = new SaleInfo[count];
        int index = 0;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("[dd-MM-yyyy][dd/MM/yyyy]");

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] tokens = line.split(",");

                String salesId = tokens[0].trim();
                String productName = tokens[1].trim();
                String category = tokens[2].trim();
                double price = Double.parseDouble(tokens[3].trim());
                int itemsSold = Integer.parseInt(tokens[4].trim());
                LocalDate saleDate = LocalDate.parse(tokens[5].trim(), formatter);

                sales[index++] = new SaleInfo(salesId, productName, category, price, itemsSold, saleDate);
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
        return sales;
    }

    public static void printAveragePriceByCategory(SaleInfo[] sales) {
        System.out.println("-- Average Price by Category ---");
        Map<String, double[]> categoryData = new HashMap<>();

        for (SaleInfo sale : sales) {
            if (sale == null) continue;
            String cat = sale.getCategory();
            if (!categoryData.containsKey(cat)) {
                categoryData.put(cat, new double[]{sale.getPrice(), 1});
            } else {
                double[] data = categoryData.get(cat);
                data[0] += sale.getPrice();
                data[1] += 1;
            }
        }

        for (Map.Entry<String, double[]> entry : categoryData.entrySet()) {
            double[] data = entry.getValue();
            double avg = data[0] / data[1];
            System.out.printf("Category:  | Avg Price:    ", entry.getKey(), avg);
        }
    }

    public static void printHighestSoldProductPerMonth(SaleInfo[] sales) {
        System.out.println("\n--- Highest Revenue Product Per Month ---");
        Map<String, SaleInfo> highestPerMonth = new HashMap<>();

        for (SaleInfo sale : sales) {
            if (sale == null) continue;
            String month = sale.getMonthKey();
            if (!highestPerMonth.containsKey(month)) {
                highestPerMonth.put(month, sale);
            } else {
                if (sale.getTotalRevenue() > highestPerMonth.get(month).getTotalRevenue()) {
                    highestPerMonth.put(month, sale);
                }
            }
        }

        String[] sortedMonths = highestPerMonth.keySet().toArray(new String[0]);
        for (int i = 0; i < sortedMonths.length - 1; i++) {
            for (int j = i + 1; j < sortedMonths.length; j++) {
                if (sortedMonths[i].compareTo(sortedMonths[j]) > 0) {
                    String temp = sortedMonths[i];
                    sortedMonths[i] = sortedMonths[j];
                    sortedMonths[j] = temp;
                }
            }
        }

        for (String month : sortedMonths) {
            System.out.print("Month: " + month + " -> ");
            System.out.println(highestPerMonth.get(month));
        }
    }
}