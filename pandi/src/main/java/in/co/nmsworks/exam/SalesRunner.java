package in.co.nmsworks.exam;


import java.io.BufferedReader;

import java.io.FileReader;

import java.util.*;

public class SalesRunner {
    public static void main(String[] args) {
        SalesRunner salesRunner=new SalesRunner();
        List<SalesInfo> salesInfoList=salesRunner.readSalesFile("/home/nms-training/Downloads/Exam_2026/SALES_DATA.csv");
        for (SalesInfo salesInfo : salesInfoList) {
            System.out.println("Sales infro from main");
            System.out.println(salesInfo);
        }
//        System.out.println(salesInfoList);

        salesRunner.calculateAvgSalary(salesInfoList);
    }

    private List<SalesInfo> readSalesFile(String path) {
        List<SalesInfo> salesInfoList=new ArrayList<>();

        try(BufferedReader bufferedReader=new BufferedReader(new FileReader(path))) {
            String line="";
            bufferedReader.readLine();
            while((line=bufferedReader.readLine())!=null)
            {

                String[] arr=line.split(",");
                System.out.println(Arrays.deepToString(arr));
                SalesInfo salesInfo;
                for(int i=0;i<arr.length-1;i++){
//                    System.out.println(str);

                    salesInfo=new SalesInfo(arr[0],arr[1],arr[2],Double.parseDouble(arr[3]),Integer.parseInt(arr[4].trim()),arr[5]);
                    salesInfoList.add(salesInfo);

                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return salesInfoList;

    }

    private void calculateAvgSalary(List<SalesInfo> salesInfoList) {
        Map<String,List<Integer>> categoryMap = new HashMap<>(Collections.emptyMap());

        for (SalesInfo salesInfo : salesInfoList) {
            if(!categoryMap.containsKey(salesInfo.getCategory())) {
                    categoryMap.put(salesInfo.getCategory(),new ArrayList<>());
            }
//            categoryMap.get(salesInfo).add(salesInfo.getPrice());
        }

    }
}
