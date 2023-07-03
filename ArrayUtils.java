

public class ArrayUtils {

	//Hint: Divide and conquer
	public static int binarySearch(int[] A, int low, int high, int x){
	    	int mid;
	    	if(low<=high){
	    	    	mid = low + (high - low)/2;
	    	    	if(x == A[mid])
	    	    	    	return mid;
	    	    	else if(x > A[mid])
	    	    	    	return binarySearch(A, mid+1, high, x);
	    	    	else 
	    	    	    	return binarySearch(A, low, mid-1, x);
	    	}else
	    	    	return -1;
	}
	
    public static int findPosition(int[] arr, int start, int end, int x){
	while(start<=end){
	    if(arr[start] == x)
		return start;
	    start++;
	}
	return -1;
    }
}
