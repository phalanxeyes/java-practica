package Ej6a;

import java.util.LinkedList;
import java.util.Scanner;

public class Menu {
	public static void main(String[] args) {
		
		Data.driver();
		LinkedList<Product> products = new LinkedList<>();
		

		
		Scanner scan = new Scanner(System.in);
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
					list(products);
				break;
				}
				case 2: {
					search();
				break;
				}
				case 3: {
					neww();
				break;
				}
				case 4: {
					delete();
				break;
				}	
				case 5: {
					update();
				break;
				}	
			}
		}
		scan.close();
	}
	
	public static  void list(LinkedList<Product> products) {
		products = Data.list();
		for (int i=0; i< products.size(); i++) {
		Product prod = products.get(i);
		System.out.println(prod.getId());
		System.out.println(prod.getName());;
		System.out.println(prod.getPrice());;
		}
	System.out.println();	
	System.out.println();		
	}
	
	public static Product search() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Type the ID of product to search");
		int id= Integer.parseInt(scan.nextLine());
		Product prodToSearch = new Product();
		prodToSearch.setId(id);
		Product prod = Data.search(prodToSearch);
		
		System.out.println(prod.toString());
		System.out.println();
		System.out.println();
		return prod;
	}
	
	public static void neww(){
		Product prod = writeNewData();
		System.out.println("The new product's ID is " + Data.neww(prod).getId());
	}	
	
	public static void delete() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Type the ID of the product to delete");
		int id = Integer.parseInt(scan.nextLine());
		Product prodToDelete = new Product();
		prodToDelete.setId(id);
		Data.delete(prodToDelete);
	}
	
	public static void update() {
		Product prodFound = search();
		System.out.println("enmenu "+ prodFound.getId());
		Product prodToUpdate = writeNewData();
		prodToUpdate.setId(prodFound.getId());
		Data.update(prodToUpdate);
	}
	
	public static Product writeNewData() {
		Scanner scan = new Scanner(System.in);
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
		
		return prod;
	}
}
