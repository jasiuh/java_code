/*
 * This program simulates a Setup Request and Setup Acknowledgement
 * in a virtual circuit network. The methods and their arguments act
 * as switches updating the information printed to the screen just 
 * as the switches update the data within the tables. The arguments 
 * carry the virtual circuit identifier (or VCI) after being updated 
 * in each method, or "switch". They then pass the VCI to the next switch.
 * In the "Setup Request" phase, the arguments pass the Incoming VCI.
 * In the "Setup Acknowledgement" phase, the arguments pass the Outgoing VCI.
 */
public class Assignment3 {

	public static int incomingPort1, incomingPort2, incomingPort3, 
			     incomingVCI1, incomingVCI2, incomingVCI3,
	                  outgoingPort1, outgoingPort2, outgoingPort3,
	                  outgoingVCI1, outgoingVCI2, outgoingVCI3;

	public static void main(String[] args) {
		//This simulates Source A sending setup frame to Switch 1.
		incomingVCI1 = 14;
		switchOneRequest(incomingVCI1);
	}

	//Switch 1 receives setup request frame from Source A.
	public static void switchOneRequest(int incomingVCI1){
		incomingPort1 = 1;//Switch 1 assigns incoming port 1.
		//Switch 1 knows that frame going from A to B goes through Port 3.
		outgoingPort1 = 3;
		//Print the table.
		System.out.println("Setup Request Switch 1");
		System.out.println("Incoming Port: " + incomingPort1);
		System.out.println("Incoming VCI: " + incomingVCI1);
		System.out.println("Outgoing Port: " + outgoingPort1);
		System.out.println("");
		incomingVCI2 = 66;//Switch 1 assigns 66 as the new incoming VCI for Switch 2.
		switchTwoRequest(incomingVCI2);//Send VCI to Switch 2.
	}//end switchOneRequest

	public static void switchTwoRequest(int incomingVCI2){
		incomingPort2 = 1;//Assigned by Switch 2.
		outgoingPort2 = 2;//Assigned by Switch 2.
		//Print the table.
		System.out.println("Setup Request Switch 2");
		System.out.println("Incoming Port: " + incomingPort2);
		System.out.println("Incoming VCI: " + incomingVCI2);
		System.out.println("Outgoing Port: " + outgoingPort2);
		System.out.println("");
		incomingVCI3 = 22;//Switch 2 assigns 22 as the new incoming VCI for Switch 3.
		switchThreeRequest(incomingVCI3);//Send VCI to Switch 3.
	}//end switchTwoRequest

	public static void switchThreeRequest(int incomingVCI3){
		incomingPort3 = 2;//Assigned by Switch 3.
		outgoingPort3 = 3;//Assigned by Switch 3.
		//Print the table.
		System.out.println("Setup Request Switch 3");
		System.out.println("Incoming Port: " + incomingPort3);
		System.out.println("Incoming VCI: " + incomingVCI3);
		System.out.println("Outgoing Port: " + outgoingPort3);
		System.out.println("");
		outgoingVCI3 = 77;//Switch 3 assigns 77 as the new outgoing VCI for Destination B.
		//This simulates the already known information being transmitted from B back to A
		//with the tables being completed as it goes.
		switchThreeAcknowledgement(outgoingVCI3);
	}//end switchThreeRequest

	public static void switchThreeAcknowledgement(int outgoingVCI3){
		//Print the table.
		System.out.println("Setup Acknowledgement Switch 3");
		//The first three columns are completed from the request. 
		//The final is being updated with the outgoing VCI data.
		System.out.println("Incoming Port: " + incomingPort3);
		System.out.println("Incoming VCI: " + incomingVCI3);
		System.out.println("Outgoing Port: " + outgoingPort3);
		System.out.println("Outgoing VCI: " + outgoingVCI3);
		System.out.println("");
		outgoingVCI2 = 22;//Switch 3 sends acknowledgement to Switch 2 using that contains 22 as incoming VCI.
		switchTwoAcknowledgement(outgoingVCI2);
	}//end switchThreeAcknowledgement

	public static void switchTwoAcknowledgement(int outgoingVCI2){
		//Print the table.
		System.out.println("Setup Acknowledgement Switch 2");
		//The first three columns are completed from the request. 
		//The final is being updated with the outgoing VCI data.
		System.out.println("Incoming Port: " + incomingPort2);
		System.out.println("Incoming VCI: " + incomingVCI2);
		System.out.println("Outgoing Port: " + outgoingPort2);
		System.out.println("Outgoing VCI: " + outgoingVCI2);
		System.out.println("");
		outgoingVCI1 = 66;//Switch 2 sends acknowledgement to Switch 1 using that contains 66 as incoming VCI.
		switchOneAcknowledgement(outgoingVCI1);
	}//end switchTwoAcknowledgement

	public static void switchOneAcknowledgement(int outgoingVCI1){
		//Print the table.
		System.out.println("Setup Acknowledgement Switch 1");
		//The first three columns are completed from the request. 
		//The final is being updated with the outgoing VCI data.
		System.out.println("Incoming Port: " + incomingPort1);
		System.out.println("Incoming VCI: " + incomingVCI1);
		System.out.println("Outgoing Port: " + outgoingPort1);
		System.out.println("Outgoing VCI: " + outgoingVCI1);
		System.out.println("");
		//Switch 1 contains VCI 14 which it can send to Source A.
	}//end switchOneAcknowledgement
}//end






