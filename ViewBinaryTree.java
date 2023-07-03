import java.util.*;


// composite node
class QNode{
	TreeNode item;
	int hd;
	public QNode(TreeNode item, int hd){
		this.item = item;
		this.hd = hd;
	}
} 


public class ViewBinaryTree{
			
	// Map implementation
	public void topViewMapImpl(TreeNode root){
		
		if(root == null)
			return;
		
		Queue<QNode> levelQueue = new LinkedList<QNode>();
		Map<Integer,TreeNode> topNodes = new HashMap<Integer,TreeNode>();
		
		levelQueue.add(new QNode(root,0));
		
		int col = 0;
		while(!levelQueue.isEmpty()){
			
			//Remove the item from Queue
			QNode node = levelQueue.remove();
			
			TreeNode current = node.item;
			TreeNode firstNode = topNodes.get(node.hd);
			
			// If node at particular column is ocurring for the firs time.
			if(firstNode == null)
			topNodes.put(node.hd, current);

			if(current.left != null)
			levelQueue.add(new QNode(current.left, node.hd - 1));
				
			if(current.right != null){
			levelQueue.add(new QNode(current.right, node.hd + 1));		
		}
		
	}
	for( Map.Entry<Integer, TreeNode> entry : topNodes.entrySet()){
			System.out.println(" " + entry.getValue().data);
		}
	}
	
	//TODO : You can use set
		//If a column is fetched for the first time, print the node data
		//else do nothing.
	// why you need to store node in the map, you just display it when first time it occurs.
	public void topViewSetImpl(TreeNode root){
		
		if(root == null)
			return;
		
		Queue<QNode> levelQueue = new LinkedList<QNode>();
		Set<Integer> topNodes = new HashSet<Integer>();		
		levelQueue.add(new QNode(root,0));
		
		int col = 0;
		while(!levelQueue.isEmpty()){			
			//Remove the item from Queue
			QNode node = levelQueue.remove();			
			TreeNode current = node.item;			
			
			// If node at particular column is ocurring for the firs time.
			if(!topNodes.contains(node.hd))
			{
				System.out.println("Column: " + node.hd + ", Data: " + current.data);
				topNodes.add(node.hd);
			}
			
			if(current.left != null)
			levelQueue.add(new QNode(current.left, node.hd - 1));
				
			if(current.right != null){
			levelQueue.add(new QNode(current.right, node.hd + 1));		
		}
		
	}
}	
		
	public static void main(String[] args){
	
		TreeNode root = TreeUtils.createBST();		
		ViewBinaryTree tvbt = new ViewBinaryTree();
		tvbt.topViewSetImpl(root);
		
	}
}
	