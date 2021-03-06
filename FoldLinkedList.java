public class FoldLinkedList {

	public static void main(String argv[])
	{
		Node a = new Node(1);
		Node b = new Node(2);
		Node c = new Node(3);
		Node d = new Node(4);
		Node e = new Node(5);
		Node f = new Node(6);
		Node g = new Node(7);
		Node h = new Node(8);
		Node i = new Node(9);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		f.next = g;
		g.next = h;
		h.next = i;
		System.out.println("Linkedlist before Folding: ");
		a.printLinkedList();
		foldLinkedList(a);
		System.out.println();
		System.out.println("LinkedList after Folding: ");
		a.printLinkedList();
	}
	
	public static void foldLinkedList(Node head)
	{
		Node slowPointer = head;
		Node fastPointer = head;
		while(fastPointer != null)
		{
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next;
			if(fastPointer != null)
				fastPointer = fastPointer.next;
		}
		//Node middlePointer = slowPointer;
		Node reverseLeftHalf = reverseLinkedList(slowPointer);
		while(reverseLeftHalf != null && head != null)
		{
			Node tempHead = head.next;
			Node tempReverse = reverseLeftHalf.next;
			
			reverseLeftHalf.next = head.next;
			head.next = reverseLeftHalf;
			
			head = tempHead;
			reverseLeftHalf = tempReverse;
		}
		if(reverseLeftHalf != null)
			reverseLeftHalf.next = null;
		else
			head.next = null;
	}
	public static Node reverseLinkedList(Node head)
	{
		
		if(head.next != null)
			return head;
		Node newHead = reverseLinkedList(head.next);
		head.next.next = head;
		head.next = null;
		return newHead;
	}
}

class Node
{
	public Node next;
	public int value;
	
	public Node(int value)
	{
		this.value = value;
	}
	public void printLinkedList()
	{
		Node head = this;
		while(head!= null)
		{
			System.out.print(head.value + ", ");
			head = head.next;
		}
	}
}
/*
Problem

Fold a linked list such that the last element becomes second element, last but one element becomes 4 th element and so on. 
For example input linked list: 1->2->3->4->5->6->7->8->9-> output linked list 1->9->2->8->3->7->4->6->5->

Solution

Find the middle of the linked list. You can do it by slow and fast pointer approach. 
Start two pointers from head. Advance one pointer at a rate of one node per iteration. Let's call it slow pointer. 
Advance another pointer at a rate of two nodes per iteration. Let's call it fast pointer. 
When the fast pointer will reach the end of the linked list, the slow pointer will be at the middle of the linked list. 
After finding the middle node, we reverse the right half. then we do a in place merge of the two halves of the linked list.
*/
