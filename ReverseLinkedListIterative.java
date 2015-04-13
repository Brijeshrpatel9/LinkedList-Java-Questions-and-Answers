
public class ReverseLinkedListIterative {

	public static void main(String argv[])
	{
		Node a = new Node(4);
		Node b = new Node(3);
		Node c = new Node(12);
		Node d = new Node(6);
		Node e = new Node(9);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		System.out.println("Linked List before reversion");
		a.printLinkedList();
		

		Node head = reverseLinkedList(a);
		System.out.println("Reversed Linked List");

		head.printLinkedList();
		
	}
	public static Node reverseLinkedList(Node head)
	{

		Node next = null;
		Node prev = null;
		Node current = head;
		while(current!=null)
		{
			next = current.next;
			System.out.println(next.value);
			current.next = prev;
			//System.out.println(current.next.value);
			prev = current;
			System.out.println(prev.value);
			current = next;
			System.out.println(current.value);
		}
		return prev;
	}
	static class Node
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
			System.out.println();
				
		}
	}

}
