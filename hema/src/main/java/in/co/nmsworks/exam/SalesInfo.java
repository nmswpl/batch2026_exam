package in.co.nmsworks.exam;

public class SalesInfo {
    private String salesId;
    private String productName;
    private String category;
    private float price;
    private int itemsSold;
    private String saleDate;

    public SalesInfo(String salesId, String productName, String category, float price, int itemsSold, String saleDate) {
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getItemsSold() {
        return itemsSold;
    }

    public void setItemsSold(int itemsSold) {
        this.itemsSold = itemsSold;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    @Override
    public String toString() {
        return "SalesInfo{" +
                "salesId='" + salesId + '\'' +
                ", productName='" + productName + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", itemsSold=" + itemsSold +
                ", saleDate='" + saleDate + '\'' +
                '}';
    }
}
