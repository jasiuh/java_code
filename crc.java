/*
 * This program simulates an encoder and decoder of a Cyclic Redundancy Check (CRC).
 */


import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Assign4 {
	//Here is the method for performing the division.
    static int[] division(int dividend[],int divisor[], int syndrome[]) {
        int decode=0;
        while(true) {
            for(int i=0;i<divisor.length;i++)
            	syndrome[decode+i]=(syndrome[decode+i]^divisor[i]);
            
            while(syndrome[decode]==0 && decode!=syndrome.length-1)
            	decode++;
    
            if((syndrome.length-decode)<divisor.length)
                break;
        }
        return syndrome;
    }//end division method
    
    public static void main(String args[]) throws IOException {
/***************************Encoder*****************************/
    	int [] dataword = new int[4];//Array to hold 4-bit user-entered Dataword.
    	Scanner scan = new Scanner(System.in);
    	//Ask user for the first 4 bits of the Dataword, one at a time.
    	//The three additional zeros are appended later.
    	System.out.println("Please enter first bit of the 4-bit dataword: ");
    	dataword[0] = scan.nextInt();
    	System.out.println("Please enter second bit of the 4-bit dataword: ");
    	dataword[1] = scan.nextInt();
    	System.out.println("Please enter third bit of the 4-bit dataword: ");
    	dataword[2] = scan.nextInt();
    	System.out.println("Please enter fourth bit of the 4-bit dataword: ");
    	dataword[3] = scan.nextInt();
        int[] divisor = {1,0,1,1};//Divisor is set "1011", like in the book example.
        int[] generator;
        int[] syndrome;
        int[] crc;
        //The codeword is 7 bits long.
        int totalLength = 7;
   
        System.out.println("Dataword: " + Arrays.toString(dataword));
        System.out.println("Divisor: " + Arrays.toString(divisor));
        
        generator=new int[totalLength];
        syndrome=new int[totalLength];
        crc=new int[totalLength];
        
        for(int i=0;i<dataword.length;i++)
        	generator[i]=dataword[i];
        
        System.out.print("Dividend: ");
        for(int i=0; i< generator.length; i++)
            System.out.print(generator[i]);        
        System.out.println();
     
        
        for(int j=0; j<generator.length; j++){
        	syndrome[j] = generator[j];
        }
    
        syndrome = division(generator, divisor, syndrome);
        
        for(int i=0;i<generator.length;i++) {
            crc[i]=(generator[i]^syndrome[i]);
        }
        
        System.out.print("Codeword: ");    
        for(int i=0;i<crc.length;i++)
            System.out.print(crc[i]);
        System.out.println();
/***************************Decoder*****************************/
    	System.out.println("Please enter first bit of the 7-bit Codeword received: ");
    	crc[0] = scan.nextInt();
    	System.out.println("Please enter second bit of the 7-bit Codeword received: ");
    	crc[1] = scan.nextInt();
    	System.out.println("Please enter third bit of the 7-bit Codeword received: ");
    	crc[2] = scan.nextInt();
    	System.out.println("Please enter fourth bit of the 7-bit Codeword received: ");
    	crc[3] = scan.nextInt();
    	System.out.println("Please enter fifth bit of the 7-bit Codeword received: ");
    	crc[4] = scan.nextInt();
    	System.out.println("Please enter sixth bit of the 7-bit Codeword received: ");
    	crc[5] = scan.nextInt();
    	System.out.println("Please enter seventh bit of the 7-bit Codeword received: ");
    	crc[6] = scan.nextInt();

        for(int j=0; j<crc.length; j++){
        	syndrome[j] = crc[j];
        }
    
        syndrome = division(crc, divisor, syndrome);
        
        for(int i=0; i< syndrome.length; i++) {
            if(syndrome[i]!=0) {
                System.out.println("Corrupted");
                break;
            }
            if(i==syndrome.length-1)
                System.out.println("Uncorrupted");
        }
    }//end main method
}//end 
