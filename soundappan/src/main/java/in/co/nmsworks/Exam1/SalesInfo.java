package in.co.nmsworks.Exam1;

import java.util.Objects;

public class SalesInfo {
    public String getSale_id() {
        return sale_id;
    }

    public void setSale_id(String sale_id) {
        this.sale_id = sale_id;
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

    public int getItem_sold() {
        return item_sold;
    }

    public void setItem_sold(int item_sold) {
        this.item_sold = item_sold;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public SalesInfo(String sale_id, String product_name, String category, double price, int item_sold, String date) {
        this.sale_id = sale_id;
        this.product_name = product_name;
        this.category = category;
        this.price = price;
        this.item_sold = item_sold;
        this.date = date;
    }

    private String sale_id;
    private String product_name;
    private String category;
    private double price;
    private int item_sold;
    private String date;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SalesInfo salesInfo = (SalesInfo) o;
        return Double.compare(price, salesInfo.price) == 0 && item_sold == salesInfo.item_sold && Objects.equals(sale_id, salesInfo.sale_id) && Objects.equals(product_name, salesInfo.product_name) && Objects.equals(category, salesInfo.category) && Objects.equals(date, salesInfo.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sale_id, product_name, category, price, item_sold, date);
    }
}
