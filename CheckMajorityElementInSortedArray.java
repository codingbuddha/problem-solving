public class CheckMajorityElementInSortedArray{
	
	public static int findFirstOccurence(int[] arr, int low, int high, int x){		
		if(low<=high){
		int mid = (low + high)/2;		
		//Improvise below two, you dont need to check for mid + 1 which will be taken care in next call
		if(arr[mid] == x && arr[mid-1] < x )
			return mid;
		if(arr[mid] != x && arr[mid+1] == x)
			return mid+1;		
		if(arr[mid] >= x)
			return findFirstOccurence(arr, low, mid-1, x);
		else
			return findFirstOccurence(arr, mid+1, high, x);
		}
		return -1;		
	}
	
	public static boolean isMajorityElement(int[] arr, int x){		
		int firstPos = findFirstOccurence(arr, 0, arr.length/2, x);
		System.out.println("Index of first occurence: " + firstPos);
		return true;
	}
	
	public static void main(String[] args){		
		//int[] arr = {1,2,3,3,3,3,10};
		int[] arr = {1,1,2,4,4,6,6};
		int x = 4;
		System.out.println("Given number is a majority element: " + isMajorityElement(arr, x));	
	}
}