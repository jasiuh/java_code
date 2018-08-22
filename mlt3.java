/* 
 * This program simulates a MLT-3 scheme.
 * It outputs either a 0, 1, or -1 based on the input bits array. These represent 0V, +V, and -V, respectively.
 * It can easily be demonstrated with a microcontroller such as Arduino.
 * This would be done by replacing the print statements with a digitalWrite(13, HIGH) for 1V and
 * a digitalWrite(13, LOW) for 0V. For -1V, you would use a separate digital pin 
 * (i.e.digitalWrite(12, HIGH)) and the + and - could be swapped to produce a negative voltage output.
 * 
 */

public class MLT3 {
	
	public static int bits[] = {1,0,0,1,0,1,0,1};//
	public static int currentLevel;//This will be 0, 1, or -1 for the three levels (0V, +V, or –V, respectively).
	public static void main(String[] args) {
		//Here is the code to learn the first bit in the array.
		int startBit = bits[0];
		if(startBit == 0) {
			currentLevel = 0;
			System.out.println(currentLevel);
		}
		if(startBit == 1) {
			currentLevel = 1;	
			System.out.println(currentLevel);
		}
		//Here is the loop to go through the rest of the array.
		for (int nextBit = 1; nextBit < bits.length; nextBit++ ){
			//Transition 1 - If the next bit is 0, there is no transition. 
			 if (bits[nextBit] == 0){
				 System.out.println(currentLevel);
			 }
			//Transition 2 - If the next bit is 1 and the current level is not 0, the next level is 0.
			 if (bits[nextBit] == 1 && currentLevel != 0){
				 currentLevel = 0;
				 System.out.println(currentLevel); 
			 }
			//Transition 3 - If the next bit is 1 and the current level is 0, the next level is the 
			//opposite of the last nonzero level.
			 if (bits[nextBit] == 1 && currentLevel == 0){
				 System.out.println(currentLevel);
				 for(int opposite = nextBit; opposite >= 0; opposite--) {//loop backwards to locate last non-zero value
					 if (opposite == 1) {
						 currentLevel = -1;
						 System.out.println(currentLevel);
						 break;
					 }
					 if (opposite == -1) {
						 currentLevel = 1;
						 System.out.println(currentLevel);
						 break;
					 }
				}//end inner for-loop
			 }//end if statement		 
		}//end outer for-loop
	}//end main method
}//end MLT3 class
