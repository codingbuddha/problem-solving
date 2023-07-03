package numbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import helper.Numbers;

public class Driver {
        private static int[] count = new int[10];
        
        public static int checkNumberPowerOfTwo(int number){
            
            if( number == 0)
        	return 0;
            return number & number-1;
        }
        
        //Hint: bitwise & with 1 gives you rightmost bit 
        public static int countSetBits(int number){
            int count = 0;
            // int is 32 bit
            for(int i =0;i <32; i++){  
        	count = count + (number&1);
        	number = number >>> 1;
            }
            return count;
        }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    
	    System.out.println("number of setbits: "+ countSetBits(5));
	    
		/* You are given 2 integers 'L' and 'R' (L <= R). Your task is to find out the most frequently occurring digit in all prime numbers in the range [L, R], both inclusive. 
		 * If there are multiple digits occurring at the same maximum frequency, then output the largest of them. If there are no prime numbers in the range [L, R], output -1.
		 */
//		findDigitwithMaximumFrequency();
//	    System.out.println("Is number power of 2: "+ checkNumberPowerOfTwo(32));

		
	}

	private static void findDigitwithMaximumFrequency() {
		// TODO Auto-generated method stub
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int i, j ;	
	    
	    try {
		    String T = br.readLine();
		    int t = Integer.parseInt(T);
		    
		    while(t--> 0){
			String[] LR = br.readLine().split(" ");
			int L = Integer.parseInt(LR[0]);
			int R = Integer.parseInt(LR[1]);
			
			for(i=L;i <= R; i++){
			    
			    if(i==1)
				continue;
			    //Initialize count array to 0s
			    for(j=0; j<10; j++)
				count[j]=0;
			    
			    Boolean isPrime = Numbers.isPrime(i);
			    //If number is prime, get individual digits
			    if(isPrime){
				int number = i;
					while(number != 0){
					    int rem = number%10;
					    number = number/10;
					    count[rem]++;
					}
			     }
			}
			    //Iterate over array to find digit with maximum value
			    int max = count[0];
			    int digit = 0;
			    for(i=0;i<10;i++){
				System.out.println(count[i]);
			    	if(count[i] >= max){
			    		max = count[i];
			    		 digit = i;		
			    	}
			    }
			 if(digit == 9 && count[digit] == 0)
			     System.out.println(-1);
			 else
			     System.out.println(digit);
		    }
		} catch (IOException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
	    	
	    								
	}

}
