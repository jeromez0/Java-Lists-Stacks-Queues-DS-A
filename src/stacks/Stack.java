package stacks;

import errors.StackOverflowException;
import errors.StackUnderflowException;

public class Stack<T> {

	private static int MAX_SIZE = 40;

	// points to topmost element in the stack which can be popped or peeked
	private Element<T> top;

	// track the size of the stack at every push or pop. stack size operation can be
	// constant time
	private int size = 0;

	public Stack() {

	}

	public void push(T data) throws StackOverflowException {
		if (size == MAX_SIZE) {
			throw new StackOverflowException();
		}
		// create new element
		Element elem = new Element(data, top);
		// add element to the top
		top = elem;
		// increments the size
		size++;
	}

	public T pop() throws StackUnderflowException {
		if (size == 0) {
			throw new StackUnderflowException();
		}
		// get data from top element
		T data = top.getData();
		// next element in the stack is set as the top
		top = top.getNext();
		// size decrements by 1
		size--;
		// return top data from the stack
		return data;
	}

	public T peek() throws StackUnderflowException {
		if (size == 0) {
			throw new StackUnderflowException();
		}
		return top.getData();
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		return size == MAX_SIZE;
	}

	public int getSize() {
		return size;
	}

}
