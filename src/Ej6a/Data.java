package Ej6a;

import java.util.LinkedList;
import java.sql.*;

public class Data {

	public static void main(String args[]) {

	}
	
	public static void driver() {
		try {
		    Connection conn = DriverManager.getConnection(
		        "jdbc:mysql://localhost/javaMarket",
		        "root",
		        "root"
		    );
		} catch (SQLException e) {
		    e.printStackTrace();}
		}
	
	public static LinkedList<Product> list(){
		
		LinkedList<Product> products = new LinkedList<>();
		try {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/javaMarket","root","root");
		
		Statement state = conn.createStatement();
		ResultSet result = state.executeQuery("SELECT * FROM product");
		
		while (result.next()) {
			Product prod = new Product();
			
			prod.setId(result.getInt("id"));
			prod.setName(result.getString("name"));
			prod.setPrice(result.getDouble("price"));
			products.offer(prod);
		}
		
		if (result!=null)result.close();
		if (state!=null)state.close();
		conn.close();
		
		return products;
		}
		catch (SQLException exc){
			System.out.println("SQLException: "+ exc.getMessage());
			LinkedList<Product> emptyprodlist = new LinkedList<>();
			return emptyprodlist;
		}
	}
	
	public static Product search(int id) {
		
		Product prod = new Product();
		try {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/javaMarket","root","root");
		
		PreparedStatement state = conn.prepareStatement("Select * from product where id=?");
		
		state.setInt(1, id);
		ResultSet result = state.executeQuery();
		if (result.next()) {
		prod.setId(result.getInt("id"));
		prod.setName(result.getString("name"));
		prod.setDescription(result.getString("description"));
		prod.setPrice(result.getDouble("price"));
		prod.setStock(result.getInt("stock"));
		prod.setShippingIncluded(result.getBoolean("shippingIncluded"));
		}
		if (result!=null)result.close();
		if (state!=null)state.close();
		conn.close();
		
		return prod;
		}
		catch (SQLException exc){
			System.out.println("SQLException: "+ exc.getMessage());
			System.out.println("Product not found");
			Product emptyprod = new Product();
			return emptyprod;
		}
	}
	
	public static int neww(Product p) {
		try {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/javaMarket","root","root");
		
        PreparedStatement pState = conn.prepareStatement(
        		"insert into product(name,description,price,stock,shippingIncluded) values (?,?,?,?,?)"
        		,PreparedStatement.RETURN_GENERATED_KEYS
        		);
        pState.setString(1, p.getName());
        pState.setString(2, p.getDescription());
        pState.setDouble(3, p.getPrice());
        pState.setInt(4, p.getStock());
        pState.setBoolean(5, p.isShippingIncluded());
        
        pState.executeUpdate();
        
        ResultSet result = pState.getGeneratedKeys();
        int id =0;
        if (result!=null && result.next()) {
        	id = result.getInt(1);
        }
        
		if (result!=null)result.close();
		if (pState!=null)pState.close();
		conn.close();
		
		return id;
        
		}
		catch (SQLException exc) {
		System.out.println("SQLException: "+ exc.getMessage());
		return 0;
		}
	}
}
	
