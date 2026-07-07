package in.co.nmsworks.exam;

public class SaleInfo {
    private String id;
    private String productName;
    private String category;
    private Double price;
    private Integer soldCount;
    private String saleDate;

    public SaleInfo() {
    }

    public SaleInfo(String id, String productName, String category, Double price, Integer soldCount, String saleDate) {
        this.id = id;
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.soldCount = soldCount;
        this.saleDate = saleDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getSoldCount() {
        return soldCount;
    }

    public void setSoldCount(Integer soldCount) {
        this.soldCount = soldCount;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    @Override
    public String toString() {
        return "SaleInfo{" +
                "id='" + id + '\'' +
                ", productName='" + productName + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", soldCount=" + soldCount +
                ", saleDate='" + saleDate + '\'' +
                '}';
    }
}
