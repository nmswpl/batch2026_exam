package in.co.nmsworks.exam;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SalesInformationRunner {
    public static void main(String[] args) {
        SalesInformationRunner salesInformation = new SalesInformationRunner();
        salesInformation.readFile();


    }

    private void readFile() {
        try(BufferedReader br = new BufferedReader
                (new FileReader("/home/nms-training/Downloads/Exam_2026/SALES_DATA.csv"))){

            br.readLine();
            String line = "";
            String[] word = null;
            List<SalesInfo> salesInfoList = new ArrayList<>();
            while((line = br.readLine()) != null){

                word = line.replace(" ","").split(",");
                String id = word[0];
                String name = word[1];
                String category = word[2];
                float price = Float.parseFloat(word[3]);
                int noOfItem = Integer.parseInt(word[4]);
                String date = word[5];
                SalesInfo salesInfo = new SalesInfo(id, name, category, price, noOfItem,date);
                salesInfoList.add(salesInfo);


            }
            calculateAveragePrice(salesInfoList);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void calculateAveragePrice(List<SalesInfo> salesInfoList) {

        Map<String, List<SalesInfo>> mapForCategoryPrice = new HashMap<>();

        for (SalesInfo salesInfo : salesInfoList) {
            mapForCategoryPrice.computeIfAbsent(salesInfo.getCategory(), k -> new ArrayList<>()).add(salesInfo);
        }
        int sum = 0;
        for(Map.Entry<String, List<SalesInfo>> data : mapForCategoryPrice.entrySet()){
            String category = data.getKey();
            List<SalesInfo>categoryPrice = mapForCategoryPrice.get(category);
            for (SalesInfo salesInfo : categoryPrice) {
                sum += salesInfo.getPrice();
            }
            int average = sum / categoryPrice.size();
            System.out.println("Average of " + category + " is " + average);
        }



    }


}
