package Ej6a;

import java.util.LinkedList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Menu {
	Data data = new Data();
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		Menu menu = new Menu();
		menu.data.driver();

		LinkedList<Product> products = new LinkedList<>();
		
		int num = -1;
		while (num != 0) {
			System.out.println("Select procedure:");
			System.out.println("1.list");
			System.out.println("2.search");
			System.out.println("3.new");
			System.out.println("4.delete");
			System.out.println("5.update");
			System.out.println("0.exit");
			num = Integer.parseInt(scan.nextLine());
			switch (num) {
				case 1: {
					menu.list(products);
				break;
				}
				case 2: {
					menu.search();
				break;
				}
				case 3: {
					menu.neww();
				break;
				}
				case 4: {
					menu.delete();
				break;
				}	
				case 5: {
					menu.update();
				break;
				}	
			}
		}
		scan.close();
	}
	
	public void list(LinkedList<Product> products) {
		products = data.list();
		for (int i=0; i< products.size(); i++) {
		Product prod = products.get(i);
		System.out.println(prod.getId());
		System.out.println(prod.getName());;
		System.out.println(prod.getPrice());;
		}
	System.out.println();	
	System.out.println();		
	}
	
	public Product search() {
		System.out.println("Type the ID of product to search");
		int id= Integer.parseInt(scan.nextLine());
		Product prodToSearch = new Product();
		prodToSearch.setId(id);
		Product prod = data.search(prodToSearch);
		
		System.out.println(prod.toString());
		System.out.println();
		System.out.println();
		return prod;
	}
	
	public void neww(){
		Product prod = writeNewData();
		System.out.println("The new product's ID is " + data.neww(prod).getId());
	}	
	
	public void delete() {
		System.out.println("Type the ID of the product to delete");
		int id = Integer.parseInt(scan.nextLine());
		Product prodToDelete = new Product();
		prodToDelete.setId(id);
		data.delete(prodToDelete);
	}
	
	public void update() {
		Product prodFound = search();
		System.out.println("Found product with ID "+ prodFound.getId());
		Product prodToUpdate = writeNewData();
		prodToUpdate.setId(prodFound.getId());
		data.update(prodToUpdate);
	}
	
	public Product writeNewData() {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		Product prod = new Product();
		System.out.println("Type the new name of the product");
		prod.setName(scan.nextLine());
		System.out.println("Type the new description of the product");
		prod.setDescription(scan.nextLine());
		System.out.println("Type the new price of the product");
		prod.setPrice(Double.parseDouble(scan.nextLine()));
		System.out.println("Type the new stock of the product");
		prod.setStock(Integer.parseInt(scan.nextLine()));
		System.out.println("Is shipping included? 1 for yes, 0 for no");
		if (Integer.parseInt(scan.nextLine()) == 1) prod.setShippingIncluded(true);
		else prod.setShippingIncluded(false);
		System.out.println("When is this product disabled?");
		LocalDate date = LocalDate.parse(scan.nextLine(), format);
		System.out.println(date);
		prod.setDisabledOn(date);
		
		return prod;
	}
}
