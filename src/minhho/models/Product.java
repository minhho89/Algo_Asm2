package minhho.models;

public class Product {

    private String code;
    private String name;
    private double unitPrice;
    private int qty;

    public Product() {
    }

    public Product(String code, String name, double unitPrice, int qty) {
        this.code = code;
        this.name = name;
        this.unitPrice = unitPrice;
        this.qty = qty;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return String.format("%s %15s %15.2f %15d", code, name, unitPrice, qty);

//        return code + " | " + name + " | " + unitPrice + " | " + qty;
    }
}
