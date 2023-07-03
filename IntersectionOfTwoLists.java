import java.util.*;

public class IntersectionOfTwoLists{
	
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB){
	int len1 = 0, len2 = 0;
	int diff;
	ListNode temp1;
	ListNode temp2;
	//Calculate length for first list
	len1 = LinkedListUtils.calculateLength(headA);
	//Calculate length for second list
	len2 = LinkedListUtils.calculateLength(headB);
	
	temp1 = headA;
	temp2 = headB;
	//Decide and move pointer of bigger list to move forward
	if(len1 > len2){
	    diff = len1 - len2;
	    while(diff !=0){
		temp1 = temp1.next;
		diff--;
	    }
	}
	else{
	    diff = len2 - len1;
	    while(diff !=0){
		temp2 = temp1.next;
		diff--;
	    }
	}
		
	while(temp1.next != temp2.next){
		temp1 = temp1.next;
		temp2 = temp2.next;
	}
	
	if(temp1.next != null)
		return temp1.next;
	else
		return null;
    }
    
	public static void main(String[] args){
	
		IntersectionOfTwoLists p = new IntersectionOfTwoLists();
		 List<ListNode> lists = LinkedListUtils.createTwoIntersectedLinkedList();
	    
		ListNode head1 = lists.get(0);
		ListNode head2 = lists.get(1);
		
		LinkedListUtils.printList(head1);
		LinkedListUtils.printList(head2);
		ListNode inode = getIntersectionNode(head1, head2);
		
		if(inode != null)
		System.out.println("Intersection node of value: " + inode.data);
		else
	        System.out.println("No intersection found");
	}
}