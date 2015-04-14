public class LinkedListKthElementFromEnd {
	
	public static void main(String argv[])
	{
		Node head = new Node(1);
		head.append(2).append(3).append(4).append(5).append(6).append(7).append(8).append(9);
		Node result = findKthElement(head, 4);
		System.out.println(result.value);
	}
	
	public static Node findKthElement(Node head, int k)
	{
		System.out.println(k + "th element from end ");
		Node ahead = head;
		while(k-- > 0)
			ahead = ahead.next;
		while(ahead != null)
		{
			head = head.next;
			ahead = ahead.next;
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
		
		public Node append(int value)
		{
			Node n = new Node(value);
			next = n;
			return n;
		}
	}
}
