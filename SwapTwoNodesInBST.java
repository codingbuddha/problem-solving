public class SwapTwoNodesInBST{

	private static TreeNode prev = null, first = null, middle = null, last = null;

	public void rectifyBST(TreeNode root){
		if(root == null) return;
		
		rectifyBST(root.left);
			if(prev != null && prev.data > root.data){ 
				if(first == null){
					first = prev; middle = root;
				}	
				else
					last = root;
			}
	
		prev = root;
		rectifyBST(root.right);		
	}
	public static void main(String[] args){
	
		/** Non adjacent case   10 and 2 are swapped
		/*      6
		      /  \
	         10    2
	        / \   / \
	       1   3 7  12
   
		
    
		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(10);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(12);
		*/
		
		/** adjacent case  10 and 7 are swapped
		/*   6
		   /  \
	         2    7
	        / \   / \
	       1   3 10  12
	
		*/
		
		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(2);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(12);
		
		
		TreeUtils.printInOrder(root);
		SwapTwoNodesInBST p = new SwapTwoNodesInBST();
		p.rectifyBST(root);
		
		if(last == null)
			System.out.println("Swapped adjacent nodes are: " + first.data + "," + middle.data);
		else
			System.out.println("Swapped non adjacent nodes are: " + first.data + "," + last.data);	
		
		//TODO : now swap as well
	}
}