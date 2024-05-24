package model;

public class Order_History {
    private int p_id;

    private int u_id;
    private int o_quantity;
    private String totalPrice;
    private String bill_code;
    private String date;


    public Order_History(){

    }
    public Order_History(int p_id, int u_id, int o_quantity, String totalPrice, String o_date, String bill_code){
        this.p_id=p_id;

        this.u_id=u_id;
        this.o_quantity=o_quantity;
        this.totalPrice=totalPrice;
        this.date=o_date;
        this.bill_code=bill_code;
    }
    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public int getO_quantity() {
        return o_quantity;
    }

    public void setO_quantity(int o_quantity) {
        this.o_quantity = o_quantity;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getBill_code() {
        return bill_code;
    }

    public void setBill_code(String bill_code) {
        this.bill_code = bill_code;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    @Override
    public String toString() {
        return "Order_History{" +
                "p_id=" + p_id +
                ", u_id=" + u_id +
                ", o_quantity=" + o_quantity +
                ", totalPrice='" + totalPrice + '\'' +
                ", bill_code='" + bill_code + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
} 
