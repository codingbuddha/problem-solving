import java.io.*;
import java.util.*;

class Graph{
	
	int V;  //No. of vertices
	private LinkedList<Integer> adj[];  //Adjacency lists
	
	public Graph(int n){
		V = n;
		//adj = new LinkedList<Integer>[n]; Java doesn't allow creation of generic array.
		adj = new LinkedList[n];
		for(int i=0; i<n ;i++)
			adj[i] = new LinkedList<Integer>();
	}
	
	public void addEdge(int u, int v){
		adj[u].add(v); // Autoboxing
	}
	
	public void printGraph(){
		
		for(int i=0; i<V; i++){
			System.out.println(adj[i]);
		}
	}
	
	public void BFS(int source){
			
			Queue<Integer> queue = new LinkedList<Integer>();
			boolean[] visited = new boolean[V];
			
			queue.add(source);
			visited[source] = true;
			
			while(!queue.isEmpty()){
				Integer front = queue.remove();
				System.out.print(front + " ");
				
				for(Integer v : adj[front]){
					if(visited[v] == false){
						queue.add(v);
						visited[v] = true;
					}						
				}
			}
										
	}
	public static void main(String[] args){
		
		Graph g = new Graph(4);
		g.addEdge(0,1);
		g.addEdge(0,2);
		g.addEdge(1,2);
		g.addEdge(2,0);
        g.addEdge(2,3);
        g.addEdge(3,3);
 
		g.printGraph();
		System.out.println("BFS Traversal starting at node 2:");
		g.BFS(2);
	}
}
