
import java.util.Scanner;

public class Flyers {

	public static void main(String[] args) {
		pickupOrDelivery();
	}//close main

	//Here is the method that takes customer input as pick-up or delivery.
	static void pickupOrDelivery(){
		Scanner scan = new Scanner(System.in);
		int pickupordelivery;
		System.out.println("Hello. Thank for choosing Flyers'! For pick-up, please enter 1. For delivery, please enter 2.");
		pickupordelivery = scan.nextInt();	
		while (pickupordelivery!=1 && pickupordelivery !=2) {
			System.out.println("Sorry, you have entered an incorrect value. For pick-up, please enter 1. For delivery, please enter 2.");
			pickupordelivery = scan.nextInt();
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
		System.out.println("Your total bill comes to: $" + endPrice);
	}
		//Here is the method for Delivery customers.
		static void delivery() {
			Scanner scan = new Scanner(System.in);
			int zipcode;
			System.out.println("Delivery. Please enter you zip code.");
			zipcode = scan.nextInt();
			
			if (zipcode > 60442 && zipcode < 60450) {
				System.out.println("Delivery Available. There will be an additional charge of $5.00");
				deliveryAvailable();
			}
			
			if (zipcode == 60441 || zipcode == 60451) {
				System.out.println("Delivery with extra cost. There will be an additional charge of $7.00");
				deliveryExtraCharge();
			}
			
			if (zipcode < 60441 || zipcode > 60451) {
				System.out.println("Delivery Not Available. The order will need to be picked up");
				pickup();
				
			}
			scan.close();
		}//close delivery method	
		
		//If delivery is available
	 static void deliveryAvailable() {
		double endPrice = menu();
		double finalPrice = endPrice + 5.00;
		System.out.println("Your total bill comes to: $" + finalPrice);
	}
	 
	//If delivery is available w/extra charge
	 static void deliveryExtraCharge() {
			double endPrice = menu();
			double finalPrice = endPrice + 7.00;
			System.out.println("Your total bill comes to: $" + finalPrice);
	 }
	 
	static int burgerNumber(){
		Scanner scan = new Scanner(System.in);
		System.out.println("How many burgers would you like?");
		int a;
		a = scan.nextInt();
		return a;
	}
	static int friesNumber(){
		Scanner scan = new Scanner(System.in);
		System.out.println("How many fries would you like?");
		int b;
		b = scan.nextInt();
		return b;
	}
	static int drinkNumber(){
		Scanner scan = new Scanner(System.in);
		System.out.println("How many drinks would you like?");
		int c;
		c = scan.nextInt();
		return c;
	}
	static int dessertNumber(){
		Scanner scan = new Scanner(System.in);
		System.out.println("How many desserts would you like?");
		int d;
		d = scan.nextInt();
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
		System.out.println("Flyers' Burger: $" +burgerPrice);
		System.out.println("Flyers' Fries: $" +friesPrice);
		System.out.println("Flyers' Drink: $" +drinkPrice);
		System.out.println("Flyers' Dessert: $" +dessertPrice);
		
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
