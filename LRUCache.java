import java.util.*;
class DoublyListNode{
	int data;
	DoublyListNode next;
	DoublyListNode prev;
	
	public DoublyListNode(int data){
		this.data = data;
	}
}

public class LRUCache{
	Map<Integer, DoublyListNode> map = new HashMap<Integer, DoublyListNode>(); 	
	DoublyListNode head = null, end = null;
	int size;
	
	public LRUCache(int size){
		this.size = size;
	}
	//when new page comes
	public void referencePage(int pageNumber){
		DoublyListNode node = map.get(pageNumber);
		if(node == null){
			DoublyListNode newNode = new DoublyListNode(pageNumber);
			//check if cache is full
			if(map.size() >= size){
				map.remove(end.data); 
				remove(end); addFirst(newNode);
			}
			else{
				addFirst(newNode); 
			}
			map.put(pageNumber, newNode);
		}else{
			remove(node); addFirst(node);
		}
		
	}
	
	//add a node to front of list
	public void addFirst(DoublyListNode node){
		node.next = head;
		if(head != null) head.prev= node;
		head = node;
		if(end == null) end = head;
	}
	
	public void remove(DoublyListNode node){
		if(node.prev != null)
			node.prev.next = node.next;
		else 
			head = node.next;
		
		if(node.next!=null)
			node.next.prev = node.prev;
		else//if it is last node
			end = node.prev;
	}
	
	//print cache
	public void print(){
		DoublyListNode temp = head;
		System.out.println("Pages from most recently to least recently:");
		while(temp!=null){
			System.out.print(temp.data + " ");
			temp = temp.next;
		}	
		System.out.println();	
	}
	public static void main(String[] args){
		LRUCache cache = new LRUCache(5);
		cache.referencePage(1); cache.referencePage(2); cache.referencePage(3); cache.print();	
		
		cache.referencePage(1); cache.referencePage(4); cache.print();
		
		cache.referencePage(5); cache.print();
		
		cache.referencePage(7);
		
		
		cache.print();
		
	}

}