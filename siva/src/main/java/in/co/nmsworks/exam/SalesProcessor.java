package in.co.nmsworks.exam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SalesProcessor {
    public static void main(String[] args) {
        SalesProcessor salesProcessor = new SalesProcessor();
        salesProcessor.run();
    }

    private void run() {
        List<String> fileContent = readFile("/home/nms-training/Downloads/Exam_2026/SALES_DATA.csv");
        List<SaleInfo> salesInfoList = getSalesInfoList(fileContent);
        Map<String, List<SaleInfo>> categoryToSaleInfo = getCategoryToSaleInfo(salesInfoList);
        calculateAveragePriceForEachCategory(categoryToSaleInfo);
        Map<String, SaleInfo> monthToHighestSaleInfo = getMonthToHighestSaleInfo(salesInfoList);
        printHighestSoldProfitProductEachMonth(monthToHighestSaleInfo);
    }

    private void printHighestSoldProfitProductEachMonth(Map<String, SaleInfo> monthToHighestSaleInfo) {
        System.out.println("-------------------- Highest sold Profit Product each Month -----------------");
        for (String month : monthToHighestSaleInfo.keySet()) {
            System.out.println(month+" ---> "+ getCurrentSaleAmount(monthToHighestSaleInfo.get(month)) + "\t"+monthToHighestSaleInfo.get(month));
        }
    }

    private Map<String, SaleInfo> getMonthToHighestSaleInfo(List<SaleInfo> salesInfoList) {
        Map<String, SaleInfo> monthToHighestSaleInfo = new HashMap<>();
        for (SaleInfo saleInfo : salesInfoList) {
            double currentSaleAmount = getCurrentSaleAmount(saleInfo);
            SaleInfo currentMonthSaleInfo = monthToHighestSaleInfo.get(saleInfo.getSaleDate().substring(3,5));
            if (currentMonthSaleInfo == null) {
                monthToHighestSaleInfo.put(saleInfo.getSaleDate().substring(3,5), saleInfo);
            }
            else {
                if (currentSaleAmount > getCurrentSaleAmount(currentMonthSaleInfo))
                    monthToHighestSaleInfo.put(saleInfo.getSaleDate().substring(3,5), saleInfo);
            }
        }
        return monthToHighestSaleInfo;
    }

    private double getCurrentSaleAmount(SaleInfo saleInfo) {
        return saleInfo.getPrice() * saleInfo.getSoldCount();
    }

    private void calculateAveragePriceForEachCategory(Map<String, List<SaleInfo>> categoryToSaleInfo) {
        System.out.println("------------------------ Category ------------------- Average price ----------------");
        for (String category : categoryToSaleInfo.keySet()) {
            double sum = 0D;
            List<SaleInfo> currentSaleInfoList = categoryToSaleInfo.get(category);
            double countSalesInfoList = (double) currentSaleInfoList.size();
            for (SaleInfo saleInfo : currentSaleInfoList) {
                sum += saleInfo.getPrice();
            }
            double avgPrice = sum/countSalesInfoList;
            System.out.println("Category :: "+category+"\t"+"Average Price :: "+avgPrice);
        }
    }

    private Map<String, List<SaleInfo>> getCategoryToSaleInfo(List<SaleInfo> salesInfoList) {
        Map<String, List<SaleInfo>> categoryToSaleInfo = new HashMap<>();
        for (SaleInfo saleInfo : salesInfoList) {
            List<SaleInfo> currentSaleInfo = categoryToSaleInfo.get(saleInfo.getCategory());
            if (currentSaleInfo == null) {
                currentSaleInfo = new ArrayList<>();
                categoryToSaleInfo.put(saleInfo.getCategory(), currentSaleInfo);
            }
            currentSaleInfo.add(saleInfo);
        }
        return categoryToSaleInfo;
    }

    private List<SaleInfo> getSalesInfoList(List<String> fileContent) {
        List<SaleInfo> salesInfoList = new ArrayList<>();
        for (String eachLine : fileContent) {
            String[] splitEachLine = eachLine.split(",");
            salesInfoList.add(new SaleInfo(splitEachLine[0].trim(),splitEachLine[1].trim(),splitEachLine[2].trim(),Double.parseDouble(splitEachLine[3].trim()),Integer.parseInt(splitEachLine[4].trim()),splitEachLine[5].trim()));
        }
        return salesInfoList;
    }

    private List<String> readFile(String filePath) {
        List<String> fileContent = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String eachLine;
            reader.readLine();
            while ((eachLine = reader.readLine()) != null) {
                fileContent.add(eachLine);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileContent;
    }
}
