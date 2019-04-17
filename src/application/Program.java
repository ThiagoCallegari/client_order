package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter cliente data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());  // a entrada de dados fica dentro do argumento do método sdf.parse;
		
		Client client = new Client(name, email, birthDate);
		
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());    // a entrada de texto fica dentro do argumento do método valueOf do OrderStatus;
		
		Order order = new Order(new Date(), status, client);
		
		System.out.print("How many items to this order? ");
		int numberOfItems = sc.nextInt();
		for (int i = 1; i <= numberOfItems; i++) {
			System.out.println("Enter #" + i + " item data:");
			System.out.print("Product name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			double productPrice = sc.nextDouble();
			
			Product product = new Product(productName, productPrice);
			
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			
			OrderItem orderItem = new OrderItem(quantity, productPrice, product);
			
			order.addItem(orderItem);     // A lista já está instanciada na Classe Order, por isso não há necessidade de instanciá-la aqui, já que o order já está estanciado 
		}
		
		System.out.println();
		System.out.println("ORDER SUMMARY:");
		System.out.print(order);   // todo o texto já está definido nas demais classes responsáveis.
		
		sc.close();
	}

}
