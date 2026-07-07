package in.co.nmsworks.exam.question3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SalesMain {

    public static void main(String[] args) {
        List<SaleInfo> list = new ArrayList<>();
        SalesMain sales = new SalesMain();
        list = sales.readFile();
        Map<String,Integer> categoryFilter = sales.printAveragePrice(list);
    }


    private Map<String, Integer> printAveragePrice(List<SaleInfo> list) {

        Map<String, Integer> categoryFilter = new HashMap<>();
        for (SaleInfo sale : list) {

            String category = sale.getCategory();
            categoryFilter.putIfAbsent(category,0);
        }

      for (Map.Entry<String,Integer> entry : categoryFilter.entrySet())
      {
          String category = entry.getKey();
          int sum = 0;
          int count = 0;
          for (int i = 0; i < list.size(); i++)
          {
              if(category.equals(list.get(i).getCategory())) {
                  sum += list.get(i).getPrice();
                  count++;
              }
          }
          int average = sum/count;
          System.out.println(average);
          entry.setValue(average);
      }

      return categoryFilter;
    }

    private List<SaleInfo> readFile() {

        List<SaleInfo> list = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader("/home/nms-training/Downloads/Exam_2026/SALES_DATA.csv"));)
        {
            String line = "";
            while((line = br.readLine()) != null)
            {
               String split[] = line.split(",");
               int count = 0;
                SaleInfo info = new SaleInfo();
                for (String s : split) {
                    count++;
                    if(count == 1)
                    {
                        info.setSalesId(s);
                    }
                    if (count == 2)
                    {
                        info.setProductName(s);
                    }
                    if (count == 3)
                    {
                        info.setCategory(s);
                    }
                    if (count == 4)
                    {
                        double price = Double.parseDouble(s);
                        info.setPrice(price);
                    }
                    if (count == 5)
                    {
                        String str = s.trim();
                        int sold = Integer.parseInt(str);
                        info.setItemsSold(sold);
                    }
                    if (count == 6)
                    {
                          info.setSaleDate(s);
                    }
                }
                list.add(info);
            }
        }

        catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
