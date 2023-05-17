package org.htmlweb.dsa;

public class MyLinkedList<T> {

	private static class Node<T> {
		public T val;
		public Node<T> next = null;
		
		public Node(T val) {
			super();
			this.val = val;
		}
		
	}
	
	public void add(T val) {
		Node<T> newNode = new Node<T>(val);
		
		/*BigTheta(1)*/
		newNode.next = head;
		head = newNode;
		
		/* BigTheta(n) complexity
		if(head == null) {
			head = newNode;
		} else {
			Node<T> current = head;
			while(current.next != null) {
				current = current.next;
			}
			current.next = newNode;
		}
		*/

	}
	
	public void iterateOver(MyCrappyLambda<T> v) {
		Node<T> current = head;
		while(current != null) {
			v.doSomething(current.val);
			current = current.next;
		}
	}
	
	
	
	
	Node<T> head = null;
	
	public static void main(String[] args) {

		MyLinkedList<String> foo = new MyLinkedList<String>();
		foo.add("day!");
		foo.add("nice ");
		foo.add("a ");
		foo.add("Have ");
		
		
		
		
		foo.iterateOver(System.out::print);
		
	}

	interface MyCrappyLambda<T> {
		void doSomething(T val);
	}
	
}
