

public class BinaryST {
	
	//This class was given for the assignment.
	class Node {
		int data;
		Node left;
		Node right;	
		public Node(int data){
			this.data = data;
			left = null;
			right = null;
		}
	}//close Node class
	
	public static  Node root;
	
	//constructor
	public BinaryST() {
		this.root = null;
	}
	
	//Here is the insert() method
	   void insert(int n) {
	       root = insertMeth(root, n);
	    }
	    Node insertMeth(Node root, int data) {
	        if (root == null) {
	            root = new Node(data);
	            return root;
	        }
	        if (data < root.data) {//Per assignment instructions, 
				//nodes smaller than root go to the left of the root.
	            root.left = insertMeth(root.left, data);
	        }
	        else if (data > root.data) {//Additionally, 
				//nodes greater than root go to the right of the root.
	            root.right = insertMeth(root.right,data);
	        }
	        return root;
	    }//close insertMeth()
	
	//Here is the find() method
	public boolean find(int n) {
		Node currentNode = root;
		while(currentNode != null) {
			if(currentNode.data == n) {
				return true;
			}
			else if(currentNode.data > n) {
				currentNode = currentNode.left;
			}
			else {
				currentNode = currentNode.right;
			}
		}
		return false;
	}//close find()
	
	//Here is the delete() method
    void delete(int n) {
        root = deleteMeth(root, n);
    }//close delete()
    Node deleteMeth(Node root, int n) {
        if (root == null) { 
        	return root;
        }
        if (n < root.data) {
            root.left = deleteMeth(root.left, n);
        }
        else if (n > root.data) {
            root.right = deleteMeth(root.right, n);
        }
        else {
            if (root.left == null) {
                return root.right;
            }
            else if (root.right == null) {
                return root.left;
            }
            root.right = deleteMeth(root.right, root.data);
        }
        return root;
    }//close deleteMeth()
	
	//Here is the display() method
	public void display(Node root) {
		if(root != null){
			display(root.left);
			System.out.println(" " + root.data);
			display(root.right);
		}
	}//close display()
	
	//Here is a small driver program to test the BST
	public static void main(String arg[]) {
		BinaryST value = new BinaryST();
		value.insert(1);
		value.insert(2);
		value.insert(3);
		value.insert(4);
		value.insert(5);
		value.insert(6);
		value.insert(7);
		value.insert(8);
		value.insert(9);
		value.insert(10);
		System.out.println("Tree : ");
		value.display(value.root);		
		System.out.println("");
		System.out.println("Does node with a 9 exist? : " + value.find(9));
		System.out.println("DELETE 9");
		value.delete(9);
		System.out.println("Does node with a 9 exist now? : " + value.find(9));
		System.out.println("");
		System.out.println("Tree : ");
		value.display(value.root);		
		System.out.println("");
		System.out.println("Does node with a 11 exist? : " + value.find(11));
		System.out.println("INSERT 11");
		value.insert(11);
		System.out.println("Does node with a 11 exist now? : " + value.find(11));
		System.out.println("");
		System.out.println("Tree : ");
		value.display(value.root);	
	}//close main
}//close BinaryST
