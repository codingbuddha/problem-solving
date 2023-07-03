public class PrintAllNonIncreasingSequencesSumEqualToX{

	public void printArray(int[] arr, int index){
		
		for(int i = 0; i < index ; i++)
		System.out.print(" " + arr[i]);
		System.out.println();
	}
	public void printNonIncreasingSequence(int x, int[] seq, int index, int prev){
		if(x==0)
		{
			printArray(seq, index);
			return;
		}
		for(int i = 1 ; i <= x ; i++){
			if(i <= prev){				
				seq[index] = i;
				printNonIncreasingSequence(x-i, seq, index + 1, i);				
			}
		}
		
	}
	public static void main(String[] args){
		PrintAllNonIncreasingSequencesSumEqualToX p = new PrintAllNonIncreasingSequencesSumEqualToX();
		int x = 4;
		int prev = 4;
		int[] seq = new int[x];
		int index = 0;
		p.printNonIncreasingSequence(x, seq, index, prev);
	}
}