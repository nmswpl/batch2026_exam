package in.co.nmsworks.exam;

public class SaleInfo {
    private String id;
    private String product_name;
    private String category;
    private float price;
    private int items_sold;
    private String sale_date;

    public SaleInfo(String id, String product_name, String category, float price, int items_sold, String sale_date) {
        this.id = id;
        this.product_name = product_name;
        this.category = category;
        this.price = price;
        this.items_sold = items_sold;
        this.sale_date = sale_date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public void setPrice(float price) {
        this.price = price;
    }

    public int getItems_sold() {
        return items_sold;
    }

    public void setItems_sold(int items_sold) {
        this.items_sold = items_sold;
    }

    public String getSale_date() {
        return sale_date;
    }

    public void setSale_date(String sale_date) {
        this.sale_date = sale_date;
    }

    @Override
    public String toString() {
        return "SaleInfo{" +
                "id='" + id + '\'' +
                ", product_name='" + product_name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", items_sold=" + items_sold +
                ", sale_date='" + sale_date + '\'' +
                '}';
    }
}
