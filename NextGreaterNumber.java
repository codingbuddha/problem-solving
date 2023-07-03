public class NextGreaterNumber{
	
	public static void swap(char[] number, int a, int b){
		char temp = number[a];
		number[a] = number[b];
		number[b] = temp;
	}
	
	public static String getNextGreaterNumber(char[] number){
		int i;
		for(i=number.length-1; i>=0 ; i--){
			if(number[i-1] < number[i]) break;
		}
		if(i == 0) return new String("Not possible");
		
		int x = i, d = i-1;
		for(int j=i+1 ; j<number.length; j++){
			if(number[j]> number[d] && number[j]< number[x]) 
				x = j;
		}
		
		swap(number,x,d);	
		return new String(number);
	}
	public static void main(String[] args){	
		char[] number = "218765".toCharArray();
		//char[] number = "534976".toCharArray();
		
		//String str = "4321";
		System.out.println("Next greater number with same number of digits: " + getNextGreaterNumber(number));	
	}
}