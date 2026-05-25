package Ej6a;

import java.util.LinkedList;
import java.sql.*;
import java.time.LocalDate;

public class Data {

	public static void main(String args[]) {

	}
	
	public Connection connect() throws SQLException{
		return DriverManager.getConnection("jdbc:mysql://localhost/javaMarket","root","root");
	}
	
	public void disconnect(Connection conn) throws SQLException {
		conn.close();
	}
	
	public void driver() {
		try {
		    Connection conn = this.connect();
		} catch (SQLException e) {
		    e.printStackTrace();}
		}
	
	public LinkedList<Product> list(){
		
		LinkedList<Product> products = new LinkedList<>();
		try {
		Connection conn = this.connect();
			
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
		this.disconnect(conn);
		
		return products;
		}
		catch (SQLException exc){
			System.out.println("SQLException: "+ exc.getMessage());
			LinkedList<Product> emptyprodlist = new LinkedList<>();
			return emptyprodlist;
		}
	}
	
	public Product search(Product prod) {
		
		try {
		Connection conn = this.connect();
		
		PreparedStatement state = conn.prepareStatement("Select * from product where id=?");
		
		state.setInt(1, prod.getId() );
		ResultSet result = state.executeQuery();
		if (result.next()) {
		prod.setId(result.getInt("id"));
		prod.setName(result.getString("name"));
		prod.setDescription(result.getString("description"));
		prod.setPrice(result.getDouble("price"));
		prod.setStock(result.getInt("stock"));
		prod.setShippingIncluded(result.getBoolean("shippingIncluded"));
		prod.setDisabledOn(result.getObject("disabledOn", LocalDate.class));
		}
		if (result!=null)result.close();
		if (state!=null)state.close();
		this.disconnect(conn);
		
		return prod;
		}
		catch (SQLException exc){
			System.out.println("SQLException: "+ exc.getMessage());
			System.out.println("Product not found");
			Product emptyprod = new Product();
			return emptyprod;
		}
	}
	
	public Product neww(Product p) {
		try {
		Connection conn = this.connect();
		
        PreparedStatement pState = conn.prepareStatement(
        		"insert into product(name,description,price,stock,shippingIncluded, disabledOn) values (?,?,?,?,?,?)"
        		,PreparedStatement.RETURN_GENERATED_KEYS
        		);
        pState.setString(1, p.getName());
        pState.setString(2, p.getDescription());
        pState.setDouble(3, p.getPrice());
        pState.setInt(4, p.getStock());
        pState.setBoolean(5, p.isShippingIncluded());
        pState.setObject(6, p.getDisabledOn());
        
        pState.executeUpdate();
        
        ResultSet result = pState.getGeneratedKeys();
        int id =0;
        if (result!=null && result.next()) {
        	p.setId(result.getInt(1));
        }
        
		if (result!=null)result.close();
		if (pState!=null)pState.close();
		this.disconnect(conn);
		
		return p;
        
		}
		catch (SQLException exc) {
		System.out.println("SQLException: "+ exc.getMessage());
		return p;
		}
	}
	
	public void delete(Product prodToDelete) {
		try {
		Connection conn = this.connect();
        PreparedStatement pState = conn.prepareStatement(
        		"DELETE FROM product WHERE id=?");
        pState.setInt(1, prodToDelete.getId());
        pState.executeUpdate();
        
		if (pState!=null)pState.close();
		this.disconnect(conn);
        
		}
		catch (SQLException exc){
			System.out.println("SQLException: "+ exc.getMessage());
		}
	}
	
	
	public void update(Product updatedProd) {
		try {
		Connection conn = this.connect();
		
        PreparedStatement pState = conn.prepareStatement(
        		"UPDATE product SET name=?, description=?, price=?, stock=?, shippingIncluded=?, disabledOn=? WHERE id=?"
        		);
        
        pState.setString(1, updatedProd.getName());
        pState.setString(2, updatedProd.getDescription());
        pState.setDouble(3, updatedProd.getPrice());
        pState.setInt(4, updatedProd.getStock());
        pState.setBoolean(5, updatedProd.isShippingIncluded());
        pState.setObject(6, updatedProd.getDisabledOn());
        pState.setInt(7, updatedProd.getId());
        pState.executeUpdate();
        
		if (pState!=null)pState.close();
		this.disconnect(conn);
		
        
		}
		catch (SQLException exc) {
		System.out.println("SQLException: "+ exc.getMessage());
		}
	}
}
	
