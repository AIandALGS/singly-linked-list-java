package singly_linked_list_prj;

public class Node<T> {
	private T value;
	private Node<T> next;
	
	public Node(T value) {
		this.value = value;
		this.next = null;
	}
	
	public void setNext(Node<T> next) {
		this.next = next;
	}
	
	public Node<T> getNext() {
		return this.next;
	}
	
	public T getValue() {
		return this.value;
	}
}
