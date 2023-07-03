import java.util.*;

public class SpiralLevelOrderTraversal{
	public void traverseSpiral(TreeNode root){
		Stack<TreeNode> stack1 = new Stack<TreeNode>();
		Stack<TreeNode> stack2 = new Stack<TreeNode>();
		TreeNode current = null;
		stack1.push(root);
		// If both stacks are empty then stop
		while(!stack1.isEmpty() || !stack2.isEmpty()){
			while(!stack1.isEmpty()){
				current = stack1.pop();
				System.out.println("S1: " + current.data);
				if(current.left != null)  stack2.push(current.left);
				if(current.right != null) stack2.push(current.right);
			}			
			while(!stack2.isEmpty()){				
				current = stack2.pop();
				System.out.println("S2: " + current.data);
				if(current.left != null)  stack1.push(current.right);
				if(current.right != null) stack1.push(current.left);
			}
		}
	}
	
	public static void main(String[] args){	
		TreeNode root = TreeUtils.createBST();
		SpiralLevelOrderTraversal problem = new SpiralLevelOrderTraversal();
		problem.traverseSpiral(root);
	}
}