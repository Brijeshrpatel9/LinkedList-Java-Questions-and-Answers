public class LinkedListYShape {

	public static void main(String argv[])
	{
		Node head1 = new Node(1);
		Node middle1 = head1.append(2).append(3).append(4).append(5);
		middle1.append(6).append(7).append(8).append(9);
		
		Node head2 = new Node(10);
		Node middle2 = head2.append(11).append(12).append(13).append(14);
		middle2.next = middle1;
		
		findIntersection(head1, head2);
	}
	public static void findIntersection(Node head1, Node head2)
	{
		int count1 = 0;
		int count2 = 0;
		Node pointer1 = head1;
		Node pointer2 = head2;
		
		while(true)
		{
			if(pointer1.next == null)
				break;
			pointer1 = pointer1.next;
			count1++;
		}
		while(true)
		{
			if(pointer2.next == null)
				break;
			pointer2 = pointer2.next;
			count2++;
		}
		boolean isMerged = pointer1 == pointer2;
		if(isMerged)
		{
			System.out.println("The LinkedList are merged (Y shape is formed) ");
			Node larger = head1;
			Node shorter = head2;
			
			if(count1 < count2)
			{
				larger = head2;
				shorter = head1;
			}
			int diff = Math.abs(count1-count2);
			while(diff-- > 0)
			{
				larger = larger.next;
			}
			while(larger != shorter)
			{
				larger = larger.next;
				shorter = shorter.next;
			}
			System.out.println("Common Node: " + larger.value);
		}
		else
		{
			System.out.println("LinkedList are not merged.");
		}
	}

	static class Node {
		
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
