package in.co.nmsworks.exam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SaleRunner {
    public static void main(String[] args) {
        fileParsing();
    }

    private static void fileParsing() {
        try(BufferedReader reader = new BufferedReader(new FileReader("/home/nms-training/Downloads/Exam_2026/SALES_DATA.csv"))){
            String line = "";
            line = reader.readLine();
            while ((line = reader.readLine())!= null){

                String[] sale = line.split(",");
                String[] modified = new String[6];
                int i =0;
                for (String s : sale) {
                    s=s.trim();
                    modified[i++]=s;
                }
                List<SaleInfo> saleList = new ArrayList<>();
                SaleInfo saleInfo = new SaleInfo(modified[0],modified[1],modified[2], Float.parseFloat(modified[3]),Integer.parseInt(modified[4]),modified[5]);
                saleList.add(saleInfo);
                calculateANdPrintAverage(saleList);
//                highestSoldProduct(saleList);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void highestSoldProduct(List<SaleInfo> saleList) {
        for (SaleInfo saleInfo : saleList) {
            String date = saleInfo.getSale_date();
            List<Integer> month = new ArrayList<>();
            String[] dateArr = date.split("-");
            for (int i = 0; i < dateArr.length; i++) {
                month.add(Integer.parseInt(dateArr[1]));
            }
        }
    }

    private static void calculateANdPrintAverage(List<SaleInfo> saleList) {
        Map<String,List<Float>> categoryToPriceListMap = new HashMap<>();
        for (SaleInfo saleInfo : saleList) {
            String category = saleInfo.getCategory();
            List<Float> priceList = categoryToPriceListMap.get(category);
            if(priceList==null){
                priceList=new ArrayList<>();
                categoryToPriceListMap.put(category,priceList);
            }
            priceList.add(saleInfo.getPrice());
        }

        for (String s : categoryToPriceListMap.keySet()) {
            System.out.println(s+"-->"+categoryToPriceListMap.get(s));
        }
    }
}
