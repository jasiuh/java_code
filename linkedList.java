

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class LinkListQueue {
	
  public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);

	Queue<Character> letters = new LinkedList<>();
	
	for(int i =0; letters.size()<10; i++) {
    System.out.print("Enter a letter: ");
    char letter = scan.next().charAt(0);
    letters.add(letter);
    System.out.println("Linked List Queue: " + letters);
	}//close for-loop

    	System.out.println("End. Ten is the maximum number of characters allowed in the queue.");
    
  }//close main
}//close LinkListQueue

/**********************************************************************************************/

import java.util.Random;
import java.util.*;

public class InsertionSort {
	
    public static void main(String[] args) {
    	Random gen = new Random();
    	//Generate 20 random numbers from 0-100
    	int num1 = gen.nextInt(101);
    	int num2 = gen.nextInt(101);
    	int num3 = gen.nextInt(101);
    	int num4 = gen.nextInt(101);
    	int num5 = gen.nextInt(101);
    	int num6 = gen.nextInt(101);
    	int num7 = gen.nextInt(101);
    	int num8 = gen.nextInt(101);
    	int num9 = gen.nextInt(101);
    	int num10 = gen.nextInt(101);
    	int num11 = gen.nextInt(101);
    	int num12 = gen.nextInt(101);
    	int num13 = gen.nextInt(101);
    	int num14 = gen.nextInt(101);
    	int num15 = gen.nextInt(101);
    	int num16 = gen.nextInt(101);
    	int num17 = gen.nextInt(101);
    	int num18 = gen.nextInt(101);
    	int num19 = gen.nextInt(101);
    	int num20 = gen.nextInt(101);

		int[] inputArray = {num1,num2,num3,num4,num5,
			                num6,num7,num8,num9,num10,
			                num11,num12,num13,num14,
			                num15,num16,num17,num18,
			                num19,num20};
		//Print 20 randomly generated integers:
		System.out.println("Before Insertion Sort: " + Arrays.toString(inputArray));
        insertionSort(inputArray);//call sorting method
    }//close main
    
    //method for sorting
    public static void insertionSort(int array[]) {
        int n = array.length;
        for (int j = 1; j < n; j++) {
            int key = array[j];
            int i = j-1;
            while ((i > -1) && (array [i] > key)) {
                array [i+1] = array [i];
                i--;
            }//close while loop
            array[i+1] = key;
        }//close for-loop
        //Print 20 randomly generated integers after sorting:
        System.out.println("After Insertion Sort: " + Arrays.toString(array));
    }//close insertionSort
}//close InsertionSort