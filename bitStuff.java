/*
 * This program simulates bit stuffing and bit unstuffing.
 * In bit stuffing, if a 0 and 5 consecutive 1 bits are encountered, 
 * an extra 0 is added. This extra stuffed bit is removed, or unstuffed, 
 * by the receiver. 
 */

import java.util.*;

public class Assignment5 {
	
       public static void main(String[] args) {
           String frame = new String();
           String unstuffed = new String();
           //This counter will count the bits
           int counter = 0;
           //Ask the user for the data message
           System.out.print("Enter the data (From Upper-Layer): ");
           Scanner scan = new Scanner(System.in);
           String dataIn = scan.nextLine();
           	  //For-loop to read the data
              for(int i = 0; i < dataIn.length(); i++) {
                   if(dataIn.charAt(i) == '1') {
                            counter++;//Counter goes up if 1 is found
                            frame = frame + dataIn.charAt(i);
                        }
                   else {
                	   frame = frame + dataIn.charAt(i);
                            counter = 0;
                        }
                   //If 5 consecutive 1's are counted, add a zero to the message
                   //after them.
                   if(counter == 5) {
                	   frame = frame + '0';
                            counter = 0;
                        }
                }//end for-loop
            System.out.println("Frame Sent (Stuffed): " + frame);
            System.out.println("Frame Received (Stuffed): " + frame);
            //Here is the code to unstuff the message. Performs the opposite
            //task of the code above.
            counter = 0;
            for(int i = 0; i < frame.length(); i++) {
                    if(frame.charAt(i) == '1') {
                            counter++;
                            unstuffed = unstuffed + frame.charAt(i);
                        }
                    else {
                    	unstuffed = unstuffed + frame.charAt(i);
                             counter = 0;
                        }
                   if(counter == 5) {
                              if((i + 2) != frame.length())
                            	  unstuffed = unstuffed + frame.charAt(i + 2);
                              else
                            	  unstuffed = unstuffed + '1';
                              i = i + 2;
                              counter = 1;
                        }
               }//end for-loop
          
             System.out.println("Unstuffed Message (Data To Upper-Layer): " + unstuffed);
       }//end main method
}//end
