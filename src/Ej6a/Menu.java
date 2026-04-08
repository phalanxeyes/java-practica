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
			num = Integer.parseInt(scan.nextLine());
			switch (num) {
				case 1: {
					products = Data.list();
					for (int i=0; i< products.size(); i++) {
					Product prod = products.get(i);
					System.out.println(prod.getId());
					System.out.println(prod.getName());;
					System.out.println(prod.getPrice());;
					}
				System.out.println();	
				System.out.println();				
				break;
				}
				case 2: {
					System.out.println("Type the ID of product to search");
					int id= Integer.parseInt(scan.nextLine());
					Product prod = Data.search(id);
					
					System.out.println(prod.toString());
					System.out.println();
					System.out.println();
					break;
				}
				case 3: {
					Product prod = new Product();
					System.out.println("Type the name of the new product");
					prod.setName(scan.nextLine());
					System.out.println("Type the description of the new product");
					prod.setDescription(scan.nextLine());
					System.out.println("Type the price of the new product");
					prod.setPrice(Double.parseDouble(scan.nextLine()));
					System.out.println("Type the stock of the new product");
					prod.setStock(Integer.parseInt(scan.nextLine()));
					System.out.println("Is shipping included? 1 for yes, 0 for no");
					if (Integer.parseInt(scan.nextLine()) == 1) prod.setShippingIncluded(true);
					else prod.setShippingIncluded(false);
					
					System.out.println("The new product's ID is " + Data.neww(prod));
				}
				case 4: {
					
				}	
				case 5: {
					
				}	
			}
;
		}
		scan.close();
}
}
