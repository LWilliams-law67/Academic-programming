/**
   COP2253 Java programming
   This program takes input from a user; such as, product name, unit price, and quantity.
   The data is formatted into a table to be printed on the console along with
   a total price for the entire quantity of each product.
   totalCost = unitPrice * quantity
   
   @author lwilliams
   @version 1.0
   
   COP2253 project 2
   filename: Product.java
*/

import java.util.Scanner;
import java.util.ArrayList;

public class Product
{
	   	String productName;
   		int quantity;
   		double unitPrice;
   		double totalCost;

	public Product (String name, int amount, double price)	//	parameterized constuctor to set name, quantity, and price
	{
		productName = name;
		quantity = amount;
		unitPrice = price;
	}

	public String getName()
	{
		String firstChar = Character.toString(productName.charAt(0));	//	stores first character of product name to a string
		String subName = productName.substring(1);	//	stores the remaining characters of product name to a string

		productName = firstChar.toUpperCase() + subName.toLowerCase();	//	formats product name
		return productName;
	}

	public int getQuantity()
	{
		return quantity;
	}

	public double getPrice()
	{
		return unitPrice;
	}

	public double getTotalCost()
	{
		totalCost = unitPrice * quantity;

		return totalCost;
	}

	public void printProductData(String rowFormat)
	{
		System.out.printf(rowFormat, productName, quantity, unitPrice, totalCost);
	}

   public static void main(String [] args)
   {
   		String name;
   		int quantity;
   		double price;
   		String formatCols = "|%-20s|%-10s|%-15s|%-15s|%n";
		String formatRows = "|%-20s|%10d|%15.2f|%15.2f|%n";

   		Scanner input = new Scanner(System.in);	//	Scanner method for extracting user input

   		List<Product> productList = new ArrayList<Product>();	//	creates a list of product objects
   		int productNum = 1;	//	variable to control the iterations of the loop
   		do
   		{
   			System.out.println ("Please provide the following information for product " + productNum + ": ");
	   		System.out.print ("Product name: ");
	   		name = input.next();
	   		System.out.print ("\nProduct quantity: ");
	   		quantity = input.nextInt();
	   		System.out.print ("\nProduct unit price: ");
	   		price = input.nextDouble();

	   		productList.add(new Product(name, quantity, price));	//	adds a new product to the product list with user input

   		}while (productNum < 3);	//	set up for only inputing 2 products

		System.out.printf(formatCols, "Product:", "Qty:", "Price:", "Total:");
		productList(0).printProductData(formatRows);
		productList(1).printProductData(formatRows);


    }
}