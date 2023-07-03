package arrays;

import java.util.HashMap;
import java.util.Map;

import helper.ArrayUtils;

public class Driver {

    public static boolean isDuplicatesPresent(int[] arr){
	Map<Integer, Integer> map = new HashMap<Integer,Integer>();
	Integer value;
	for(int i =0; i< arr.length; i++){
	    value = map.get(arr[i]);
	    if(value == null)
		map.put(arr[i], 1);
	    else if(value.intValue() == 1)
		return true;
	}
	return false;

    }
   
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	int[] arr = { 2, 1, 3, 1, 4};
	System.out.println("Are there any duplicates: " + isDuplicatesPresent(arr));
	System.out.println("Is 4 present in arr: " + ArrayUtils.binarySearch(arr, 0, arr.length-1, 4));
    }
    
    

}
