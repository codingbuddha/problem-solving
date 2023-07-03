import java.util.*;
public class RightSideView{
	
	public static List<Integer> rightSideView(TreeNode root){
		List<Integer> result = new ArrayList<Integer>();
		if(root==null) return result;
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(queue.size()>0){
			int size = queue.size();
			for(int i=0; i<size; i++){
				TreeNode node = queue.remove();
				if(i == 0) result.add(node.data);
				if(node.right != null) queue.add(node.right);
				if(node.left != null ) queue.add(node.left);						
			}
		}
		return result;
	}
	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(5);
		/*
    1            
  /   \
 2     3         
/ \     
4  5             
		*/
		List<Integer> rightNodes = rightSideView(root);
		System.out.println(rightNodes);
	}
}


class TreeNode {
	public int data;
	public TreeNode left;
	public TreeNode right;
	
	public TreeNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public TreeNode getLeft() {
		return left;
	}
	public void setLeft(TreeNode left) {
		this.left = left;
	}
	public TreeNode getRight() {
		return right;
	}
	public void setRight(TreeNode right) {
		this.right = right;
	}
}
