package stacks;

public class Element<T> {
	private T data;
	private Element next;
	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	public Element getNext() {
		return next;
	}
	
	public void setNext(Element next) {
		this.next = next;
	}
	
	// constructor method
	public Element(T data, Element next) {
		this.data = data;
		this.next = next;
	}
	
}

