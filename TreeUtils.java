
public class TreeUtils {
	
    		public static void add(TreeNode node, int item){
    		    	TreeNode newNode = new TreeNode(item);
    		    	
    		    	while(true){
    		    	if(item < node.data){
    		    	    	if(node.left == null){
    		    	    	    node.left = newNode;
    		    	    	    break;
    		    	    	}
    		    	    	else
    		    	    	    node = node.left;
    		    	}
    		    	else{
    		    	    	if(node.right == null){
    		    	    	    node.right = newNode;
    		    	    	    break;
    		    	    	}
    		    	    	else
    		    	    	    node = node.right;
    		    	}
    		    	    
    		    }	    
    		    
    		}
		public static TreeNode createBST(){
				TreeNode root = new TreeNode(5);
				/*
				    5
				3        7 
			2	  4    6    8
	     */
		 /*
					5
				3           20 
			2	  4    16        22
					     18		24
							     28
			         		19			
	     */
				
				add(root, 3);
				add(root, 7);
				add(root, 2);
				add(root, 4);				
				add(root, 6);
				add(root, 8);
				add(root, 1);
				add(root, 9);
			
				
				
//				root.left.right.data = 7;  // To check non BST
				return root;
		}
		
		public static TreeNode createBST1(){
				TreeNode root = new TreeNode(5);
				/*
				    5
				3        7 
			2	  4    6    8
	     */
		 /*
					5
				3           20 
			2	  4    16        22
					     18		24
							     28
			         		19			
	     */
				
				add(root, 3);
				add(root, 7);
				add(root, 2);
				add(root, 4);				
				add(root, 6);
				add(root, 18);
				add(root, 1);
				add(root, 9);
			
				
				
//				root.left.right.data = 7;  // To check non BST
				return root;
		}
		
		public static void printLeafNodesFromLeftToRight(TreeNode root){
			
			if(root == null)
			return;
		
			printLeafNodesFromLeftToRight(root.left);
			
			if(root.left == null && root.right == null)
			System.out.print(" " + root.data);
		
			printLeafNodesFromLeftToRight(root.right);
		}
		public static void printInOrder(TreeNode root){
			
			if(root == null)
			return;
			
			printInOrder(root.left);
			System.out.print(" " + root.data);
			printInOrder(root.right);
		}
		
		public static void main(String[] args){
			
			TreeNode root = TreeUtils.createBST();
			TreeUtils.printLeafNodesFromLeftToRight(root);
		}
				
}
