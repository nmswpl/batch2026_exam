package in.co.nmsworks.exam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;


public class SalesInfo {
    Set<String> categorySet = new LinkedHashSet<>();
    List<SalesDetails> details = new ArrayList<>();
    Map<String, Set<Double>> map = new HashMap<>();
    public static void main(String[] args) {
        SalesInfo runner = new SalesInfo();
        double sum = 0;
        Map<String, Set<Double>> priceMap = runner.getData();
        for (String s : runner.categorySet) {
            Set<Double> eachPrice = priceMap.get(s);
            for (Double value : eachPrice) {
                sum += value;
                System.out.println("Category :: " + s + " Average :: " + (double)sum/ eachPrice.size());
            }
        }
        System.out.println(runner.categorySet);
    }

    private Map<String, Set<Double>> getData() {
        try(BufferedReader reader = new BufferedReader(new FileReader("/home/nms-training/Downloads/Exam_2026/SALES_DATA.csv"))){
            String line = "";
            String text = "";
            reader.readLine();
            while((line = reader.readLine()) != null){
                String[] array = line.split(",");
                SalesDetails sales = new SalesDetails(array[0],array[1],array[2],Double.parseDouble(array[3].trim()),Integer.parseInt(array[4].trim()),array[5]);
                details.add(sales);
                categorySet.add(array[2]);
                Set<Double> list = map.getOrDefault(array[2],new HashSet<>());
                list.add(Double.parseDouble(array[3].trim()));
                map.put(array[2],list);
                text+=line;
            }
            return map;
    } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    }
