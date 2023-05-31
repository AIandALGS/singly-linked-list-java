package singly_linked_list_prj;

public class Main {
	public static <T> void main(String args[]) {
		SinglyLinkedList<T> sll = new SinglyLinkedList<T>();
		
		
		for (int i = 0; i < 10; i++) {
			sll.append((T) (Integer) i);
		}
		
		System.out.println("Linked list with " + sll.size() + " elements:");
		sll.print();
			
		sll.insert(5, (T)(Integer)30);
		System.out.println("Linked list after inserting an element:");
		sll.print();
		
		sll.removeFirst();
		System.out.println("Linked list after removing the first element:");
		sll.print();
		
		sll.removeLast();
		System.out.println("Linked list after removing the last element:");
		sll.print();
		
		sll.remove(5);
		System.out.println("Linked list after removing the fifth last element:");
		sll.print();
		
		sll.reverse();
		System.out.println("Linked list after reversing the linked list:");
		sll.print();
		
		
	}
}
