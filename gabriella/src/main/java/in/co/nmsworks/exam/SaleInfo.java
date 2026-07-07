package in.co.nmsworks.exam;

public class SaleInfo {
    private String salesId;
    private String productName;
    private String category;
    private Float price;
    private Integer itemsSold;
    private String saleData;

    public SaleInfo() {
    }

    public SaleInfo(String salesId, String productName, String category, Float price, Integer itemsSold, String saleData) {
        this.salesId = salesId;
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.itemsSold = itemsSold;
        this.saleData = saleData;
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

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getItemsSold() {
        return itemsSold;
    }

    public void setItemsSold(Integer itemsSold) {
        this.itemsSold = itemsSold;
    }

    public String getSaleData() {
        return saleData;
    }

    public void setSaleData(String saleData) {
        this.saleData = saleData;
    }

    @Override
    public String toString() {
        return "SaleInfo{" +
                "salesId='" + salesId + '\'' +
                ", productName='" + productName + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", itemsSold=" + itemsSold +
                ", saleData='" + saleData + '\'' +
                '}';
    }
}
