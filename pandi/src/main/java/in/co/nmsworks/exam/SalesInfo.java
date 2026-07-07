package in.co.nmsworks.exam;

import java.util.Date;

public class SalesInfo {
    private String sales_id;
    private String product_name;
    private String category;
    private double price;
    private int itemsSold;
    private String date;

    public SalesInfo(String sales_id, String product_name, String category, double price, int itemsSold, String date) {
        this.sales_id = sales_id;
        this.product_name = product_name;
        this.category = category;
        this.price = price;
        this.itemsSold = itemsSold;
        this.date = date;
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

    public int getItemsSold() {
        return itemsSold;
    }

    public void setItemsSold(int itemsSold) {
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
                "sales_id='" + sales_id + '\'' +
                ", product_name='" + product_name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", itemsSold=" + itemsSold +
                ", date=" + date +
                '}';
    }
}
