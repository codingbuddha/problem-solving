
public class CheckTwoBTsEqual{

public boolean checkTwoBTsEqual(TreeNode node1, TreeNode node2){
		
	if(node1 == null && node2 == null)
	return true;
		
	if(node1 != null && node2 != null){
	 return 
	(
		node1.data == node2.data && 
		checkTwoBTsEqual(node1.left, node2.left) && 
		checkTwoBTsEqual(node1.right, node2.right)
	);
	}
	
	return false;
}
public static void main(String[] args){
	
	TreeNode node1 = TreeUtils.createBST();
	TreeNode node2 = TreeUtils.createBST();
	
	CheckTwoBTsEqual p = new CheckTwoBTsEqual();
	
	
	System.out.println("Are given two binary trees are equal: " + p.checkTwoBTsEqual(node1, node2));
	//TreeUtils.printInOrder(node1);	
	//TreeUtils.printInOrder(node2);
	
	
}
}