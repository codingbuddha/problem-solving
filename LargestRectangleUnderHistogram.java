import java.util.*;

public class LargestRectangleUnderHistogram{

	public int getMaxArea(int[] hist){		
		// Bars stored in the stack are always in increasing order of their heights.
		Stack<Integer> st = new Stack<Integer>();
		
		int maxArea = 0;
		int top;  // Store top of stack
		int areaWithTop; // To store area with top bar as the smallest bar		
		int i = 0;
		
		while(i < hist.length){			
			if(st.empty() || hist[i] >= hist[st.peek()]){
				st.push(i);
				i++;
			}
			else{
				top = st.peek();
				st.pop();
				
				if(st.empty())
				areaWithTop = hist[top] * i;
				else
				areaWithTop = hist[top] * (i - st.peek() - 1);  // i is the right index and element below top in stack is left index.

				if(areaWithTop > maxArea)
				maxArea = areaWithTop;					
			}
		}
		
		while(!st.empty()){
			top = st.peek();
			st.pop();
			
			// i - (st.peek() + 1) since st.peek() has indexing starting with 0.
			areaWithTop = hist[top] * (st.empty() ? i  : i - st.peek() - 1);
			if(areaWithTop > maxArea)
			maxArea = areaWithTop;			
		}
				
		return maxArea;
	}
	
	public static void main(String[] args){
		LargestRectangleUnderHistogram p = new LargestRectangleUnderHistogram();
		int[] hist = {6, 2, 5, 4, 5, 1, 6};
		//int[] hist = {1,2,3,4};
		System.out.println("Maximum area: " + p.getMaxArea(hist));
	}
}