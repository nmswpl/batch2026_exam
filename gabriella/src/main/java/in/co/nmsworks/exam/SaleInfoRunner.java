package in.co.nmsworks.exam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SaleInfoRunner {
    public static void main(String[] args) {
        SaleInfoRunner saleInfoRunner = new SaleInfoRunner();
        List<SaleInfo> saleInfoList = saleInfoRunner.readFile();
//        for (SaleInfo saleInfo : saleInfoList) {
//            System.out.println(saleInfo);
//        }
        Map<String, Float> avgPriceByCategory = saleInfoRunner.findAverageByCategory(saleInfoList);
        for (Map.Entry<String, Float> stringFloatEntry : avgPriceByCategory.entrySet()) {
            System.out.println(stringFloatEntry);
        }
    }

    private Map<String, Float> findAverageByCategory(List<SaleInfo> saleInfoList) {
        Map<String, Float> avgPriceByCategory = new HashMap<>();
        for (SaleInfo saleInfo : saleInfoList) {
            String category = saleInfo.getCategory();
            Float price = avgPriceByCategory.get(category);
            Integer itemsSold = saleInfo.getItemsSold();
            if (price == null){
                price = saleInfo.getPrice();
                avgPriceByCategory.put(category, price);
            } else {
                avgPriceByCategory.replace(category, (price + saleInfo.getPrice())/itemsSold);
            }

        }
        return avgPriceByCategory;
    }

    private List<SaleInfo> readFile() {
        List<SaleInfo> saleInfoList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("/home/nms-training/Downloads/Exam_2026/SALES_DATA.csv"))){
            String line = "";
            bufferedReader.readLine();
            while((line = bufferedReader.readLine()) != null){
                String[] splitLine = line.split(" , ");

                String id = splitLine[0];
                String productName = splitLine[1];
                String category = splitLine[2];
                Float price = Float.valueOf(splitLine[3]);
                Integer itemsSold = Integer.valueOf(splitLine[4]);
                String saleDate = splitLine[5];
                SaleInfo saleInfo = new SaleInfo(id, productName, category, price, itemsSold, saleDate);
                saleInfoList.add(saleInfo);

            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return saleInfoList;
    }
}
