package in.co.nmsworks.exam;

import java.util.Objects;

public class SaleInfo {
    private String salesId;
    private String productName;
    private String category;
    private String price;
    private String itemsSold;
    private String saleDate;

    public SaleInfo() {
    }

    public SaleInfo(String salesId, String productName, String category, String price, String itemsSold, String saleDate) {
        this.salesId = salesId;
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.itemsSold = itemsSold;
        this.saleDate = saleDate;
    }

    public String getSalesId() {
        return salesId;
    }

    public void setSalesId(String salesId) {
        this.salesId = salesId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getItemsSold() {
        return itemsSold;
    }

    public void setItemsSold(String itemsSold) {
        this.itemsSold = itemsSold;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SaleInfo saleInfo = (SaleInfo) o;
        return Objects.equals(salesId, saleInfo.salesId) && Objects.equals(productName, saleInfo.productName) && Objects.equals(category, saleInfo.category) && Objects.equals(price, saleInfo.price) && Objects.equals(itemsSold, saleInfo.itemsSold) && Objects.equals(saleDate, saleInfo.saleDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(salesId, productName, category, price, itemsSold, saleDate);
    }

    @Override
    public String toString() {
        return "SaleInfo{" +
                "salesId='" + salesId + '\'' +
                ", productName='" + productName + '\'' +
                ", category='" + category + '\'' +
                ", price='" + price + '\'' +
                ", itemsSold='" + itemsSold + '\'' +
                ", saleDate='" + saleDate + '\'' +
                '}';
    }
}
