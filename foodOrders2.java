
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Flyers {

	public static void main(String[] args) {
		pickupOrDelivery();
		JOptionPane.showMessageDialog(null,"Thank you! Enjoy!");
	}//close main

	//Here is the method that takes customer input as pick-up or delivery.
	static void pickupOrDelivery(){
		Scanner scan = new Scanner(System.in);
		int pickupordelivery;
		JOptionPane.showMessageDialog(null,"Hello! Thank for choosing Flyers'!","Welcome to Flyers!",JOptionPane.INFORMATION_MESSAGE);
		pickupordelivery = Integer.parseInt(JOptionPane.showInputDialog("For pick-up, please enter 1. For delivery, please enter 2."));	
		while (pickupordelivery!=1 && pickupordelivery !=2) {
			JOptionPane.showMessageDialog(null,"Sorry, you have entered an incorrect value. Please try again.","Incorrect Input",JOptionPane.ERROR_MESSAGE);
			pickupordelivery = Integer.parseInt(JOptionPane.showInputDialog("For pick-up, please enter 1. For delivery, please enter 2."));
		}
		if (pickupordelivery==1) {
			pickup();
		}
		if (pickupordelivery==2) {
			delivery();
		}
		scan.close();
	}//close pickupOrDelivery

	//Here is the method for pick-up
	 static void pickup() {
		double endPrice = menu();
		JOptionPane.showMessageDialog(null,"Your total bill comes to: $" + endPrice);
	}
		//Here is the method for Delivery customers.
		static void delivery() {
			Scanner scan = new Scanner(System.in);
			int zipcode;
			zipcode = Integer.parseInt(JOptionPane.showInputDialog("Delivery. Please enter your zip code."));
			
			if (zipcode > 60442 && zipcode < 60450) {
				JOptionPane.showMessageDialog(null,"Delivery Available. There will be an additional charge of $5.00.");
				deliveryAvailable();
			}
			
			if (zipcode == 60441 || zipcode == 60451) {
				JOptionPane.showMessageDialog(null,"Delivery with extra cost. There will be an additional charge of $7.00.");
				deliveryExtraCharge();
			}
			
			if (zipcode < 60441 || zipcode > 60451) {
				JOptionPane.showMessageDialog(null,"Delivery Not Available. The order will need to be picked up.");
				pickup();
				
			}
			scan.close();
		}//close delivery method	
		
		//If delivery is available
	 static void deliveryAvailable() {
		double endPrice = menu();
		double finalPrice = endPrice + 5.00;
		JOptionPane.showMessageDialog(null,"Your total bill comes to: $" + finalPrice);
	}
	 
	//If delivery is available w/extra charge
	 static void deliveryExtraCharge() {
			double endPrice = menu();
			double finalPrice = endPrice + 7.00;
			JOptionPane.showMessageDialog(null,"Your total bill comes to: $" + finalPrice);
	 }
	 
	static int burgerNumber(){
		Scanner scan = new Scanner(System.in);
		int a;
		a = Integer.parseInt(JOptionPane.showInputDialog("How many burgers would you like?"));
		return a;
	}
	static int friesNumber(){
		Scanner scan = new Scanner(System.in);
		int b;
		b = Integer.parseInt(JOptionPane.showInputDialog("How many fries would you like?"));
		return b;
	}
	static int drinkNumber(){
		Scanner scan = new Scanner(System.in);
		int c;
		c = Integer.parseInt(JOptionPane.showInputDialog("How many drinks would you like?"));
		return c;
	}
	static int dessertNumber(){
		Scanner scan = new Scanner(System.in);
		int d;
		d = Integer.parseInt(JOptionPane.showInputDialog("How many desserts would you like?"));
		return d;
	}
	
	 static double menu() {
		double burgerPrice = 4.50;
		double friesPrice = 2.50;
		double drinkPrice = 1.50;
		double dessertPrice = 3.00;
		int burgerAmount;
		int friesAmount;
		int drinkAmount;
		int dessertAmount;
		double taxRate = 0.05;
		double endPrice;
		double foodPrice;
		JOptionPane.showMessageDialog(null,"******Flyers' Menu******\nFlyers' Burger: $4.50\nFlyers' Fries: $2.50\nFlyers' Drink: $1.50\nFlyers' Dessert: $3.00");
		
		burgerAmount = burgerNumber();
		friesAmount = friesNumber();
		drinkAmount= drinkNumber();
		dessertAmount= dessertNumber();
		
		taxRate = (burgerAmount*burgerPrice + friesAmount*friesPrice + drinkAmount*drinkPrice + dessertAmount*dessertPrice) * 0.05;
		foodPrice = burgerAmount*burgerPrice + friesAmount*friesPrice + drinkAmount*drinkPrice + dessertAmount*dessertPrice;
		endPrice = taxRate + foodPrice;
		return endPrice;
	}

}//close Flyers