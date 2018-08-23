/*
 * 
 *The first program implements all three methods of sorting on one array. I have also included the separate classes
 *for each of the three methods of sorting.
 *
 * ************************************Full Program For All three Methods Of Sorting**********************************
 */

import java.util.Arrays;
import java.util.*;

public class Assign8Sorting {
	
	public static void main(String a[]){
        int[] initialArray = {10,9,8,7,6,5,4,3,2,1};
        
        //Linear Sort
        int[] newArray = LinearSort(initialArray);
        System.out.print("Linear Sort: " );
        System.out.print(Arrays.toString(newArray));
        System.out.println(" " );
        
        //Quick Sort
        int low = 0;
		int high = initialArray.length - 1;
		QuickSort(initialArray, low, high);
		System.out.print("Quick Sort: " );
		System.out.print(Arrays.toString(initialArray));
		System.out.println(" " );
		
		//Merge Sort
        MergeSort(initialArray, 0, initialArray.length-1);
        System.out.print("Merge Sort: " );
        System.out.print(Arrays.toString(initialArray));
    }//close main

	//Here is the method for Linear Sort
    public static int[] LinearSort(int[] input){
        int x;
        for (int i = 1; i < input.length; i++) {
            for(int j = i ; j > 0 ; j--){
                if(input[j] < input[j-1]){
                    x = input[j];
                    input[j] = input[j-1];
                    input[j-1] = x;
                }
            }
        }
        return input;
    }//close LinearSort method

  //Here is the method for Quick Sort
  	public static void QuickSort(int[] numbers, int low, int high) {
  		if (numbers == null || numbers.length == 0) {
  			return;
  		}
  		if (low >= high) {
  			return;
  		}
  		int mid = low + (high - low) / 2;
  		int pivot = numbers[mid];
  		int i = low, j = high;
  		while (i <= j) {
  			while (numbers[i] < pivot) {
  				i++;
  			}
  			while (numbers[j] > pivot) {
  				j--;
  			}
  			if (i <= j) {
  				int temp = numbers[i];
  				numbers[i] = numbers[j];
  				numbers[j] = temp;
  				i++;
  				j--;
  			}
  		}
  		if (low < j) {
  			QuickSort(numbers, low, j);
  		}
  		if (high > i) {
  			QuickSort(numbers, i, high);
  		}
  	}//close QuickSort method
    
    
  	//Here are the methods for Merge Sort
    static void MergeSort(int newArray[], int lef, int rig) {
        if (lef < rig) {
            int mid = (lef+rig)/2;
            MergeSort(newArray, lef, mid);
            MergeSort(newArray , mid+1, rig);
            merging(newArray, lef, mid, rig);
        }
    }//close MergeSort method

    static void merging(int x[], int lef, int mid, int rig) {
        int aLeft = mid - lef + 1;
        int aRight = rig - mid;
  
        int left[] = new int [aLeft];
        int right[] = new int [aRight];
  
        for (int i=0; i<aLeft; ++i) {
            left[i] = x[lef + i];
        }
        for (int j=0; j<aRight; ++j) {
            right[j] = x[mid + 1+ j];
        }
  
        int i = 0,j = 0;
        int k = lef;
         
        while (i < aLeft && j < aRight) {
            if (left[i] <= right[j]) {
                x[k] = left[i];
                i++;
            }
            else {
                x[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < aLeft) {
            x[k] = left[i];
            i++;
            k++;
        }
        while (j < aRight) {
            x[k] = right[j];
            j++;
            k++;
        }
    }//close merge method	
}//close Assign8Sorting

/*
 * ************************************Linear Sort Class**********************************
 */

import java.util.Arrays;

public class LinearSort {
    public static void main(String a[]){
        int[] initialArray = {10,9,8,7,6,5,4,3,2,1};
        int[] newArray = LinearSort(initialArray);
        System.out.println(Arrays.toString(newArray));
    }//close main
     //here is the method for sorting
    public static int[] LinearSort(int[] input){
        int x;
        for (int i = 1; i < input.length; i++) {
            for(int j = i ; j > 0 ; j--){
                if(input[j] < input[j-1]){
                    x = input[j];
                    input[j] = input[j-1];
                    input[j-1] = x;
                }
            }
        }
        return input;
    }//close LinearSort method
}//close LinearSort class

/*
 * ************************************Quick Sort Class**********************************
 */

import java.util.*;

public class QuickSort {
	public static void main(String[] args) {
		int[] initialArray = {10,9,8,7,6,5,4,3,2,1};
		int low = 0;
		int high = initialArray.length - 1;
		QuickSort(initialArray, low, high);
		System.out.println(Arrays.toString(initialArray));
	}//close main
	
	//here is the method for sorting
	public static void QuickSort(int[] numbers, int low, int high) {
		if (numbers == null || numbers.length == 0) {
			return;
		}
		if (low >= high) {
			return;
		}
		int mid = low + (high - low) / 2;
		int pivot = numbers[mid];
		int i = low, j = high;
		while (i <= j) {
			while (numbers[i] < pivot) {
				i++;
			}
			while (numbers[j] > pivot) {
				j--;
			}
			if (i <= j) {
				int temp = numbers[i];
				numbers[i] = numbers[j];
				numbers[j] = temp;
				i++;
				j--;
			}
		}
		if (low < j) {
			QuickSort(numbers, low, j);
		}
		if (high > i) {
			QuickSort(numbers, i, high);
		}
	}//close QuickSort method
}//close QuickSort class

/*
 * ************************************Merge Sort Class**********************************
 */

import java.util.*;

public class MergeSort {
    public static void main(String args[]) {
        int[] initialArray = {10,9,8,7,6,5,4,3,2,1};
        MergeSort(initialArray, 0, initialArray.length-1);
        System.out.println(Arrays.toString(initialArray));
    }//close main
    
    //here is the method for sorting
    static void MergeSort(int newArray[], int lef, int rig) {
        if (lef < rig) {
            int mid = (lef+rig)/2;
            MergeSort(newArray, lef, mid);
            MergeSort(newArray , mid+1, rig);
            merge(newArray, lef, mid, rig);
        }
    }//close MergeSort method

    static void merge(int x[], int lef, int mid, int rig) {
        int aLeft = mid - lef + 1;
        int aRight = rig - mid;
  
        int left[] = new int [aLeft];
        int right[] = new int [aRight];
  
        for (int i=0; i<aLeft; ++i) {
            left[i] = x[lef + i];
        }
        for (int j=0; j<aRight; ++j) {
            right[j] = x[mid + 1+ j];
        }
  
        int i = 0,j = 0;
        int k = lef;
         
        while (i < aLeft && j < aRight) {
            if (left[i] <= right[j]) {
                x[k] = left[i];
                i++;
            }
            else {
                x[k] = right[j];
                j++;
            }
            k++;
        }
      
        while (i < aLeft) {
            x[k] = left[i];
            i++;
            k++;
        }
        while (j < aRight) {
            x[k] = right[j];
            j++;
            k++;
        }
    }//close merge method
}//close MergeSort class