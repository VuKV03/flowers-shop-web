package model;

public class Orders {
    private int id;
    private int idProduct;
    private int quantity;
    private String totalPrice;
    private int idUser;
    
    private Product product;
    public Orders() {
        super();
    }


    public Orders(int id, int idProduct, int quantity, String totalPrice, int idUser) {
        this.id = id;
        this.idProduct = idProduct;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.idUser = idUser;
    }


	public Orders(int id, int idProduct, int quantity, String totalPrice, Product product) {
        this.id = id;
        this.idProduct = idProduct;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", idProduct=" + idProduct +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                '}';
    }
} 
