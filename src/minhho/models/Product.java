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

    @Override
    public String toString() {
        return "Product:" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", unitPrice=" + unitPrice +
                ", qty=" + qty;
    }
}
