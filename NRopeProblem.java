import java.util.*;

public class NRopeProblem{
		
		public int bindRopesWithMinimumCost(int[] ropeLengths){
			
			int cost = 0;									
			// By default it uses comparator of Integer class..it keeps values in increasing order		
								
			//Min heap					
			PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
			//In case you wanted max heap.
			//PriorityQueue<Integer> heap = new PriorityQueue<Integer>(Collections.reverseOrder());
			for(int i =0; i < ropeLengths.length; i++)
				heap.add(ropeLengths[i]);
			
			// When there is only one element in heap, mean all ropes have been joined
			while(heap.size() != 1){
				
				int firstMin = heap.poll(); 	
				int secondMin = heap.poll();				
				int newRope = firstMin + secondMin;
				
				cost = cost + newRope;
				heap.add(newRope);	// It internally heapify.			
			}
			return cost;
		}
		
		public static void main(String[] args){
			
				int[] ropeLengths = {4,6,2,3};
				NRopeProblem problem = new NRopeProblem();
				System.out.println("Minimum cost: " + problem.bindRopesWithMinimumCost(ropeLengths));							
		}	
}