package in.co.nmsworks.exam;

public class Sales {
    private String salesId;
    private String productName;
    private String category;
    private double price;
    private int itemSold;
    private String saleDate;

    public Sales(String salesId, String productName, String category, double price, int itemSold, String saleDate) {
        this.salesId = salesId;
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.itemSold = itemSold;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getItemSold() {
        return itemSold;
    }

    public void setItemSold(int itemSold) {
        this.itemSold = itemSold;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    @Override
    public String toString() {
        return "Sales{" +
                "salesId='" + salesId + '\'' +
                ", productName='" + productName + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", itemSold=" + itemSold +
                ", saleDate='" + saleDate + '\'' +
                '}';
    }
}
