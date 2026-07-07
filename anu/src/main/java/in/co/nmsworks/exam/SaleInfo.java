package in.co.nmsworks.exam;

public class SaleInfo {
    private  String sales_id;
    private String product_name;
    private String category;
    private double price;
    private String items_sold;
    private String month;

    public SaleInfo(String sales_id, String product_name, String category, double price, String items_sold, String month) {
        this.sales_id = sales_id;
        this.product_name = product_name;
        this.category = category;
        this.price = price;
        this.items_sold = items_sold;
        this.month = month;
    }

    public String getSales_id() {
        return sales_id;
    }

    public void setSales_id(String sales_id) {
        this.sales_id = sales_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
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

    public String getItems_sold() {
        return items_sold;
    }

    public void setItems_sold(String items_sold) {
        this.items_sold = items_sold;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    @Override
    public String toString() {
        return "SaleInfo{" +
                "sales_id='" + sales_id + '\'' +
                ", product_name='" + product_name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", items_sold=" + items_sold +
                ", month='" + month + '\'' +
                '}';
    }
}
