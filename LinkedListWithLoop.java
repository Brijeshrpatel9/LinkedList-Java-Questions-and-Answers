
public class LinkedListWithLoop {

	public static void main(String argv[])
	{
		Node head = new Node(1);
		Node middle = head.append(2).append(3).append(4).append(5);
		Node tail = middle.append(6).append(7).append(8).append(9).append(10);
		tail.next = middle;
		findLoopInLinkedList(head);
	}
	public static void findLoopInLinkedList(Node head)
	{
		Node slowPointer = head;
		Node fastPointer = head;
		boolean isLooped = false;
		while(fastPointer != null && fastPointer.next != null)
		{
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
			if(slowPointer == fastPointer)
			{
				isLooped = true;
				break;
			}
		}
		if(isLooped)
		{
			System.out.println("LinkedList is looped");
			fastPointer = fastPointer.next;
			int count = 1;
			while( slowPointer != fastPointer)
			{
				fastPointer = fastPointer.next;
				count++;
			}
			System.out.println("Loop Length: " + count);
			slowPointer = head;
			fastPointer = head;
			while(count-- > 0)
			{
				fastPointer = fastPointer.next;
			}
			while(slowPointer != fastPointer)
			{
				slowPointer = slowPointer.next;
				fastPointer = fastPointer.next;
			}
			System.out.println("Loop starting point: " + slowPointer.value);
		}
		else
		{
			System.out.println("LinkedList is NOT looped.");
		}
	}
	
	
	static class Node
	{
		public int value;
		public Node next;
		
		public Node(int value)
		{
			this.value = value;
		}
		public Node append(int value)
		{
			Node newNode = new Node(value);
			next = newNode;
			return newNode;
		}
	}
}
