
public class Person {
	
	private String firstName;				//Store the first name
	private String lastName;				//Store the last name
	public Person() {					//Default constructor
		firstName = "";
		lastName = "";
	}							//Constructor with parameters
	public Person(String first, String last) {
		setName(first, last);
	}							//Method to output the first name and last name
	public String toString() {
		return (firstName + " " + lastName);
	}							//Method to set firstName and lastName
	public void setName(String first, String last) {
		firstName = first;
		lastName = last;
	}							//Method to return the firstName
	public String getFirstName() {
		return firstName;
	}							//Method to return the lastName
	public String getLastName() {
		return lastName;
	}
	
}//close Person class

/****************************************************************************************************************/
public class ResearchConsultant extends Person{

	private static double regularPayRate;
	private double overtimePayRate;
	private double hoursWorked;
	
	public ResearchConsultant() {
		super();
		regularPayRate = 25.00;
		overtimePayRate = regularPayRate * 1.5;
		hoursWorked = 0;
	}
	
	public String toString() {
		return (super.toString() + "'s wages are: $" + String.format("%.2f", calculatePay()));
	}
	
	public double calculatePay(){
		double calculatePay = 0;
		if(hoursWorked <= 30){
			calculatePay = regularPayRate * hoursWorked;
		}
		else if (hoursWorked > 30){
			double firstThirtyHours = (30 * regularPayRate);
			double leftOver = hoursWorked - 30;
			double hoursLeft = leftOver * overtimePayRate;
			calculatePay = firstThirtyHours + hoursLeft;
		}
		return calculatePay;
	}
	
	public static double getPayRate(){
		return regularPayRate;
	}
	
	public double getHoursWorked(){
		return hoursWorked;
	}
	
	public void setNameRateHours(String first, String last, double rate, double hours){
		setName(first, last);
		regularPayRate = rate;
		hoursWorked = hours;
	}
}//close ResearchConsultant

/****************************************************************************************************************/
import java.util.Scanner;

public class TestProgPerson{

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Hello. Please enter the First Name: ");
		String firstName = scan.nextLine();
		System.out.println("Please enter the Last Name: ");
		String lastName = scan.nextLine();
		System.out.println("Please enter Hours Worked: ");
		double hours = scan.nextDouble();
		
		ResearchConsultant rc = new ResearchConsultant();
		
		rc.setNameRateHours(firstName, lastName, ResearchConsultant.getPayRate(), hours);
		rc.calculatePay();
		String message = rc.toString();
		System.out.println(message);
		
	}//close main

}//close TestProgPerson

/***************************************************************************************************************/

public class Node {
     int number;
     Node next;

    public Node(int a){
        this.number = a;
    }
}//close Node

/****************************************************************************************************************/

public class CircularSinglyLinkedList {    
	
    public static void main(String[] args) {
        CircularSinglyLinkedList circList = new CircularSinglyLinkedList();
        System.out.println("We add 0, 1, 2, 3, 4, and 5 to the list.");
        circList.insert(0);
        circList.insert(1);
        circList.insert(2);
        circList.insert(3);
        circList.insert(4);
        circList.insert(5);
        circList.printList();//print the lists
        System.out.println("Here we delete : " + circList.delete());
        circList.printList();//print the lists
        System.out.println("Here we delete : " + circList.delete());
        circList.printList();//print the lists
        System.out.println("Here we delete : " + circList.delete());
        circList.printList();//print the lists
        System.out.println("Here we delete : " + circList.delete());
        circList.printList();//print the lists
        System.out.println("Here we delete : " + circList.delete());
        circList.printList();//print the lists
        System.out.println("Here we delete : " + circList.delete());
        System.out.println(circList.delete());
    }//close main

     Node head;
     Node tail;
     int size = 0;

     //method to return the size of list
    public int getSize() {
        return size;
    }//close getSize

    //Method to insert
    public void insert(int a) {
        Node insert = new Node(a);
        insert.next = tail;
        if (tail == null) {
            tail = insert;
        } else {
            head.next = insert;
        }
        head = insert;
        size++;
    }//close insert
    
    //Method to delete
    public int delete() {
        if (!listEmpty()) {
            Node delete = tail;
            tail = delete.next;
            size--;
            if (size == 0) {
                tail = null;
            }
            head.next = tail;
            return delete.number;
        } else {
            System.out.println("List is empty");
        }
        return 0;
    }//close delete

    public boolean listEmpty() {
        return size == 0;
    }

    public void printList() {
        Node print = tail;
        for (int i = 0; i <= size; i++) {
            if (print != null) {
                System.out.print(print.number);
                print = print.next;
            }//close if-statement
        }//close for-loop
        System.out.println();
    }//close printList

}//close CircularSinglyLinkedList