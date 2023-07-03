

public class InOrderTraversalWithoutRecursion{
	
	/*
	1. Initialize current as root 
	2. While current is not NULL
	   If current does not have left child
	      a) Print current’s data
	      b) Go to the right, i.e., current = current->right
	   Else
	      a) Make current as right child of the rightmost node in current's left subtree
	      b) Go to this left child, i.e., current = current->left
		
	*/
	public void inOrderTraversal(TreeNode root){
		
		TreeNode current, predecessor;
		if(root == null)
		return;
		
		current = root;
		       while (current != null) {
			    if (current.left == null) {
				System.out.print(current.data + " ");
				current = current.right;
			    } else {
		 
				/* Find the inorder predecessor of currentNode */
				predecessor = current.left;
				while (predecessor.right != null && predecessor.right != current) {
				    predecessor = predecessor.right;
				}
		 
				/* Make currentNode as right child of its inorder predecessor */
				if (predecessor.right == null) {
				    predecessor.right = current;
				    current = current.left;
				} 		 
				 /* Revert the changes made in if part to restore the original tree i.e., fix the right child of predecessor */ 
				 else {
				    predecessor.right = null;
				    System.out.print(current.data + " ");
				    current = current.right;
				}   /* End of if condition predecessor->right == NULL */
				 
			    } /* End of if condition current->left == NULL*/
             
        } /* End of while */
						
	}
	public static void main(String[] args){
		
		TreeNode root = TreeUtils.createBST();
		InOrderTraversalWithoutRecursion p = new InOrderTraversalWithoutRecursion();
		p.inOrderTraversal(root);
		
	}
}