import java.util.*;

public class CloneUndirectedGraph{	
	//TODO: modify if there are cycles in it.
	public static void BFS(UndirectedGraphNode origin){
		if(origin == null) return;
		Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		queue.add(origin);
		while(queue.size()>0){
			UndirectedGraphNode node = queue.remove();
			System.out.print(node.label + " ");
			for(UndirectedGraphNode neighbor : node.neighbors){
				queue.add(neighbor);
			}
		}
	}
	
	public static UndirectedGraphNode cloneGraph(UndirectedGraphNode origin){
		if(origin == null) return origin;
		UndirectedGraphNode clone = new UndirectedGraphNode(origin.label);
		Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		Map<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		map.put(origin,clone);
		queue.add(origin);
		while(queue.size()>0){
			UndirectedGraphNode currNode = queue.remove();
			for(UndirectedGraphNode neighbor : currNode.neighbors){
				if(!map.containsKey(neighbor)){
					UndirectedGraphNode copy = new UndirectedGraphNode(neighbor.label);
					map.get(currNode).neighbors.add(copy);
					map.put(neighbor, copy);
					queue.add(neighbor);
				}else
					map.get(currNode).neighbors.add(map.get(neighbor));
			}
		}
		return clone;
	}
	
	public static void main(String[] args){
		UndirectedGraphNode origin = new UndirectedGraphNode(1);
		UndirectedGraphNode f1 = new UndirectedGraphNode(2);
		UndirectedGraphNode f2 = new UndirectedGraphNode(3);
		UndirectedGraphNode f3 = new UndirectedGraphNode(4);
		origin.neighbors.add(f1);
		origin.neighbors.add(f2);
		origin.neighbors.add(f3);
		UndirectedGraphNode s1 = new UndirectedGraphNode(5);
		UndirectedGraphNode s2 = new UndirectedGraphNode(6);
		UndirectedGraphNode s3 = new UndirectedGraphNode(7);
		f1.neighbors.add(s1);
		f2.neighbors.add(s2);
		f3.neighbors.add(s3);
		
		//Create cycle in the graph.
		//s1.neighbors.add(origin); 
		System.out.print("BFS of original graph: ");
		BFS(origin);
		UndirectedGraphNode clone = cloneGraph(origin);
		System.out.println("BFS of cloned graph: ");
		BFS(clone);
	}

}

class UndirectedGraphNode{
	int label;
	ArrayList<UndirectedGraphNode> neighbors;
	public UndirectedGraphNode(int label){
		this.label = label;
		this.neighbors = new ArrayList<UndirectedGraphNode>();
	}
}
