package singly_linked_list_prj;

public class SinglyLinkedList<T> {
	private Node<T> head;
	private Node<T> tail;
	
	private int count;
	
	public SinglyLinkedList() {
		this.head = null;
		this.tail = null;
		
		this.count = 0;
	}
	
	// O(1) append
	public void append(T value) {
		Node<T> node;
		Node<T> current;
		
		node = new Node<T>(value);
		current = this.tail;
		
		if (current != null) {
			this.tail.setNext(node);
			this.tail = this.tail.getNext();
		} else {
			this.head = node;
			this.tail = node;
		}
		
		this.count++;
	}
	
	// O(1) prepend
	public void prepend(T value) {
		Node<T> node;
		Node<T> current;
		
		node = new Node<T>(value);
		
		current = this.head;
		
		if (current != null) {
			node.setNext(this.head);
			this.head = node;
		} else {
			this.head = node;
			this.tail = node;
		}
		
		this.count++;
	}
	
	// Insert data with O(N)
	public void insert(int position, T value) {
		Node<T> node; 
		Node<T> current;
		
		int idx;
		
		node = new Node<T>(value);
		current = this.head;
		
		if (position == 0) {
			prepend(value);
			return;
		}
		
		if (position >= size()) {
			append(value);
			return;
		}
		
		if (current != null) {
			idx = 0;
			
			while (++idx < position) {
				current = current.getNext();
			}
			
			node.setNext(current.getNext());
			current.setNext(node);
				
			this.count++;
		} else {
			System.out.println("List is empty or position does not exist!");
		}
	}
	
	// Removal of the first node O(1)
	public void removeFirst() {
		if (this.head != null) {
			this.head = this.head.getNext();
			
			this.count--;
		} else {
			System.out.println("List is empty!");
		}
	}
	
	// Removal of the last node O(N)
	public void removeLast() {
		Node<T> current;
		
		current = this.head;
		
		if (current != null) {
			while (!current.getNext().equals(this.tail)) {
				current = current .getNext();
			}

			current.setNext(null);
			this.tail = current;
			
			this.count--;
		} else {
			System.out.println("List is empty!");
		}	
	}
	
	// Removal of data with O(N)
	public void remove(int position) {
		Node<T> previous;
		Node<T> current;
		
		int idx;
		
		previous = this.head;
		current = this.head;
		
		// Remove the first node
		if (position == 0) {
			removeFirst();
			return;
		}
		
		// Remove the last node
		if (position >= size() - 1) {
			removeLast();	
			return;
		}
		
		if (current != null) {
			idx = 0;
			
			while (idx++ < position) {
				previous = current;
				current = current.getNext();
			}
			
			previous.setNext(current.getNext());
			current = null;
			
			this.count--;
		}
	}
	
	// Reverse the current linked list
	public void reverse() {
		Node<T> current;
		Node<T> previous;
		Node<T> next;
		
		current = this.head;
		
		previous = null;
		next = null;
		
		while (current != null) {
			next = current.getNext();
			current.setNext(previous);
			previous = current;
			current = next;
		}
		
		// Lastly, switch the head and tail
		Node<T> temp = this.head;
		
		this.head = this.tail;
		this.tail = temp;	
	}
	
	// Prints the nodes in the linked list
	public void print() {
		Node<T> current;
		
		current = this.head;
		
		while (current != null) {
			System.out.println(current.getValue());
			
			current = current.getNext();
		}
	}
	
	// Return true if the linked list is empty; otherwise, false
	public boolean isEmpty() {
		return size() == 0;
	}
	
	// Return the size of the linked list
	public int size() {
		return this.count;
	}
}
