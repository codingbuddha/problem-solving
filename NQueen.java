

public class NQueen{
	
	private int[][] board;
	
	public NQueen(int N){
		
		board = new int[N][N];
	}
	
	public void solve(int N){
		
		if(placeQueens(0, N)){
			printBoard(N);
		}else{
			System.out.println("NO SOLUTION EXISTS.");
		}
				
	}
	
	public boolean placeQueens(int queen, int N){
		
		// Place queen one at a time column wise.
		if(queen == N){
			// solution state
			return true;
		}
		
		for(int row = 0 ; row < N ; row++){		
		
			if(canPlaceQueen(board, row, queen)){				
				// place the queen
				board[row][queen] = 1;
				// solve for next queen
				if(placeQueens(queen+1, N))
					return true;
				
				// placement did not work, backtrack
				board[row][queen] = 0;
			}		
		}	
		// When it is not able to place queen is any of the rows.	
		// solution not found here, This is sent to call and backtrack will happen.
		return false;  
	}
	
	public boolean canPlaceQueen(int[][] board, int row, int col){
		
		//since we are filling column wise
		// we need to check the cells efore it in the row.
		
		for(int j=0 ; j < col ; j++){
			if(board[row][j] == 1)
				return false;
		}
		
		// Why did not we check for above cell in column.
		
		//upper left diagonal		
		for(int i=row,j=col; i>=0 && j>=0 ; i--,j--){
			if(board[i][j] == 1)
				return false;
		}		
		//lower left diagonal
		for(int i=row,j=col; i< board.length && j>=0 ; i++,j--){
			if(board[i][j] == 1)
				return false;
		}
	
		return true;
	}
	
	public void printBoard(int N){
		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++)
				System.out.print(" " + board[i][j]);
			System.out.println();	
		}
	}
	public static void main(String[] args){
		int N = 8;
		NQueen problem = new NQueen(N);
		
		problem.printBoard(N);
		
		problem.solve(N);
	}
}