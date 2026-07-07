package in.co.nmsworks.exam;

public class SalesInfo {

    String id;

    String name;
    String category;
    float price;
    int noOfItem;
    String date;

    public SalesInfo(String id, String name, String category, float price, int noOfItem, String date) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.noOfItem = noOfItem;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getNoOfItem() {
        return noOfItem;
    }

    public void setNoOfItem(int noOfItem) {
        this.noOfItem = noOfItem;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
