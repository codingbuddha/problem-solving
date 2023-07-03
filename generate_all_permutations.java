package strings;

import helper.Strings;

public class Driver {

    public static void generateAllPermutations(char[] word, int len, int pivot){
		int i;
		
		if( pivot == len-1){
		    System.out.println(word);
		    return;
		}
		for(i=pivot; i< len; i++){
		    	Strings.swap(word, pivot, i);
		    	pivot++;
		    	generateAllPermutations(word, len, pivot);
		    	pivot--;
		    	Strings.swap(word,  pivot, i);
		}
	
    }
    public static void main(String[] args) {
	// TODO Auto-generated method stub
		char[] word = { 'A', 'B', 'C'};
		int len = word.length;
		int pivot = 0;
		generateAllPermutations(word, len, pivot);
		
    }

}
