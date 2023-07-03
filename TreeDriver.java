

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


public class TreeDriver {

    	private static int  diameter = 0;
    	private static int preIndex = 0;
    	
	public static void main(String[] args) {
	    
	  
	    	TreeNode root = TreeUtils.createBST();
//	    	int[] inOrder = {4, 2, 5, 1, 6, 3};
//	    	int[] preOrder = {1, 2, 4, 5, 3, 6};
//	    	
//	    	TreeNode node = null;
//	    	node =buildBinaryTree(inOrder, preOrder, 0, 5);
//	    	postOrderTraversal(node);
////	    	System.out.println("LCA in binary tree is:" + findLCAInBinaryTree(root, 7, 4));
	    	levelOrderTraversal(root);
//	    	System.out.println("Is it BST: " + checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
//	    	System.out.println(calculateDiameter(root));
//	    	System.out.println("Diamter :" + diameter);
//	    	String st = "kincenvizh";
//	    	System.out.println(substrCalculator(st));
	    	
	    
	}
	
	
//	Inorder sequence: 4 2 5 1 6 3
//	Preorder sequence: 1 2 4 5 3 6
	/*
	      1
	       /   \
	     /       \
	    2        3
	   / \        /
	 /     \    /
	4       5 6 
	*/
	public static void postOrderTraversal(TreeNode node){
	    
		if(node == null)
		return;
	    
	    postOrderTraversal(node.left);
	    postOrderTraversal(node.right);
		System.out.println(node.data);
	    
	}
	
	public static TreeNode buildBinaryTree(int[] inOrder, int[] preOrder, int startIndex, int endIndex){
	    if(startIndex <= endIndex){
		int root = preOrder[preIndex];
		preIndex++;
		int pos = ArrayUtils.findPosition(inOrder, startIndex, endIndex, root);
		TreeNode node = new TreeNode(root);
		node.left = buildBinaryTree(inOrder, preOrder, startIndex, pos - 1);
		node.right = buildBinaryTree(inOrder, preOrder, pos + 1, endIndex);
		return node;
	    }
	    return null;
	}
    	//Hint: find mid and divide
    	public static int binarySearch(int[] A, int low, int high, int x){
	    	int mid;
	    	if(low<=high){
	    	    	mid = low + (high - low)/2;
	    	    	if(x == A[mid])
	    	    	    	return mid;
	    	    	else if(x > A[mid])
	    	    	    	return binarySearch(A, mid+1, high, x);
	    	    	else 
	    	    	    	return binarySearch(A, low, mid-1, x);
	    	}else
	    	    	return -1;
	}
    	//Hint: sum of height of left and right subtree
		//Simple: In recursive call only one parameter is passed.
    	public static int  calculateDiameter(TreeNode root){
	    int leftHeight, rightHeight;  //To store height of left and right subtree of a node.
	    if(root == null)
			return 0;
	    leftHeight = calculateDiameter(root.left);
	    rightHeight = calculateDiameter(root.right);
	   
	    if(leftHeight + rightHeight > diameter)
			diameter = leftHeight + rightHeight;
	    
	    return 1 + Math.max(leftHeight, rightHeight) ;
}
  
    	//Hint: Interval of min and max.
    	public static boolean checkBST(TreeNode node, int min, int max){
		
    	    	if(node == null)
    	    	    return true;
    	    	if( node.data < min || node.data > max)   // check if value is not in between min and max
    	    	    return false;
    	    	if(node.left != null && node.left.data > node.data) // Need to check if left child is null
    	    	    return false;
    	    	if(node.right != null && node.right.data < node.data) // Need to check if right child is null
	    	    return false;
    	   
    	    	return checkBST(node.left, min, node.data) && checkBST(node.right, node.data, max);   // If left returns false, no need to check for right substree
    	}
    	//Hint : Insert into Queue.
	public static void levelOrderTraversal(TreeNode root){
			Queue<TreeNode> q = new LinkedList<>();
			TreeNode temp = null;
			q.add(root);
			
			while(!q.isEmpty()){
					temp = q.peek();
					System.out.println(temp.data);
					q.remove();
					if(temp.left != null)
						q.add(temp.left);
					if(temp.right != null)
						q.add(temp.right);	
			}
		
	}
	
	//Assumption: node with value a and value b exists in the tree.
	//Hint: find, return and receive nodes. 
	public static int findLCAInBinaryTree(TreeNode node, int a, int b){
	    int left, right;
	    if(node == null)
		return 0;  // assuming there are no nodes with value 0 in tree
	    if(node.data == a || node.data== b)  
		return node.data;
	    left = findLCAInBinaryTree(node.left, a, b);
	    right = findLCAInBinaryTree(node.right, a, b);
	    if(left * right != 0)
		return node.data;
	    else
		return (left != 0) ? left : right;
	}
	

	public static long substrCalculator(String st){
	    int start = 0;
	    int end = st.length() ;
	    Set<String> sub = new HashSet<String>();
	    
	    while(start<=end){
		for(int i = end; i >=start  ;i--){
		    sub.add(st.substring(start, i));
		}
		start++;
	    }
	    return sub.size()-1;
	}
	
	


}
