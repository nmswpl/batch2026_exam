package in.co.nmsworks.exam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class SalesInfoRunner {
    public static void main(String[] args) {
        List<Sales> salesList = readDataFromFile();
        printAveragePriceForEachCategory(salesList);
        printHighestSoldProductInEachMonth(salesList);
    }

    private static void printHighestSoldProductInEachMonth(List<Sales> salesList) {
        Map<String, List<Sales>> monthToSales = new HashMap<>();

        for (Sales sales : salesList) {
            String[] words = sales.getSaleDate().split("-");
//            System.out.println("words1 - " + words[1]);

            String month = words[1];
            monthToSales.computeIfAbsent(month, v -> new ArrayList<>()).add(sales);
        }

        for (Map.Entry<String, List<Sales>> entry : monthToSales.entrySet()) {
            Sales productInfo = getHighestSoldProductInfo(entry.getValue());
            System.out.println("Highest sold product in month " + entry.getKey() + " : " + productInfo.getProductName());
        }
    }

    private static Sales getHighestSoldProductInfo(List<Sales> salesList) {

        salesList.sort((a,b) -> (int) ((b.getItemSold()*b.getPrice()) - (a.getItemSold()*a.getPrice())));

        return salesList.get(0);
    }

    private static void printAveragePriceForEachCategory(List<Sales> salesList) {
        Map<String, List<Sales>> categoryToSalesMap = new HashMap<>();

        for (Sales sales : salesList) {
            categoryToSalesMap.computeIfAbsent(sales.getCategory(), v -> new ArrayList<>()).add(sales);
        }

        for (Map.Entry<String, List<Sales>> entry : categoryToSalesMap.entrySet()) {
            System.out.println("Average price for " + entry.getKey() + " : Rs " + getAveragePriceForCategory(entry.getValue()));
        }
    }

    private static double getAveragePriceForCategory(List<Sales> salesList) {
        double totalSales = 0;
        for (Sales sales : salesList) {
            totalSales += sales.getPrice();
        }

        System.out.println("total - " + totalSales);
        System.out.println("list size - " + salesList.size());
        return totalSales/salesList.size();
    }

    private static List<Sales> readDataFromFile() {

        List<Sales> salesList = new ArrayList<>();

        try (FileReader fileReader = new FileReader("/home/nms-training/Downloads/Exam_2026/SALES_DATA.csv");
             BufferedReader bufferedReader = new BufferedReader(fileReader)){

            bufferedReader.readLine();
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split(",");

                Sales sales = new Sales(words[0], words[1].trim(), words[2].trim(), Double.parseDouble(words[3].trim()), Integer.parseInt(words[4].trim()), words[5]);
                salesList.add(sales);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return salesList;
    }
}
