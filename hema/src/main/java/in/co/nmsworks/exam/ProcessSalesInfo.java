package in.co.nmsworks.exam;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.util.*;

public class ProcessSalesInfo {
    public static void main(String[] args) {
        List<SalesInfo> salesInfoList = new ArrayList<>();

        salesInfoList = readFile();

        printAveragePrice(salesInfoList);
        printHighestSoldProductPerMonth(salesInfoList);


        System.out.println(Date.valueOf("2004-04-27").getMonth()+1);


    }

    private static void printHighestSoldProductPerMonth(List<SalesInfo> salesInfoList) {



    }

    private static void printAveragePrice(List<SalesInfo> salesInfoList) {
        Set<String> categorySet = new LinkedHashSet<>();

        for (SalesInfo info : salesInfoList) {
            categorySet.add(info.getCategory());
        }

        for (String category : categorySet) {

            Float total = 0f;
            int count = 0;

            for (SalesInfo info : salesInfoList) {

                if(category.equals(info.getCategory()))
                {

                    total = total + info.getPrice();
                    count++;

                }
            }

            System.out.println("For category "+ category+" , Average price = "+ (total/count));
        }


    }

    private static List<SalesInfo> readFile() {
        List<SalesInfo> salesInfos = new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("/home/nms-training/Downloads/Exam_2026/SALES_DATA.csv")))
        {
            bufferedReader.readLine();
            String line;

            while ((line = bufferedReader.readLine())!= null)
            {
                line = line.replace("\"","");
                String[] data = line.split(",");
                salesInfos.add(new SalesInfo(data[0].trim(), data[1].trim(), data[2].trim(), Float.parseFloat(data[3].trim()), Integer.parseInt(data[4].trim()), data[5].trim()));

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return salesInfos;
    }
}
