/*
 * This program simulates the Distance Vector Algorithm. 
 */


import java.io.*;

public class Assignment7 {
 static int twoDimArray[][],distanceVector[][],route[][];
 static int vertices = 7;//Number of vertices based on Figure 20.5 in the textbook
 static int edges = 9;//Number of edges based on Figure 20.5 in the textbook
 
 //This method calls the others and puts everything together.
 static void distanceVectorRouting(String string){
  System.out.println();
  table();
  updateTable();
  System.out.println(string);
  printTable();
  System.out.println();
 }//end distanceVectorRouting
 
 //This method is used to update the distance vector tables
 static void update_table(int source){
  for(int i = 0; i < vertices; i++){
   if(twoDimArray[source][i] != 9999){
    int distance = twoDimArray[source][i];
    
    for(int j = 0; j < vertices; j++){
    int distance2 = distanceVector[i][j];
     if(route[i][j] == source)
    	 distance2 = 9999;
     if(distance + distance2 < distanceVector[source][j]){
    	 distanceVector[source][j] = distance + distance2;
    	 route[source][j] = i;
     }//end if statement
    }//end for-loop
   }//end if statement
  }//end for-loop
 }//end method
 
 static void updateTable(){
  int k = 0;
  for(int i = 0; i < 4*vertices; i++){
   update_table(k);
   k++;
   if(k == vertices)
    k = 0;
  }//end for-loop
 }//end method
 
 static void table(){
  for(int i = 0; i < vertices; i++){
   for(int j = 0; j < vertices; j++){
    if(i == j){
    	distanceVector[i][j] = 0;
    	route[i][j] = i;
    }
    else{
    	distanceVector[i][j] = 9999;
    	route[i][j] = 100;
    }
   }//end for-loop
  }//end for-loop
 }//end method
 //THis method prints distance vectorrs to console.
 static void printTable(){
  for(int i = 0; i < vertices; i++){
   for(int j = 0; j < vertices; j++){
	   System.out.println(distanceVector[i][j]);
   }//end for-loop
   System.out.println();
  }//end for-loop
 }//end method
 
 public static void main(String args[]) throws IOException {
	  BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	  twoDimArray = new int[vertices][vertices];
	  route = new int[vertices][vertices];
	  distanceVector = new int[vertices][vertices];
	  for(int i = 0; i < vertices; i++)
	   for(int j = 0; j < vertices; j++){
	    if(i == j)
	    	twoDimArray[i][j] = 0;
	    else
	    	twoDimArray[i][j] = 9999;
	   }//end for-loop
	  //Take all necessary inputs from user.
	  for(int i = 0; i < edges; i++){
	   //Go through and enter the Start Node, End Node, and Cost
	   //for each edge.
	   System.out.print("Start Node: ");
	   int source = Integer.parseInt(reader.readLine());
	   source--;
	   System.out.print("End Node: ");
	   int destination = Integer.parseInt(reader.readLine());
	   destination--;
	   System.out.print("Cost: ");
	   int cost = Integer.parseInt(reader.readLine());
	   twoDimArray[source][destination] = cost;
	   twoDimArray[destination][source] = cost;
	  }//end for-loop
	
	  distanceVectorRouting("Distance Vectors (A - G): ");
	 }//end main method
 
}//end
