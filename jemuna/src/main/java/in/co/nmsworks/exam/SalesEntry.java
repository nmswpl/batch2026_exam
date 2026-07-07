package in.co.nmsworks.exam;


public class SalesEntry {
    String sales_id;
    String product_name;
    String category;
    int price;
    float items_sold;
    String date;

    public SalesEntry(String sales_id, String product_name, String category, int price, float items_sold, String date) {
        this.sales_id = sales_id;
        this.product_name = product_name;
        this.category = category;
        this.price = price;
        this.items_sold = items_sold;
        this.date = date;
    }

    public SalesEntry() {
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

    public float getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public float getItems_sold() {
        return items_sold;
    }

    public void setItems_sold(float items_sold) {
        this.items_sold = items_sold;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
