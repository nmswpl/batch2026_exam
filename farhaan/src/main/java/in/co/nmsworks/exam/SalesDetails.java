package in.co.nmsworks.exam;

public class SalesDetails {
    private String id;
    private String name;
    private String category;
    private double price;
    private Integer itemSold;
    private String date;

    public SalesDetails(String id, String name, String category, double price, int itemSold, String date) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.itemSold = itemSold;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
