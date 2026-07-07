package in.co.nmsworks.Exam;

import java.time.LocalDate;

public class SaleInfo {
    private String salesId;
    private String productName;
    private String category;
    private double price;
    private int itemsSold;
    private LocalDate saleDate;

    public SaleInfo(String salesId, String productName, String category, double price, int itemsSold, LocalDate saleDate) {
        this.salesId = salesId;
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.itemsSold = itemsSold;
        this.saleDate = saleDate;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getItemsSold() {
        return itemsSold;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }

    public double getTotalRevenue() {
        return this.price * this.itemsSold;
    }

    public String getMonthKey() {
        if (saleDate == null) return "";
        return saleDate.getYear() + "-" + String.format("%02d", saleDate.getMonthValue());
    }

    @Override
    public String toString() {
        return "SaleInfo{" +
                "salesId='" + salesId + '\'' +
                ", productName='" + productName + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", itemsSold=" + itemsSold +
                ", saleDate=" + saleDate +
                '}';
    }
}