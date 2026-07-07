package in.co.nmsworks.exam;

public class SalesInfo {
    private String salesInd;
    private String productName;
    private String category;
    private Double price;
    private Integer itemsSold;
    private String date;

    public SalesInfo() {
    }

    public SalesInfo(String salesInd, String productName, String category, Double price, Integer itemsSold, String date) {
        this.salesInd = salesInd;
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.itemsSold = itemsSold;
        this.date = date;
    }

    public String getSalesInd() {
        return salesInd;
    }

    public void setSalesInd(String salesInd) {
        this.salesInd = salesInd;
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

    public Integer getItemsSold() {
        return itemsSold;
    }

    public void setItemsSold(Integer itemsSold) {
        this.itemsSold = itemsSold;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "SalesInfo{" +
                "salesInd='" + salesInd + '\'' +
                ", productName='" + productName + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", itemsSold=" + itemsSold +
                ", date='" + date + '\'' +
                '}';
    }
}
