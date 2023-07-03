public class LongestSubstringWithNonRepeatedCharacter{

	public void flushPreviousSubStringFromMap(int[] letterMap, int start, int end, char[] word){	
		for(int i = start ; i <= end ; i++){
		letterMap[word[i] - 'a'] = -1;
	}
}

public String findLongestSubstringWithNonRepeatedCharacter(String str){
	char[] word = str.toCharArray();
	int i = 0, j = 0, low=0, high=0;
	int maxRange = Integer.MIN_VALUE;
	int[] letterMap = new int[26];  // Assuming word contains 26 lower case letters of english language
	
	for(int k = 0 ; k <= letterMap.length - 1 ; k++)
	letterMap[k] = -1;
					
	while(j < word.length){		
		if(letterMap[word[j] - 'a'] == -1){
			letterMap[word[j] - 'a'] = j; j++;
		}
		else{
			low = i; high = j - 1;
			if(high - low > maxRange){
				maxRange = high - low;				
			i = letterMap[word[j] - 'a'] + 1;
			flushPreviousSubStringFromMap(letterMap,low, letterMap[word[j] - 'a'],word);						
			j++;
			}
		}
	}	
	return new String(word).substring(low, high + 1);
	}
	
	/*
	No need to flush the map
	*/
	public int findLongestNRCSOptimized(char[] word){
		int[] visited = new int[256];		
		for(int i = 0 ; i < visited.length ; i++) visited[i] = -1;
		
		int prevIndex, currLen = 0, maxLen = Integer.MIN_VALUE;
		for(int i = 0 ; i < word.length ; i++){
			prevIndex = visited[word[i]];			
			if(prevIndex == -1 || currLen < i - prevIndex ) currLen++;
			else{				
				if(currLen > maxLen) maxLen = currLen;	
				currLen = i - prevIndex;
			}
			visited[word[i]] = i;
		}		
		if(currLen > maxLen) maxLen = currLen;			
		return maxLen;
	}
	
	public static void main(String[] args){
	
		LongestSubstringWithNonRepeatedCharacter sub = new LongestSubstringWithNonRepeatedCharacter();
		//String sample = "japanese";
		String sample = "ABCADEFGABC";
		//System.out.println("Longest substring with non repeated character: " + sub.findLongestSubstringWithNonRepeatedCharacter(sample));
		System.out.println("Length of Longest substring with non repeated character: " + sub.findLongestNRCSOptimized(sample.toCharArray()));
	}
}