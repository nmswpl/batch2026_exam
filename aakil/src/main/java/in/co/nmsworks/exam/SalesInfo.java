package in.co.nmsworks.exam;

public class SalesInfo {
    private String id;
    private String name;
    private String category;
    private double price;
    private int itemsSold;
    private int saleDay;
    private int saleMonth;
    private int saleYear;

    public SalesInfo() {
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

    public int getItemsSold() {
        return itemsSold;
    }

    public void setItemsSold(int itemsSold) {
        this.itemsSold = itemsSold;
    }

    public int getSaleDay() {
        return saleDay;
    }

    public void setSaleDay(int saleDay) {
        this.saleDay = saleDay;
    }

    public int getSaleMonth() {
        return saleMonth;
    }

    public void setSaleMonth(int saleMonth) {
        this.saleMonth = saleMonth;
    }

    public int getSaleYear() {
        return saleYear;
    }

    public void setSaleYear(int saleYear) {
        this.saleYear = saleYear;
    }

    public double getPriceSold(){
        return getPrice() * getItemsSold();
    }

    @Override
    public String toString() {
        return "SalesInfo{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", category='" + getCategory() + '\'' +
                ", price=" + getPrice() +
                ", itemsSold=" + getItemsSold() +
                ", saleDate=" + getSaleDay() +
                "-" + getSaleMonth() +
                "-" + getSaleYear() + "  }";
    }
}
