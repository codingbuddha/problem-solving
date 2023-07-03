public class ConstructBSTFromPreOrder{	

	//Quadratic solution
	public static TreeNode createBST(int[] arr, int low, int high){
		TreeNode root = new TreeNode(arr[low]);
		if(low == high)
			return root;
		
		int l=-1,r=-1,flag = 0;	
		for(int i = low+1; i <= high ; i++){
			if(arr[i]<arr[low] && flag != 1){
				l = i; flag = 1;
			}
			if(arr[i]>arr[low]){
				r = i; break;
			}					
		}
		if(l != -1) root.left = createBST(arr, l, r-1);
		if( r != -1) root.right = createBST(arr, r, high);
		
		return root;
	}
	//Quadratic Solution Improved code: less variables
	public static TreeNode createBST(int[] arr, int low, int high){
		if(low>high) return null;
		
		TreeNode root = new TreeNode(arr[low]);
		if(low == high)
			return root;
		
		int separator = high+1;	
		for(int i = low+1; i <= high ; i++){
			if(arr[i]>arr[low]){
				separator = i; break;
			}
		}
		
		root.left = createBST(arr, low+1, separator-1);		
		root.right = createBST(arr, separator, high);		
		return root;
	}
	
	public static void main(String[] args){
		int[] arr ={10,5,1,7,40,50};
		TreeNode root = createBST(arr,0,arr.length-1);
		TreeUtils.printInOrder(root);
	}
}