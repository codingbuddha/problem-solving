

public class ClosestPairInTwoSortedArray{

	public void getClosestPair(int[] arr1, int[] arr2, int X){
		
		int diff = Integer.MAX_VALUE;
		int resR = -1, resL = -1;
		int l = 0, r = arr2.length - 1;
		
			while( l < arr1.length && r >= 0){					
				if( Math.abs(arr1[l] + arr2[r] - X) < diff){  
					diff = Math.abs(arr1[l] + arr2[r] - X);
					resL = l;
					resR = r;
				}					
				if(arr1[l] + arr2[r] > X) r--;
				else l++;
			}		
		System.out.println("Closest pair: [ " + arr1[resL] + ", " + arr2[resR] + "]");		
	}
	public static void main(String[] args){
		
		int[] arr1 = {1,4,5,7};  
		int[] arr2 = {100,400,500,700};		
		int[] arr3 = {10,20,30,40};
		
		ClosestPairInTwoSortedArray cp = new ClosestPairInTwoSortedArray();
		cp.getClosestPair(arr1, arr3, 50);
		cp.getClosestPair(arr2, arr3, 379);
		cp.getClosestPair(arr2, arr1, 379);
		
		
	}
}