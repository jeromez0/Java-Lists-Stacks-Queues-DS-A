package linkedLists;

public class LinkedList<T extends Comparable<T>> implements Cloneable {

	private Node<T> head = null;

	public LinkedList() {

	}

	public int countNodes() {
		if (head == null) {
			return 0;
		} else {
			Node<T> curr = head;
			int count = 0;
			while (curr != null) {
				System.out.print(curr.data + " ");
				curr = curr.getNext();
				count++;
			}
			System.out.println("\nCount: " + count);
			return count;
		}
	}

	public void addNode(T data) {
		if (head == null) {
			head = new Node<T>(data);
		} else {
			Node<T> curr = head;
			while (curr.getNext() != null) {
				curr = curr.getNext();
			}
			curr.setNext(new Node<T>(data));
		}
	}
	
	public void insertNode(int position, T data) {
		
		Node<T> newNode = new Node<T>(data);
		
		if (position == 0){
			newNode.next = this.head;		 
			this.head = newNode;
		} else {
			// start from the head
			Node<T> node = head;

			// find the position just before expected one
			while(position-- > 1) {
				node = node.getNext();
			}
			// insert new node
			newNode.next = node.getNext();
			node.next = newNode;
		}
		
	}
	
	public T popElement() {
		if (head != null) {
			T topElement = head.getData();
			head = head.getNext();
			
			System.out.println("Removed Element: " + topElement);
			return topElement;
		}
		return null;
	}
	
}
