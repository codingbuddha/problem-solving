
public class MinStepsToReachDestination{
		
	public int findMinSteps(int x, int pos, int step){
		
		if(pos == x) return step;
		
		if(Math.abs(pos) > Math.abs(x))
		return -1;   
	
		step++;
		int left = findMinSteps(x, pos - step, step);
		int right = findMinSteps(x, pos + step, step);
		
		if(left != -1 && right != -1)
			return Math.min(left, right);
		else if(left!=-1)
			return left;
		else
			return right;
	}
	
	//You can return Integer.MAX_VALUE and then below return simply Math.min(left, right)
	public int findMinStepsOptimized(int x, int pos, int step){		
		if(pos == x) return step;
		if(Math.abs(pos) > Math.abs(x)) return Integer.MAX_VALUE;
	
		step++;
		int left = findMinSteps(x, pos - step, step);
		int right = findMinSteps(x, pos + step, step);
		return Math.min(left,right);
	}
	public static void main(String[] args){
	
		MinStepsToReachDestination p = new MinStepsToReachDestination();
		int x = 4;
		int pos = 0; 
		int step = 0;
		int minSteps = p.findMinSteps(x, pos, step);
		System.out.println("Min number of steps are:" + minSteps);
	}
}
