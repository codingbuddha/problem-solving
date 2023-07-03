

import java.util.List;


public class ListDriver {

    public static void main(String[] args) {
	  List<ListNode> lists = LinkedListUtils.createTwoIntersectedLinkedList();
	    
	    ListNode headA = lists.get(0);
	    ListNode headB = lists.get(1);
	    
//	    System.out.println(getIntersectionNode(headA, headB).data);
	  ListNode head = reverse(headA);
	  printList(head);
	    
    }
    
//    Hint: prevNode and nextNode
    public static ListNode reverse(ListNode head){
	ListNode prevNode = null, nextNode ;
	
	while(head != null){
	    nextNode = head.next;
	    head.next = prevNode;
	    prevNode = head;   //Be aware about order of below two statements
	    head = nextNode;
	}
	return prevNode;
    }

    
    public static void printList(ListNode head){
	ListNode temp;
	temp = head;
	while(temp!=null){
	    System.out.println(temp.data);
	    temp = temp.next;
	}
    }
}
