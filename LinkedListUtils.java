
import java.util.ArrayList;
import java.util.List;

public class LinkedListUtils {

    	public static ListNode createLinkedList(){
        ListNode head = new ListNode(10);
    	    
    	ListNode node2 = new ListNode(20);
    	head.next = node2; 
    	ListNode node3 = new ListNode(30);
    	node2.next = node3;
    	ListNode node4 = new ListNode(40);
    	node3.next = node4;
    	ListNode node5 = new ListNode(50);
    	node4.next = node5;
    	ListNode node6 = new ListNode(60);
    	node5.next = node6;
    	return head;
    	}
    	
	
	public static List<ListNode> createTwoIntersectedLinkedList(){
        List<ListNode> lists = new ArrayList<>();
	
	
	ListNode head1 = new ListNode(10);
    	    
    	ListNode node2 = new ListNode(20);
    	head1.next = node2; 
    	ListNode node3 = new ListNode(30);
    	node2.next = node3;
    	ListNode node4 = new ListNode(40);
    	node3.next = node4;
    	ListNode node5 = new ListNode(50);
    	node4.next = node5;
    	ListNode node6 = new ListNode(60);
    	node5.next = node6;
    	
	
	ListNode head2 = new ListNode(10);
    	    
    	ListNode nodeA = new ListNode(20);
    	head2.next = nodeA; 
    	ListNode nodeB = new ListNode(30);
    	nodeA.next = nodeB;
	
	//nodeB.next = node4;
	
	lists.add(head1);
	lists.add(head2);
	
	
	return lists;
	
	
	
	
    	}
    	

    	
    	public static int calculateLength(ListNode head){
    	    int len = 0;
    	    ListNode temp = head;
    	    while(temp != null){
    		len++;
    		temp = temp.next;
    	    }
    	    return len;
    	}

		   
    public static void printList(ListNode head){
	ListNode temp;
	temp = head;
	while(temp!=null){
	    System.out.print(" " + temp.data);
	    temp = temp.next;
	}
	System.out.println();
    }
}
