/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Context.ConnectDB;
import model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author OS
 */
public class DAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    //    lấy ra all product2
    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<>();
        String query = "SELECT * FROM product";
        try {
            conn = new ConnectDB().getConnection();//mở kết nối với sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)
                ));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Product> get15TopProducts() {
        List<Product> list = new ArrayList<>();
        String query = "select * from demo.product\n" +
                "limit 15;";
        try {
            conn = new ConnectDB().getConnection();//mở kết nối với sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)
                ));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Product> get8LastestProducts() {
        List<Product> list = new ArrayList<>();
        String query = "select * from demo.product\n" +
                "order by id desc\n" +
                "limit 8;";
        try {
            conn = new ConnectDB().getConnection();//mở kết nối với sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)
                ));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    //    lấy ra all category
    public List<Category> getAllCategory() {
        List<Category> list = new ArrayList<>();
        String query = "SELECT * FROM demo.category;";
        try {
            conn = new ConnectDB().getConnection();//mở kết nối với sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Category(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3)
                ));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Product> getProductByCID(String cid) {
        List<Product> list = new ArrayList<>();
        String query = "select * from demo.product \n" +
                "where cate_ID = ?;";
        try {
            conn = new ConnectDB().getConnection();//mở kết nối với sql
            ps = conn.prepareStatement(query);
            ps.setString(1, cid);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)
                ));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Product> getProductBySellID(int id) {
        List<Product> list = new ArrayList<>();
        String query = "select * from demo.product\n" +
                "where sell_ID = ?;";
        try {
            conn = new ConnectDB().getConnection();//mở kết nối với sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)
                ));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public Product getProductByID(String id) {
        String query = "select * from demo.product \n" +
                "where id = ?;";
        try {
            conn = new ConnectDB().getConnection();//mở kết nối với sql
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                return new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)
                );
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public List<Product> searchByName(String txtSearch) {
        List<Product> list = new ArrayList<>();
        String query = "select * from demo.product\n" +
                "where description like ?;";
        try {
            conn = new ConnectDB().getConnection();//mở kết nối với sql
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + txtSearch + "%");
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)
                ));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    //create length page
    public int getNumberPage(int id) {
        String query = "select count(*) from demo.product where sell_ID = ?";
        try {
            conn = new ConnectDB().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                int total = rs.getInt(1);
                int countPage = 0;
                countPage = total / 10;
                if (total % 10 != 0) {
                    countPage++;
                }
                return countPage;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    //    pagination manage product of seller
    public List<Product> getPaging(int index, int id) {
        String query = "select * from demo.product \n" +
                "where sell_ID = ?\n" +
                "order by id\n" +
                "limit 10 offset ?;";

        List<Product> list = new ArrayList<>();
        try {
            conn = new ConnectDB().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.setInt(2, (index - 1) * 10);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)
                ));
            }
            return list;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    //paging 2
    public int getNumberPage2() {
        String query = "select count(*) from demo.product";
        try {
            conn = new ConnectDB().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                int total = rs.getInt(1);
                int countPage = 0;
                countPage = total / 40;
                if (total % 40 != 0) {
                    countPage++;
                }
                return countPage;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public List<Product> getPaging2(int index) {
        String query = "select * from demo.product\n" +
                "order by id\n" +
                "limit 40 offset ?";

        List<Product> list = new ArrayList<>();
        try {
            conn = new ConnectDB().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, (index - 1) * 40);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)
                ));
            }
            return list;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public Account login(String user, String pass) {
        String query = "select * from account where username=? and password=?";

        try {
            conn = new ConnectDB().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }

    public Account checkAccountExist(String user, String email, String phone) {
        String query = "select * from account where username=? or email = ? or phone = ?";

        try {
            conn = new ConnectDB().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, email);
            ps.setString(3, phone);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }

    public void signup(String name_user, String username, String password, String email, String phone) {
        String query = "insert into demo.account(name, username, password,isSell,isAdmin, email, phone) values(?,?,?,0,0,?,?);";
        try {
            conn = new ConnectDB().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name_user);
            ps.setString(2, username);
            ps.setString(3, password);
            ps.setString(4, email);
            ps.setString(5, phone);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public String findByUserName(String username) {
        String query = "select name from demo.account where username = ?";
        try {
            conn = new ConnectDB().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                return name;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    //CRUD Product
    public void deleteProduct(String pid) {
        String query = "delete from demo.product where id = ?;";
        try {
            conn = new ConnectDB().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, pid);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void addProduct(String name, String description, String costPrice, String salePrice,
                           String imgPrimary, String imgSecondary, String category, int sid) {
        String query = "insert into demo.product(name , description, cost_price, sale_price, quantity, img_primary, img_secondary, cate_ID, sell_ID)\n" +
                "values(?,?,?,?,\"1000\",?,?,?,?);";

        try {
            conn = new ConnectDB().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, description);
            ps.setString(3, costPrice);
            ps.setString(4, salePrice);
            ps.setString(5, imgPrimary);
            ps.setString(6, imgSecondary);
            ps.setString(7, category);
            ps.setInt(8, sid);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //edit product
    public void editProduct(String name, String description, String costPrice, String salePrice,
                            String imgPrimary, String imgSecondary, String category, String pid) {
        String query = "update demo.product\n" +
                "set name = ? ,\n" +
                "description = ?,\n" +
                "cost_price = ?,\n" +
                "sale_price = ?,\n" +
                "img_primary = ?,\n" +
                "img_secondary = ?,\n" +
                "cate_ID = ?\n" +
                "where id = ?;";

        try {
            conn = new ConnectDB().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, description);
            ps.setString(3, costPrice);
            ps.setString(4, salePrice);
            ps.setString(5, imgPrimary);
            ps.setString(6, imgSecondary);
            ps.setString(7, category);
            ps.setString(8, pid);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<Blog> getAllBlogs() {
        List<Blog> list = new ArrayList<>();
        String query = "SELECT * FROM demo.blog;";
        try {
            conn = new ConnectDB().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Blog(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Account> getAllAccounts() {
        List<Account> list = new ArrayList<>();
        String query = "SELECT * FROM demo.account;";
        try {
            conn = new ConnectDB().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getInt(6) != 1) {
                    list.add(new Account(rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getInt(5),
                            rs.getInt(6),
                            rs.getString(7),
                            rs.getString(8)));
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public void deleteAccount(String pid) {
        String query = "delete from demo.account where uID = ?;";
        try {
            conn = new ConnectDB().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, pid);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //edit account
    public void editAccount(String id, String name, String isSell, String email, String phone) {
        String query = "update demo.account\n" +
                "set name = ? ,\n" +
                "isSell = ?,\n" +
                "email = ?,\n" +
                "phone = ?\n" +
                "where uID = ?;";

        try {
            conn = new ConnectDB().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, isSell);
            ps.setString(3, email);
            ps.setString(4, phone);
            ps.setString(5, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Account getAccountByID(String id) {
        String query = "select * from demo.account \n" +
                "where uid = ?;";
        try {
            conn = new ConnectDB().getConnection();//mở kết nối với sql
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8)
                );
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public void addBlog(String image, String title, String description) {
        String query = "insert into demo.blog(image , title, description)\n" +
                "values(?,?,?);";

        try {
            conn = new ConnectDB().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, image);
            ps.setString(2, title);
            ps.setString(3, description);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteBlog(String pid) {
        String query = "delete from demo.blog where id = ?;";
        try {
            conn = new ConnectDB().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, pid);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // edit blog
    public void editBlog(String id, String image, String title, String description) {
        String query = "update demo.blog\n" + "set image = ? ,\n" + "title = ?,\n" + "description = ?\n"
                + "where id = ?;";

        try {
            conn = new ConnectDB().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, image);
            ps.setString(2, title);
            ps.setString(3, description);
            ps.setString(4, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Blog getBlogByID(String id) {
        String query = "select * from demo.blog \n" + "where id = ?;";
        try {
            conn = new ConnectDB().getConnection();// mở kết nối với sql
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                return new Blog(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public boolean updatePassword(String email, String newpass) throws ClassNotFoundException {
        String query = "update demo.account set password = ? where email = ?";
        try {
            conn = new ConnectDB().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, newpass);
            ps.setString(2, email);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean checkProductInOrders(int idProduct, int idUser) {
        String query = "select * from orders where idProduct = ? and idUser = ?";
        try {
            conn = new ConnectDB().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, idProduct);
            ps.setInt(2, idUser);
            rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public List<Orders> getAllOrders(int idUser) {
        List<Orders> listOrders = new ArrayList<Orders>();
        String query = "select * from orders where idUser = ?";
        DAO daoP = new DAO();
        try {
            conn = new ConnectDB().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, idUser);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product p = daoP.getProductByID(rs.getInt(2) + "");
                listOrders.add(new Orders(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        p));
            }
            return listOrders;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addOrder(int idProduct, int quantity, Double totalPrice, int idUser) {
        String query = "insert into demo.orders(idProduct, quantity, totalPrice, idUser) values (?, ?, ?, ?)";
        try {
            conn = new ConnectDB().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, idProduct);
            ps.setInt(2, quantity);
            ps.setDouble(3, totalPrice);
            ps.setInt(4, idUser);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateQuantityOrders(int quantity, int idProduct, String price, int idUser) {
        String query = "update orders set quantity = quantity + ?, totalPrice = quantity * ? where idProduct = ? and idUser = ?";
        try {
            conn = new ConnectDB().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, quantity);
            ps.setDouble(2, Double.parseDouble(price.replace(",", "")));
            ps.setInt(3, idProduct);
            ps.setInt(4, idUser);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteProductOrders(String pid, int idUser) {
        String query = "delete from demo.orders where idProduct = ? and idUser = ?;";
        try {
            conn = new ConnectDB().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, pid);
            ps.setInt(2, idUser);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateSubNumber(String pid) {
        String query = "UPDATE orders\n" +
                "JOIN product ON orders.idProduct = product.id\n" +
                "SET\n" +
                "    orders.quantity = CASE\n" +
                "        WHEN orders.quantity > 1 THEN orders.quantity - 1\n" +
                "        ELSE orders.quantity\n" +
                "    END,\n" +
                "    orders.totalPrice = CASE\n" +
                "        WHEN orders.quantity > 1 THEN (orders.quantity - 1) * CAST(REPLACE(product.sale_price, ',', '') AS DECIMAL(10,2))\n" +
                "        ELSE orders.totalPrice\n" +
                "    END\n" +
                "WHERE \n" +
                "    orders.idProduct = ?;";
        try {
            conn = new ConnectDB().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, pid);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateAddNumber(String pid) {
        String query = "UPDATE orders\n" +
                "JOIN product ON orders.idProduct = product.id\n" +
                "SET\n" +
                "    orders.quantity = orders.quantity + 1,\n" +
                "    orders.totalPrice = (orders.quantity + 1) * CAST(REPLACE(product.sale_price, ',', '') AS DECIMAL(10,2))\n" +
                "WHERE \n" +
                "\torders.idProduct = ?;";
        try {
            conn = new ConnectDB().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, pid);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Product getNamePro(int idProduct) {
        String query = "select * from demo.product where id = ?";
        Product row = null;
        try {
            conn = new ConnectDB().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, idProduct);
            rs = ps.executeQuery();
            while (rs.next()) {
                row = new Product();
                row.setId(rs.getInt("id"));
                row.setName(rs.getString("name"));
                row.setDescription(rs.getString("description"));
                row.setCostPrice(rs.getString("cost_price"));
                row.setSalePrice(rs.getString("sale_price"));
                row.setQuantity(rs.getString("quantity"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return row;
    }

    public int ChangeInt(String a) {
        int sum = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != '.') {
                sum = sum * 10 + (a.charAt(i) - 48);
            }
        }
        return sum;
    }

    public List getAllProductByCode(String bill) {
        List<Order_History> list = new ArrayList<>();
        String query = "select * from demo.orders_history where bill_code = ?";

        try {
            conn = new ConnectDB().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, bill);
            rs = ps.executeQuery();
            while (rs.next()) {
                Order_History order = new Order_History();
                order.setP_id(rs.getInt("p_id"));
                order.setU_id(rs.getInt("u_id"));
                order.setO_quantity(rs.getInt("o_quantity"));
                order.setTotalPrice(rs.getString("totalPrice"));
                order.setDate(rs.getString("o_date"));
                order.setBill_code(rs.getString("bill_code"));
                list.add(order);

            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteCart_Product(int pid, int idUser) {
        String query = "delete from demo.orders where idProduct = ? and idUser = ?;";
        try {
            conn = new ConnectDB().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, pid);
            ps.setInt(2, idUser);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean insertOrder_History(Order_History model) {
        boolean result = false;

        try {
            conn = new ConnectDB().getConnection();
            String query = "insert into demo.orders_history (p_id, u_id, o_quantity,totalPrice,o_date,bill_code) values(?,?,?,?,?,?)";
            ps = conn.prepareStatement(query);
            ps.setInt(1, model.getP_id());
            ps.setInt(2, model.getU_id());
            ps.setInt(3, model.getO_quantity());
            ps.setString(4, model.getTotalPrice());
            ps.setString(5, model.getDate());
            ps.setString(6, model.getBill_code());
            ps.executeUpdate();
            result = true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public List<Order_History> getAllOrder_History(int id_user) {
        List<Order_History> list = new ArrayList<>();
        String query = "select * from demo.orders_history where u_id = ?";

        try {
            conn = new ConnectDB().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id_user);
            rs = ps.executeQuery();
            while (rs.next()) {

                Order_History order = new Order_History();
                order.setP_id(rs.getInt("p_id"));
                order.setU_id(rs.getInt("u_id"));
                order.setO_quantity(rs.getInt("o_quantity"));
                order.setTotalPrice(rs.getString("totalPrice"));
                order.setDate(rs.getString("o_date"));
                order.setBill_code(rs.getString("bill_code"));
                list.add(order);

            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
