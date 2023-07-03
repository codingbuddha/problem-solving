package helper;

public class Numbers {

  //check for prime
    public static Boolean isPrime(int num){
	    Boolean flag = true;
	    int j;
	    for(j=2; j <= num/2 ; j++){
	    	    if(num%j == 0){
	    		flag = false;
	    		break;
	    	    }
	    	}
	return flag;
    }

}
