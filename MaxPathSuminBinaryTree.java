public class MaxPathSuminBinaryTree{
	
	public static int maxSum = Integer.MIN_VALUE;
	
	public static int getMaxPathSum(TreeNode root){
		if(root == null) return 0;
		int left = getMaxPathSum(root.left); 
		int right = getMaxPathSum(root.right);
		int maxViaParent = Math.max( Math.max(left,right)+ root.data, root.data);
		int maxWithTop = Math.max(maxViaParent, root.data + left + right);
		maxSum = Math.max(maxWithTop, maxSum);
		return maxViaParent;		
	}
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(10);
		root.left =  new TreeNode(2);
		root.right = new TreeNode(10);
		root.left.left = new TreeNode(20);
		root.left.right = new TreeNode(1);
		root.right.right = new TreeNode(-25);
		root.right.right.left = new TreeNode(3);
		root.right.right.right = new TreeNode(4);
		getMaxPathSum(root);
		System.out.println("Max path sum is: " + maxSum);	
	}
}