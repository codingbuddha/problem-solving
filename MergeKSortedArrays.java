import java.util.*;

class HeapNode{
	int element;
	int arrayIndex;  //Index of array from which element is taken
	int elementIndex;  //Index of element
	
	public HeapNode(int element, int i, int j){
		this.element = element;
		this.arrayIndex = i;
		this.elementIndex = j;
	}
}

public class MergeKSortedArrays{

	public void mergeSortedArrays(int[][] matrix, int k){		
		int cols = matrix[0].length;
		PriorityQueue<HeapNode> heap =  new PriorityQueue<HeapNode>(k, new Comparator<HeapNode>(){
			public int compare(HeapNode h1, HeapNode h2){
				if(h1.element == h2.element)
					return 0;
				else if(h1.element < h2.element)
					return -1;
				else
					return 1;
			}		
		    }		
		);
				
		for(int i=0; i< k; i++)	    
		heap.add(new HeapNode(matrix[i][0], i, 0));		
	
		while(!heap.isEmpty()){					
			HeapNode temp = heap.poll();
			System.out.println(temp.element);
			
			int nextArrayIndex = temp.arrayIndex;
			int nextElementIndex = temp.elementIndex + 1;	
			if(nextElementIndex < cols)
			heap.add(new HeapNode(matrix[nextArrayIndex][nextElementIndex], nextArrayIndex, nextElementIndex));			
		}	
		
	}
	public static void main(String[] args){
		
	int[][] matrix = {  
					{1, 3,  4,  5},
					{2,  4,  6,  8},
					{0, 9, 10, 11} 
						
				};	
	
		MergeKSortedArrays p = new MergeKSortedArrays();
		int k = 3;
		
		p.mergeSortedArrays(matrix, k);
	}
}

	/* Checking 
		Iterator<HeapNode> itr = heap.iterator();
		
		while(itr.hasNext()){
			HeapNode h = itr.next();
			System.out.println(h.element);
			System.out.println(h.nextArrayIndex);
			System.out.println(h.nextElementIndex);
		}
		**/