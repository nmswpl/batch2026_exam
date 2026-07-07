package in.co.nmsworks.exam;

public class SaleInfo {
    private Long sales_id;
    private String productName;
    private String category;
    private Double price;
    private Integer itemSold;
    private Long date;

    public SaleInfo(String string, String s, String string1, String s1, String string2, String s2) {
    }

    public SaleInfo(Long sales_id, String productName, String category, Double price, Integer itemSold, Long date) {
        this.sales_id = sales_id;
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.itemSold = itemSold;
        this.date = date;
    }

    public Long getSales_id() {
        return sales_id;
    }

    public void setSales_id(Long sales_id) {
        this.sales_id = sales_id;
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

    public Integer getItemSold() {
        return itemSold;
    }

    public void setItemSold(Integer itemSold) {
        this.itemSold = itemSold;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "SaleInfo{" +
                "sales_id=" + sales_id +
                ", productName='" + productName + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", itemSold=" + itemSold +
                ", date=" + date +
                '}';
    }
}
