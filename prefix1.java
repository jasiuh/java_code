/*
 * This program takes as inputs a first address and last address.
 * From these two inputs, it generates the prefix length.
 */

import java.util.Scanner;
public class Assignment6 {

	public static void main(String[] args) {
		//If the addresses are in dotted-decimal notation,
		//they must be converted to binary notation.
		//The inputs here take binary notation with no 
		//spaces.
		Scanner scan = new Scanner(System.in);
		//Ask the user for the First Address
		System.out.print("Enter the First Address: ");
		String firstAddress = scan.nextLine();
		//Ask the user for the Last Address
		System.out.print("Enter the Last Address: ");
		String lastAddress = scan.nextLine();
		//This algorithm runs through the First Address and compares
		//each character to one in the same position of the Second
		//Address. Once they are not equal, it prints out the number
		//of characters before the current position which is also the 
		//prefix length.
		for(int x = 0; x < firstAddress.length() ; x++){
			if(firstAddress.charAt(x)!=lastAddress.charAt(x)){
				System.out.println("Prefix Length: " + x);
				break;
			}//end if-statement
		}//end for-loop	
	}//end main method
}//end 
