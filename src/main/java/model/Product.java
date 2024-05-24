package model;

public class Product {
    private int id;
    private String name;
    private String description;
    private String costPrice;
    private String salePrice;
    private String quantity;
    private String img_primary;
    private String img_second;

    public Product() {
    }

    public Product(int id, String name, String description, String costPrice, String salePrice, String quantity, String img_primary, String img_second) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.costPrice = costPrice;
        this.salePrice = salePrice;
        this.quantity = quantity;
        this.img_primary = img_primary;
        this.img_second = img_second;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(String costPrice) {
        this.costPrice = costPrice;
    }

    public String getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(String salePrice) {
        this.salePrice = salePrice;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getImg_primary() {
        return img_primary;
    }

    public void setImg_primary(String img_primary) {
        this.img_primary = img_primary;
    }

    public String getImg_second() {
        return img_second;
    }

    public void setImg_second(String img_second) {
        this.img_second = img_second;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", costPrice='" + costPrice + '\'' +
                ", salePrice='" + salePrice + '\'' +
                ", quantity='" + quantity + '\'' +
                ", img_primary='" + img_primary + '\'' +
                ", img_second='" + img_second + '\'' +
                '}';
    }
} 
