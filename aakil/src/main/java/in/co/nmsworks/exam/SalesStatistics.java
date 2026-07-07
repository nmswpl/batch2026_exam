package in.co.nmsworks.exam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class SalesStatistics {
    public static void main(String[] args) {
        SalesStatistics stats = new SalesStatistics();

        List<SalesInfo> salesInfoList = stats.getSalesInfoList();
        stats.printAvgPricePerCategory(salesInfoList);
        System.out.println("------------------------------------------------------");
        stats.highestSoldProductEachMonth(salesInfoList);
    }

    private void highestSoldProductEachMonth(List<SalesInfo> salesInfoList) {
        Map<Integer, List<SalesInfo>> monthlySalesGrouping = new HashMap<>();
        for (SalesInfo salesInfo : salesInfoList) {
            List<SalesInfo> products = monthlySalesGrouping.getOrDefault(salesInfo.getSaleMonth(), new ArrayList<>());
            products.add(salesInfo);
            monthlySalesGrouping.put(salesInfo.getSaleMonth(), products);
        }

        for (Map.Entry<Integer, List<SalesInfo>> salesEntry : monthlySalesGrouping.entrySet()) {
            SalesInfo maxSoldProduct = null;
            double maxSoldPrice = 0;
            for (SalesInfo salesInfo : salesEntry.getValue()) {
                if (salesInfo.getPriceSold() > maxSoldPrice){
                    maxSoldProduct = salesInfo;
                }
            }
            System.out.println("MONTH : " + salesEntry.getKey() + " ---> " + maxSoldProduct);
        }
    }

    private void printAvgPricePerCategory(List<SalesInfo> salesInfoList) {
        Map<String, List<SalesInfo>> categoryGrouping = new HashMap<>();
        for (SalesInfo saleInfo : salesInfoList) {
            List<SalesInfo> products = categoryGrouping.getOrDefault(saleInfo.getCategory(), new ArrayList<>());
            products.add(saleInfo);
            categoryGrouping.put(saleInfo.getCategory(), products);
        }

        int count = 1;
        for (Map.Entry<String, List<SalesInfo>> groupedEntry : categoryGrouping.entrySet()) {
            double totalPrice = groupedEntry.getValue().stream().mapToDouble(SalesInfo::getPrice).sum();
            double avgPrice = totalPrice / groupedEntry.getValue().size();
            System.out.print("\n " + count++ + ". AVG PRICE FOR " + groupedEntry.getKey() + " : ");
            System.out.print(avgPrice);
        }
    }

    private List<SalesInfo> getSalesInfoList() {
        List<SalesInfo> salesInfoList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/java/in/co/nmsworks/exam/data/SALES_DATA.csv"))){
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null){
                String[] info = line.split(",");
                SalesInfo saleInfo = new SalesInfo();
                saleInfo.setId(info[0]);
                saleInfo.setName(info[1]);
                saleInfo.setCategory(info[2]);
                saleInfo.setPrice(Double.parseDouble(info[3].trim()));
                saleInfo.setItemsSold(Integer.parseInt(info[4].trim()));
                saleInfo.setSaleDay(Integer.parseInt(info[5].trim().split("-")[0]));
                saleInfo.setSaleMonth(Integer.parseInt(info[5].trim().split("-")[1]));
                saleInfo.setSaleYear(Integer.parseInt(info[5].trim().split("-")[2]));

                salesInfoList.add(saleInfo);
//                System.out.println(saleInfo);
            }
        } catch (Exception e){
            System.out.println("GetSalesInfoList : " + e.getMessage());
        }

        return salesInfoList;
    }
}
