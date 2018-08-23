
import java.util.stream.*;
import java.util.Scanner;

public class Grader {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number of students you have:");
		int numberStudents = scan.nextInt();
		double students[] = new double[numberStudents];
		for (int i = 0; i < students.length; i++) {
			System.out.println("");
			System.out.println("Student "+ (i+1));//Lists the student being computed.
			students[i] = initialGrades();
		}//close for-loop 1
		for (int i = 0; i < students.length; i++) {
			System.out.println();
			System.out.println("Student "+ (i+1));//Lists the student being computed.
			System.out.println("Final Score: " + students[i]);
			if (students[i]>=450){
				System.out.println("Initial Grade: A");
			}
			else if (students[i]>=400 && students[i]<450){
				System.out.println("Initial Grade: B");
			}
			else if (students[i]>=350 && students[i]<400){
				System.out.println("Initial Grade: C");
			}
			else if (students[i]>=300 && students[i]<350){
				System.out.println("Initial Grade: D");
			}
			else{
				System.out.println("Initial Grade: F");
			}
			
		}//close for-loop	
		
		//calculate mean/variance/standard deviation
		double sum = 0;
		for(int j = 0; j < students.length; j++){
			sum = DoubleStream.of(students).sum();
		}
		double mean = sum / students.length;
		double variance = 0;
		for (int i = 0; i < students.length; i++)
		{
		    variance += ((students[i] - mean)*(students[i] - mean)) / (students.length - 1);
		}
		double standardDeviation = Math.sqrt(variance);

		double gradeA = mean + (2*standardDeviation);
		double gradeB = mean + (standardDeviation);
		double gradeC = mean;
		double gradeD = mean - standardDeviation;
		double gradeF = mean - (2*standardDeviation);

		for (int i = 0; i < students.length; i++) {
			System.out.println();
			System.out.println("Student "+ (i+1));//Lists the student being computed.

		if (students[i]>=gradeA){
			System.out.println("Adjusted Grade: A");
		}
		else if (students[i]>=gradeB && students[i]<gradeA){
			System.out.println("Adjusted Grade: B");
		}
		else if (students[i]>=gradeC && students[i]<gradeB){
			System.out.println("Adjusted Grade: C");
		}
		else if (students[i]>=gradeD && students[i]<gradeC){
			System.out.println("Adjusted Grade: D");
		}
		else if (students[i]>=gradeF && students[i]<gradeD){
			System.out.println("Adjusted Grade: F");
		}
		}//close for-loop
	}//close main

	static int initialGrades(){
		Scanner scan = new Scanner(System.in);
		
		int examOne, examTwo, examThree, examFour,
		assignOne, assignTwo, assignThree, assignFour;
		
		//Exam 1
		System.out.println("Please enter the Exam 1 score:");
		examOne = scan.nextInt();
		while(examOne < 0 || examOne > 50){
			System.out.println("Your have entered an incorrect grade. Please try again.");
			System.out.println("Please enter the Exam 1 score:");
			examOne = scan.nextInt();
		}
		//Exam 2
		System.out.println("Please enter the Exam 2 score:");
		examTwo = scan.nextInt();
		while(examTwo < 0 || examTwo > 50){
			System.out.println("Your have entered an incorrect grade. Please try again.");
			System.out.println("Please enter the Exam 2 score:");
			examTwo = scan.nextInt();
		}
		//Exam 3
		System.out.println("Please enter the Exam 3 score:");
		examThree = scan.nextInt();
		while(examThree < 0 || examThree > 50){
			System.out.println("Your have entered an incorrect grade. Please try again.");
			System.out.println("Please enter the Exam 3 score:");
			examThree = scan.nextInt();
		}
		//Exam 4
		System.out.println("Please enter the Exam 4 score:");
		examFour = scan.nextInt();
		while(examFour < 0 || examFour > 50){
			System.out.println("Your have entered an incorrect grade. Please try again.");
			System.out.println("Please enter the Exam 4 score:");
			examFour = scan.nextInt();
		}
		//Assign 1
		System.out.println("Please enter the Assignment 1 score:");
		assignOne = scan.nextInt();
		while(assignOne < 0 || assignOne > 75){
			System.out.println("Your have entered an incorrect grade. Please try again.");
			System.out.println("Please enter the Assignment 1 score:");
			assignOne = scan.nextInt();
		}
		//Assign 2
		System.out.println("Please enter the Assignment 2 score:");
		assignTwo = scan.nextInt();
		while(assignTwo < 0 || assignTwo > 75){
			System.out.println("Your have entered an incorrect grade. Please try again.");
			System.out.println("Please enter the Assignment 2 score:");
			assignTwo = scan.nextInt();
		}
		//Assign 3
		System.out.println("Please enter the Assignment 3 score:");
		assignThree = scan.nextInt();
		while(assignThree < 0 || assignThree > 75){
			System.out.println("Your have entered an incorrect grade. Please try again.");
			System.out.println("Please enter the Assignment 3 score:");
			assignThree = scan.nextInt();
		}
		//Assign 4
		System.out.println("Please enter the Assignment 4 score:");
		assignFour = scan.nextInt();
		while(assignFour < 0 || assignFour > 75){
			System.out.println("Your have entered an incorrect grade. Please try again.");
			System.out.println("Please enter the Assignment 4 score:");
			assignFour = scan.nextInt();
		}
		int finalScore = examOne+examTwo+examThree+examFour+assignOne+assignTwo+assignThree+assignFour;
		return finalScore;
	}//close initialGrades

}//close Grader


/* 
 * *************************************************************GUI**************************************************************
 */
import java.util.stream.*;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Grader {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numberStudents = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of students you have:"));
		double students[] = new double[numberStudents];
		for (int i = 0; i < students.length; i++) {
			JOptionPane.showMessageDialog(null,"Student "+ (i+1));
			students[i] = initialGrades();
		}//close for-loop 1
		for (int i = 0; i < students.length; i++) {
			System.out.println();
			JOptionPane.showMessageDialog(null,"Student "+ (i+1) + "\nFinal Score: " + students[i]);//Lists the student being computed.
			System.out.println("Final Score: " + students[i]);
			if (students[i]>=450){
				JOptionPane.showMessageDialog(null,"Student "+ (i+1) + "\nInitial Grade: A");
			}
			else if (students[i]>=400 && students[i]<450){
				JOptionPane.showMessageDialog(null,"Student "+ (i+1) + "\nInitial Grade: B");
			}
			else if (students[i]>=350 && students[i]<400){
				JOptionPane.showMessageDialog(null,"Student "+ (i+1) + "\nInitial Grade: C");
			}
			else if (students[i]>=300 && students[i]<350){
				JOptionPane.showMessageDialog(null,"Student "+ (i+1) + "\nInitial Grade: D");
			}
			else{
				JOptionPane.showMessageDialog(null,"Student "+ (i+1) + "\nInitial Grade: F");
			}
			
		}//close for-loop	
		
		//calculate mean/variance/standard deviation
		double sum = 0;
		for(int j = 0; j < students.length; j++){
			sum = DoubleStream.of(students).sum();
		}
		double mean = sum / students.length;
		double variance = 0;
		for (int i = 0; i < students.length; i++)
		{
		    variance += ((students[i] - mean)*(students[i] - mean)) / (students.length - 1);
		}
		double standardDeviation = Math.sqrt(variance);

		double gradeA = mean + (2*standardDeviation);
		double gradeB = mean + (standardDeviation);
		double gradeC = mean;
		double gradeD = mean - standardDeviation;
		double gradeF = mean - (2*standardDeviation);

		for (int i = 0; i < students.length; i++) {
			//JOptionPane.showMessageDialog(null,"Student "+ (i+1));

		if (students[i]>=gradeA){
			JOptionPane.showMessageDialog(null,"Student "+ (i+1) + "\nAdjusted Grade: A");
		}
		else if (students[i]>=gradeB && students[i]<gradeA){
			JOptionPane.showMessageDialog(null,"Student "+ (i+1) + "\nAdjusted Grade: B");
		}
		else if (students[i]>=gradeC && students[i]<gradeB){
			JOptionPane.showMessageDialog(null,"Student "+ (i+1) + "\nAdjusted Grade: C");
		}
		else if (students[i]>=gradeD && students[i]<gradeC){
			JOptionPane.showMessageDialog(null,"Student "+ (i+1) + "\nAdjusted Grade: D");
		}
		else if (students[i]>=gradeF && students[i]<gradeD){
			JOptionPane.showMessageDialog(null,"Student "+ (i+1) + "\nAdjusted Grade: F");
		}
		}//close for-loop
	}//close main

	static int initialGrades(){
		Scanner scan = new Scanner(System.in);
		
		int examOne, examTwo, examThree, examFour,
		assignOne, assignTwo, assignThree, assignFour;
		
		//Exam 1
		examOne = Integer.parseInt(JOptionPane.showInputDialog("Please enter the Exam 1 score:"));
		while(examOne < 0 || examOne > 50){
			JOptionPane.showMessageDialog(null,"Your have entered an incorrect grade. Please try again.","Incorrect Input",JOptionPane.ERROR_MESSAGE);
			examOne = Integer.parseInt(JOptionPane.showInputDialog("Please enter the Exam 1 score:"));
			 
		}
		//Exam 2
		examTwo = Integer.parseInt(JOptionPane.showInputDialog("Please enter the Exam 2 score:"));
		while(examTwo < 0 || examTwo > 50){
			JOptionPane.showMessageDialog(null,"Your have entered an incorrect grade. Please try again.","Incorrect Input",JOptionPane.ERROR_MESSAGE);
			examTwo = Integer.parseInt(JOptionPane.showInputDialog("Please enter the Exam 2 score:"));
		}
		//Exam 3
		examThree = Integer.parseInt(JOptionPane.showInputDialog("Please enter the Exam 3 score:"));
		while(examThree  < 0 || examThree  > 50){
			JOptionPane.showMessageDialog(null,"Your have entered an incorrect grade. Please try again.","Incorrect Input",JOptionPane.ERROR_MESSAGE);
			examThree = Integer.parseInt(JOptionPane.showInputDialog("Please enter the Exam 3 score:"));
		}
		//Exam 4
		examFour = Integer.parseInt(JOptionPane.showInputDialog("Please enter the Exam 4 score:"));
		while(examFour  < 0 || examFour  > 50){
			JOptionPane.showMessageDialog(null,"Your have entered an incorrect grade. Please try again.","Incorrect Input",JOptionPane.ERROR_MESSAGE);
			examFour = Integer.parseInt(JOptionPane.showInputDialog("Please enter the Exam 4 score:"));
		}
		//Assign 1
		assignOne = Integer.parseInt(JOptionPane.showInputDialog("Please enter the Assignment 1 score:"));
		while(assignOne  < 0 || assignOne  > 75){
			JOptionPane.showMessageDialog(null,"Your have entered an incorrect grade. Please try again.","Incorrect Input",JOptionPane.ERROR_MESSAGE);
			assignOne = Integer.parseInt(JOptionPane.showInputDialog("Please enter the Assignment 1 score:"));
		}
		//Assign 2
		assignTwo = Integer.parseInt(JOptionPane.showInputDialog("Please enter the Assignment 2 score:"));
		while(assignTwo  < 0 || assignTwo  > 75){
			JOptionPane.showMessageDialog(null,"Your have entered an incorrect grade. Please try again.","Incorrect Input",JOptionPane.ERROR_MESSAGE);
			assignTwo = Integer.parseInt(JOptionPane.showInputDialog("Please enter the Assignment 2 score:"));
		}
		//Assign 3
		assignThree = Integer.parseInt(JOptionPane.showInputDialog("Please enter the Assignment 3 score:"));
		while(assignThree  < 0 || assignThree  > 75){
			JOptionPane.showMessageDialog(null,"Your have entered an incorrect grade. Please try again.","Incorrect Input",JOptionPane.ERROR_MESSAGE);
			assignThree = Integer.parseInt(JOptionPane.showInputDialog("Please enter the Assignment 3 score:"));
		}
		//Assign 4
		assignFour = Integer.parseInt(JOptionPane.showInputDialog("Please enter the Assignment 4 score:"));
		while(assignFour  < 0 || assignFour  > 75){
			JOptionPane.showMessageDialog(null,"Your have entered an incorrect grade. Please try again.","Incorrect Input",JOptionPane.ERROR_MESSAGE);
			assignFour = Integer.parseInt(JOptionPane.showInputDialog("Please enter the Assignment 4 score:"));
		}
		int finalScore = examOne+examTwo+examThree+examFour+assignOne+assignTwo+assignThree+assignFour;
		return finalScore;
	}//close initialGrades

}//close Grader