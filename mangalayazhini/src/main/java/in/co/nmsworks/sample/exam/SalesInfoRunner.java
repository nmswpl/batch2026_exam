package in.co.nmsworks.sample.exam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class SalesInfoRunner {
    public static void main(String[] args) {
        SalesInfoRunner runnerObj = new SalesInfoRunner();
        List<SalesInfo> salesInfoList = runnerObj.salesFileParser("/home/nms-training/Downloads/Exam_2026/SALES_DATA.csv");
//        for (SalesInfo salesInfo : salesInfoList) {
//            System.out.println(salesInfo.getSales_id() + " " + salesInfo.getProduct_name() + " " +
//                    salesInfo.getCategory() + " " + salesInfo.getPrice() + " " + salesInfo.getItemsSold() + " " +
//                    salesInfo.getSaleDate());
//        }



        Set<String> categorySet = runnerObj.findCategories(salesInfoList);

        Map<String,Double> categoryAvgSalesMap = runnerObj.calculateAvgPriceInCategory(salesInfoList, categorySet);

        System.out.println("\nAverage Price of each Category : ");
        for (String category : categoryAvgSalesMap.keySet()) {
            System.out.println(category + " : " + categoryAvgSalesMap.get(category));
        }


        Set<String> productSet = runnerObj.findProducts(salesInfoList);

        Map<String,Double> productTotalSalesMap = runnerObj.totalSalesCostOfEachProduct(salesInfoList,productSet);

        System.out.println("\n\nEach product total sales cost : ");
        for (String product : productTotalSalesMap.keySet()) {
            System.out.println(product + " : " + productTotalSalesMap.get(product));
        }


    }

    public Map<String, Double> totalSalesCostOfEachProduct(List<SalesInfo> salesInfoList , Set<String> productSet){
        Map<String,Double> productTotalSalesMap = new HashMap();
        for (String product : productSet) {
            Double totalCost = 0.0 ;
            for (SalesInfo salesInfo : salesInfoList) {
                if(product.equals(salesInfo.getProduct_name())){
                    totalCost += (salesInfo.getPrice() * salesInfo.getItemsSold());
                }
            }
            productTotalSalesMap.put(product,totalCost);

        }

//        System.out.println("Product Mapping : ");
//        for (String product : productTotalSalesMap.keySet()) {
//            System.out.println(product + " : " + productTotalSalesMap.get(product));
//        }
        return productTotalSalesMap;
    }
    public Map<String,Double> calculateAvgPriceInCategory(List<SalesInfo> salesInfoList , Set<String> categorySet){

        Map<String,Double> categoryAvgSalesMap = new HashMap();
        for (String category : categorySet) {
            Double sum = 0.0 ;
            Integer noOfProducts = 0 ;
            for (SalesInfo salesInfo : salesInfoList) {
                if(category.equals(salesInfo.getCategory())){
                    sum += salesInfo.getPrice();
                    noOfProducts++;
                }
            }

            Double avgSales = sum/noOfProducts;
            categoryAvgSalesMap.put(category,avgSales);
        }

        return categoryAvgSalesMap;
    }

    public Set<String> findProducts(List<SalesInfo> salesInfoList ){

        Set<String> productSet = new HashSet<>();

        for (SalesInfo salesInfo : salesInfoList) {
            productSet.add(salesInfo.getProduct_name());
        }

//        System.out.println("\n\nProducts : ");
//        for (String product : productSet) {
//            System.out.print(product + ", ");
//        }

        return productSet;
    }

    public Set<String> findCategories(List<SalesInfo> salesInfoList ){
        Set<String> categorySet = new HashSet<>();

        for (SalesInfo salesInfo : salesInfoList) {
//            System.out.println(salesInfo.getSales_id() + " " + salesInfo.getProduct_name() + " " +
//                    salesInfo.getCategory() + " " + salesInfo.getPrice() + " " + salesInfo.getItemsSold() + " " +
//                    salesInfo.getSaleDate());
            categorySet.add(salesInfo.getCategory());
        }


//        System.out.println("Categories : ");
//        for (String category : categorySet) {
//            System.out.print(category + ", ");
//        }
        return categorySet;
    }

    public List<SalesInfo> salesFileParser(String path){
        List<SalesInfo> salesInfoList = new ArrayList<>();

        try(BufferedReader readerObj = new BufferedReader(new FileReader(path))) {

            while((readerObj.readLine() != null)){
                String productSalesReport = readerObj.readLine();
                if(productSalesReport != null) {
                    String[] salesReportArr = productSalesReport.split(",");

                    salesInfoList.add(new SalesInfo(
                            salesReportArr[0],
                            salesReportArr[1],
                            salesReportArr[2],
                            Double.valueOf(salesReportArr[3]),
                            Integer.valueOf(salesReportArr[4].trim()),
                            salesReportArr[5]
                    ));
                }
//                System.out.println(readerObj.readLine());
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return salesInfoList;

    }
}
