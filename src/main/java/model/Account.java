package model;

public class Account {
    private int id;
    private String name;
    private String username;
    private String password;
    private String email;
    private String phone;
    private int isSell;
    private int isAdmin;


    public Account() {
    }

    public Account(int id, String name, String username, String password, int isSell, int isAdmin, String email, String phone) {
        super();
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.isSell = isSell;
        this.isAdmin = isAdmin;
        this.email = email;
        this.phone = phone;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIsSell() {
        return isSell;
    }

    public void setIsSell(int isSell) {
        this.isSell = isSell;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Account [id=" + id + ", "
                + "name=" + name + ", "
                + "username=" + username + ", "
                + "password=" + password + ", "
                + "email= " + email + ", "
                + "phone=" + phone + ", "
                + "isSell=" + isSell + ", "
                + "isAdmin=" + isAdmin + "]";
    }
} 
