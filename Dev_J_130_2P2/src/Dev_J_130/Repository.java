
package Dev_J_130;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Dev_J130.models.Order_positions;
import Dev_J130.models.Orders;
import Dev_J130.models.Products;


public class Repository {
    
    public List<Products> getProductsList(){
        List<Products> productsList = new ArrayList<>();
        try(Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/myDB", "Pronard", "Pronard20");  
            Statement stm = con.createStatement()) {
            ResultSet rs = stm.executeQuery("SELECT * FROM products");
            while(rs.next()){
                Products products = new Products();
                products.setArticle(rs.getString(1));
                products.setProduct_name(rs.getString(2));
                products.setProduct_color(rs.getString(3));
                products.setProduct_price(rs.getInt(4));
                products.setProduct_in_stock(rs.getInt(5)); 
                productsList.add(products);
            }           
        }
        catch(SQLException se){
            System.out.println("Произошла какая-то ошибка"); }
    return productsList;
    }    
      
    public List<Orders> getOrdersList(){
        List<Orders> ordersList = new ArrayList<>();
        try(Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/myDB", "Pronard", "Pronard20");  
            Statement stm = con.createStatement()) {
            ResultSet rs = stm.executeQuery("SELECT * FROM orders");
            while(rs.next()){
                Orders orders = new Orders();
                orders.setOrder_id(rs.getInt(1));
                orders.setOrder_date(rs.getDate(2) != null? rs.getDate(2).toLocalDate(): null);
                orders.setСustomer_name(rs.getString(3));
                orders.setСustomer_phone(rs.getString(4));
                orders.setСustomer_email(rs.getString(5)); 
                orders.setShipment_address(rs.getString(6));
                orders.setOrder_status(rs.getString(7));
                orders.setShipment_date(rs.getDate(8) != null? rs.getDate(8).toLocalDate(): null); //NullPointerExeption, если сделать напрямую.
                ordersList.add(orders);
            }           
        }
        catch(SQLException se){
            System.out.println("Произошла какая-то ошибка"); }        
        return ordersList;
    }
    
    public List<Order_positions> getOrder_positionsList(){
        List<Order_positions> orders_positionsList = new ArrayList<>();
        try(Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/myDB", "Pronard", "Pronard20");  
            Statement stm = con.createStatement()) {
            ResultSet rs = stm.executeQuery("SELECT * FROM order_positions");
            while(rs.next()){
                Order_positions ordPos = new Order_positions();
                ordPos.setOrder_cod(rs.getInt(1));
                ordPos.setProduct_article(rs.getString(2));
                ordPos.setOrder_price(rs.getInt(3)); 
                ordPos.setAmount(rs.getInt(4));
                orders_positionsList.add(ordPos);
            }           
        }
        catch(SQLException se){
            System.out.println("Произошла какая-то ошибка"); }     
        
        return orders_positionsList;
    }
}

