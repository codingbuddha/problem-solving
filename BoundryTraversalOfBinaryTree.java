public class BoundryTraversalOfBinaryTree{

	public void printBoundry(TreeNode root){
		
		System.out.print(root.data + " ");
		
		// top down manner
		printLeftBoundry(root.left);
		
		printLeaves(root.left);
		printLeaves(root.right);
		// bottom up manner
		printRightBoundry(root.right);
		
	}
	public static void main(String[] args){
		
		BoundryTraversalOfBinaryTree p = new BoundryTraversalOfBinaryTree();
		TreeNode root = TreeUtils.createBST();
		p.printBoundry(root);
	}
}