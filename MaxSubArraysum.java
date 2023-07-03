
public class MaxSubArraysum{
	
	public static int getMiddleSubArraySum(int[] arr, int low, int high, int mid){
		int maxRight = Integer.MIN_VALUE;
		int sum = 0;
		for(int i=mid+1; i<=high; i++){
			sum = sum + arr[i];
			if(sum > maxRight)
				maxRight = sum;			
		}
		int maxLeft = Integer.MIN_VALUE;
		sum = 0;
		for(int i = mid; i >= 0; i--){
			sum = sum + arr[i];
			if(sum > maxLeft)
				maxLeft = sum;			
		}		
		return maxLeft + maxRight;		
	}
	
	public static int getMaxSubArraySum(int[] arr, int low, int high){
		//base condition
		if(low == high)
		return arr[low];
		int mid = (low + high)/2;
		int middle = getMiddleSubArraySum(arr, low, high, mid);
		int left = getMaxSubArraySum(arr, low, mid);
		int right = getMaxSubArraySum(arr, mid+1, high);		
		return Math.max(middle, Math.max(left, right));
	}
	
	public static void main(String[] args){	
		int[] arr = {-2,-5,6,-2,-3,1,5,-6};	
		//int[] arr = {1,2};
		
		/** O(nlogn) solution **/
		System.out.println("Maximum subarray sum: " + getMaxSubArraySum(arr, 0, arr.length-1));
		
		//System.out.println(getMiddleSubArraySum(arr,0,arr.length-1,4));
	}
}