public class Permutations {
	/**
	Algorithm Paradigm: Backtracking
	Time Complexity: O(n*n!)
	**/
    public void permute(char[] str, int left, int right){
	    
		if(left == right)
		System.out.println(str);
		else{			
			for(int i = left; i <= right ; i++){
				swap(str, left, i);
				permute(str, left+1, right);
				swap(str, left, i);  //backtrack
			}
		}
    }
    
    public void swap(char[] str, int a, int b){
	    
		char temp;
		temp = str[a];
		str[a] = str[b];
		str[b] = temp;
    }
    
    public static void main(String[] args){
		Permutations p = new Permutations();
		String str = "ABC";
		char[] strArr = str.toCharArray();
		p.permute(strArr, 0, strArr.length-1);
	}
}


	