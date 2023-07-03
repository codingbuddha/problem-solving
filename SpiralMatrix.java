
public class SpiralMatrix{
	
	private static int bottom = 4;
	
	public void printSpiral(int[][] matrix){
		
		int left = 0;
		int right = matrix[0].length - 1;
		int top = 0;
		
		while(left <= right && top <= bottom){
			
			for(int j = left ; j < right ; j++)
				System.out.print(" " + matrix[top][j]);
				
			for(int i = top ; i < bottom ; i++)
				System.out.print(" " + matrix[i][right]);
			
			for(int j = right ; j > left ; j--)
				System.out.print(" " + matrix[bottom][j]);
			
			for(int i = bottom ; i > top ; i--)
				System.out.print(" " + matrix[i][left]);
			
			left++; right--;
			top++; bottom--;
			
		}
	}
	public static void main(String[] args){

		int[][] matrix = {  {1,  2,  3,  4,  5,  6},
							  {7,  8,  9,  10, 11, 12},
							  {13, 14, 15, 16, 17, 18} ,
							  {19,20,21,22,23,24}	 ,
							  {25,26,27,28,29,30},
							  {31,32,33,34,35,36}				  
						   };
					
		SpiralMatrix sm = new SpiralMatrix();
		sm.printSpiral(matrix);
	
}
}