/*
*This program takes inputs in dotted-decimal form, converts them to binary notation, and calculates the Prefix Length. 
*/

import java.util.Scanner;
public class Assignment6 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		/*
		 * This program takes the dotted-decimal notation one
		 * decimal at a time, converts the decimal to binary notation, 
		 * and calculates the prefix length.
		 */
		System.out.print("Enter the first decimal of First Address: ");
		int firstAddress1 = scan.nextInt();
		System.out.print("Enter the second decimal of First Address: ");
		int firstAddress2 = scan.nextInt();
		System.out.print("Enter the third decimal of First Address: ");
		int firstAddress3 = scan.nextInt();
		System.out.print("Enter the fourth decimal of First Address: ");
		int firstAddress4 = scan.nextInt();
		System.out.println("");
		String one = convert(firstAddress1, 8);
		String two = convert(firstAddress2, 8);
		String three = convert(firstAddress3, 8);
		String four = convert(firstAddress4, 8);
		String firstAddress = one+two+three+four;
		
		System.out.print("Enter the first decimal of Last Address: ");
		int lastAddress1 = scan.nextInt();
		System.out.print("Enter the second decimal of Last Address: ");
		int lastAddress2 = scan.nextInt();
		System.out.print("Enter the third decimal of Last Address: ");
		int lastAddress3 = scan.nextInt();
		System.out.print("Enter the fourth decimal of Last Address: ");
		int lastAddress4 = scan.nextInt();
	
		String five = convert(lastAddress1, 8);
		String six = convert(lastAddress2, 8);
		String seven = convert(lastAddress3, 8);
		String eight = convert(lastAddress4, 8);
		String lastAddress =five+six+seven+eight;

		for(int x = 0; x < firstAddress.length() ; x++){
			if(firstAddress.charAt(x)!=lastAddress.charAt(x)){
				System.out.println("Prefix Length: " + (x));
				break;
			}//end if-statement
		}//end for-loop	
	}//end main method
	
	public static String convert(int decimal, int size) {
	    StringBuilder result = new StringBuilder();
	    for(int i = 7; i >= 0 ; i--) {
	        int mask = 1 << i;
	        result.append((decimal & mask) != 0 ? "1" : "0");

	        if (i % size == 0)
	        	result.append(" ");
	    }//end for-loop
	    result.replace(result.length() - 1, result.length(), "");
	    return result.toString();
	}//end convert method
}//end 
