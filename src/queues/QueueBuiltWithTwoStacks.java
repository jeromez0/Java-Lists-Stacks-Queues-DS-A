package queues;

import errors.QueueOverflowException;
import errors.QueueUnderflowException;
import errors.StackOverflowException;
import errors.StackUnderflowException;
import stacks.Stack;

public class QueueBuiltWithTwoStacks<T> {

		private Stack<T> forwardStack = new Stack<>();
		private Stack<T> reverseStack = new Stack<>();
		
		public QueueBuiltWithTwoStacks() {
			
		}
		
		public boolean isFull() {
			return forwardStack.isFull() || reverseStack.isFull();
		}
		public boolean isEmpty() {
			return forwardStack.isEmpty() && reverseStack.isEmpty();
		}
		
		public void enqueue(T data) throws QueueOverflowException {
			if (isFull()) {
				throw new QueueOverflowException();
			}
			
			try {
				if (forwardStack.isEmpty()) {
					while (!reverseStack.isEmpty()) {
						forwardStack.push(reverseStack.pop());
					}
				}
				forwardStack.push(data);
			} catch (StackUnderflowException | StackOverflowException se) {
				throw new QueueOverflowException();
			}			
		}
		
		public T dequeue() throws QueueUnderflowException {
			if (isEmpty()) {
				throw new QueueUnderflowException();
			}
			
			try {
				if (reverseStack.isEmpty()) {
					while(!forwardStack.isEmpty()) {
						reverseStack.push(forwardStack.pop());
					}
				}
				return reverseStack.pop();
			} catch (StackOverflowException | StackUnderflowException se) {
				throw new QueueUnderflowException();
			}
		}
		
		
}
