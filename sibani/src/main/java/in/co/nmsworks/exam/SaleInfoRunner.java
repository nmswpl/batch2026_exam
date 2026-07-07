package in.co.nmsworks.exam;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class SaleInfoRunner {
    public static void main(String[] args) {
        SaleInfoRunner saleInfoRunner = new SaleInfoRunner();
        List<SaleInfo> saleInfoList = saleInfoRunner.readFromFile();
        saleInfoRunner.printAveragePriceBasedOnCategory(saleInfoList);
    }

    private void printAveragePriceBasedOnCategory(List<SaleInfo> saleInfoList) {
        Map<String, SaleInfo> categoryBasedSalesInfo = new HashMap<>();

    }
    private List<SaleInfo> readFromFile() {
        List<SaleInfo> saleInfoList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("/home/nms-training/Downloads/Exam_2026/SALES_DATA.csv"))) {
            String line = "";
            while ((line = bufferedReader.readLine()) != null){
                String[] salesInfo = line.split(",");
                String salesId = salesInfo[0].replaceAll(" ", "");
                String name = salesInfo[1].replaceAll(" ", "");
                String category = salesInfo[2].replaceAll(" ", "");
                Double price = Double.parseDouble(salesInfo[3].replaceAll(" ", ""));
                Integer itemsSold = Integer.parseInt(salesInfo[4].replaceAll(" ", ""));
                String date = salesInfo[5].replaceAll(" ", "");
                SaleInfo saleInfo = new SaleInfo(salesId,name,category,price,itemsSold,date);
                saleInfoList.add(saleInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return saleInfoList;
    }
}
