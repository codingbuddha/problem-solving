
import java.util.HashMap;
import java.util.Map;


public class FindIteneraryFromListOfGivenTickets{
	
	public static void main(String[] args){
		
		Map<String,String> dataset = new HashMap<String,String>();
		Map<String,String> reverseMap = new HashMap<String,String>();
		
		dataset.put("Chennai", "Bangalore");
		dataset.put("Bombay", "Delhi");
		dataset.put("Goa", "Chennai");
		dataset.put("Delhi", "Goa");
		
		//Fill the reverseMap
		for(Map.Entry<String,String> entry : dataset.entrySet())
			reverseMap.put(entry.getValue(), entry.getKey());
			
		String startPoint = null;
		
		//Traverse keys in dataset and check if it is present in reverseMap
		for(String fromCity : dataset.keySet()){
			if(!reverseMap.containsKey(fromCity)){
				startPoint = fromCity;
				break;
			}
		}
		
		System.out.print(startPoint + "->" + dataset.get(startPoint));
		
		//Now traverse and print the itenerary
		for(int i=0; i < dataset.size() - 1 ; i++){
			String nextCity = dataset.get(startPoint);
			System.out.print("," + nextCity + "->" + dataset.get(nextCity));
			startPoint = nextCity;
		}
		
	}
}