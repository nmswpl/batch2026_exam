package in.co.nmsworks.exam.sales;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class SalesRunner {

    static class Pair{
        double values;
        String month;

        public Pair(double values, String month) {
            this.values = values;
            this.month = month;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "values=" + values +
                    ", month='" + month + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        SalesRunner runner = new SalesRunner();
        List<SaleInfo> list = runner.getSalesList();
        for(SaleInfo sale : list){
            System.out.println(sale);
        }

        Map<String, List<SaleInfo>> map = runner.getCategory(list);
        //runner.calculateAveragePrice(map);

        Map<String , List<SaleInfo>> monthWise = runner.getMonth(list);
//        for(Map.Entry<String , List<SaleInfo>> e : monthWise.entrySet()){
//            System.out.println( e.getKey() + " " + e.getValue());
//        }

        runner.SaleInfoOfHighestSoldProduct(monthWise);

    }

    private void SaleInfoOfHighestSoldProduct(Map<String, List<SaleInfo>> monthWise) {

        PriorityQueue<Pair> queue = new PriorityQueue<>(
                (a,b)-> Double.compare(b.values,a.values)
        );

        for(Map.Entry<String , List<SaleInfo>> month : monthWise.entrySet()){
            double sum = 0;
            for(SaleInfo saleInfo : month.getValue()){
                sum = sum + saleInfo.getPrice() * saleInfo.getItems_sold();
            }
            queue.offer(new Pair(sum , month.getKey()));
        }

        assert queue.peek() != null;
        System.out.printf("Highest sales of the month : %s%n", queue.peek().month);
        assert queue.peek() != null;
        System.out.println("Highest sales price sum : " + Math.round(queue.peek().values));

    }

    private Map<String, List<SaleInfo>> getMonth(List<SaleInfo> list) {
        Map<String , List<SaleInfo>> monthWise = new HashMap<>();

        for(SaleInfo saleInfo : list){
            monthWise.putIfAbsent(saleInfo.getSale_date().substring(4), new ArrayList<>());
            monthWise.get(saleInfo.getSale_date().substring(4)).add(saleInfo);
        }

        return monthWise;
    }

    private void calculateAveragePrice(Map<String, List<SaleInfo>> map) {

         float average = 0;

         for(Map.Entry<String, List<SaleInfo>> pair : map.entrySet()){

             System.out.println("average of " + pair.getKey().replace("-",""));
             int count  = 0;
             for(SaleInfo saleInfo : pair.getValue()){
                 average = average + saleInfo.getPrice();
                 count++;
             }
             System.out.println("average price : " + average/count);

         }


    }

    private Map<String, List<SaleInfo>> getCategory(List<SaleInfo> list) {
        Map<String, List<SaleInfo>> map = new HashMap<>();

        for(SaleInfo saleInfo : list){
            map.putIfAbsent(saleInfo.getCategory(), new ArrayList<>());
            map.get(saleInfo.getCategory()).add(saleInfo);
        }

        return map;
    }

    private List<SaleInfo> getSalesList() {
        List<SaleInfo> list = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("/home/nms-training/Downloads/Exam_2026/SALES_DATA.csv")))
        {
            String line;

            bufferedReader.readLine();
            while((line = bufferedReader.readLine())!= null){
                String[] elements = line.split(",");

                String date = elements[5];

                list.add(new SaleInfo(elements[0].trim(),
                        elements[1].trim(),
                        elements[2].trim(),
                        Float.parseFloat(elements[3].trim()),
                        Integer.parseInt(elements[4].trim()),
                        elements[5]
                        ));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return list;
    }


}
