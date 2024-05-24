package model;

public class Category {
    private int cid;
    private String cname;
    private String image;

    public Category() {
    }

    public Category(int cid, String cname, String image) {
        this.cid = cid;
        this.cname = cname;
        this.image = image;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Category{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
} 
