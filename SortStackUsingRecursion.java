import java.util.*;

/* I have used selection sort based approach */

public class SortStackUsingRecursion{
	
	private static int minValue = Integer.MAX_VALUE;
	
	public void sort(Stack<Integer> myStack, int m){
		
		if(m == 5 )
			return;
		m++;
		sort(myStack, m);
		insertAtBottom(myStack, m);
		System.out.println("Current stack: " + myStack);
		minValue = Integer.MAX_VALUE;   // !! must update before you get the next minimum.
	}
	public void insertAtBottom(Stack<Integer> myStack, int n){
		
		if(n == 0){
			myStack.push(minValue);
				System.out.println("min value: " + minValue);
				return;
		}
		
		int data = myStack.pop();
		if( data < minValue)
			minValue = data;
		
		insertAtBottom(myStack, --n);
		
		if(data != minValue)
		myStack.push(data);
	}

	public static void main(String[] args){
		
		Stack<Integer> myStack = new Stack<Integer>();
		
		myStack.push(15);
		myStack.push(84);
		myStack.push(23);
		myStack.push(-33);
		myStack.push(17);
	
		SortStackUsingRecursion s = new SortStackUsingRecursion();
		System.out.println("Current Stack : " + myStack);	
		s.sort(myStack, 0);
		System.out.println("Sorted Stack : " + myStack);	

	}
}