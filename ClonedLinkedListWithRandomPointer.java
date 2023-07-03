public class ClonedLinkedListWithRandomPointer{

	public static LNode getClonedList(LNode head){
		if(head == null) return;
		LNode temp = head, prev = null;
		Map<LNode,LNode> nodemap = new HashMap<LNode,LNode>();
		
		while(temp!=null){
			LNode node = new LNode(temp.data);
			if(prev == null) prev = node;
			else{
				prev.next = node;
				prev = node;
			}
			temp = temp.next;
		}
		temp = head;
		while(temp!=null){
			LNode node = hmap.get(temp);
			LNode arbitNode = hmap.get(temp.arbit);
			node.arbit = arbitNode;
			temp = temp.next;
		}
	}
	public static void main(String[] args){
	
	
	
	}
}