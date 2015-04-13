
public class ReverseKNodes {

	public static void main(String argv[])
	{
		int[] array = { 4, 5, 3, 6, 8, 3, 5, 7, 3, 7, 9, 4, 6 };
		Node head = createLinkedList(array);
		System.out.println("Int array to LinedList: ");
		
		printLinkedList(head);
		System.out.println();
		System.out.println("Linkedlist after reversing k nodes: ");
		head = reverse(head, 4);
		printLinkedList(head);
	}
	public static Node reverse(Node head, int k)
	{
		Node current = head;
		Node next = null;
		Node prev = null;
		int count = 0;
		while(current!=null && count < k)
		{
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count++;
		}
		if(next!= null)
		{
			head.next = reverse(next, k);
		}
		return prev;
	}
	public static void printLinkedList(Node head)
	{
		while(head != null)
		{
			System.out.print(head.value + ", ");
			head = head.next;
		}
		System.out.println();
	}
	
	public static Node createLinkedList(int[] array)
	{
		Node current = null;
		Node head = null;
		for(int element: array)
		{
			if(head == null)
			{
				head = new Node(element);
				current = head;
			}
			else
			{
				current.next = new Node(element);
				current = current.next;
			}
		}
		return head;
	}
	static class Node
	{
		public Node next;
		public int value;
		
		public Node(int value)
		{
			this.value = value;
		}
	}
}
