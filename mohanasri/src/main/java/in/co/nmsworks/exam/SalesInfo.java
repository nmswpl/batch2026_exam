package in.co.nmsworks.exam;
public class SalesInfo {
    private String date;
    private String month;
    private String category;
    private String productName;
    private int itemsSold;
    private double price;

    public SalesInfo(String date, String category, String productName, int itemsSold, double price) {
        this.date = date;
        this.category = category;
        this.productName = productName;
        this.itemsSold = itemsSold;
        this.price = price;
        this.month = date.contains("-") ? date.split("-")[1] : date.split("/")[1];
    }

    public String getCategory() { return category; }
    public String getMonth() { return month; }
    public String getProductName() { return productName; }
    public int getItemsSold() { return itemsSold; }
    public double getPrice() { return price; }
    public double getTotalSales() { return itemsSold * price; }

    @Override
    public String toString() {
        return "Product: " + productName + " | Total Revenue: " + getTotalSales();
    }
}
