package queues;

import errors.QueueOverflowException;
import errors.QueueUnderflowException;

public class Main {

	public static <T> void main(String[] args) throws QueueUnderflowException, QueueOverflowException {
		// TODO Auto-generated method stub
		QueueBuiltWithTwoStacks twoQueue = new QueueBuiltWithTwoStacks<T>();
		
		twoQueue.enqueue(1);
		twoQueue.enqueue(2);
		twoQueue.enqueue(3);
		twoQueue.enqueue(4);
		twoQueue.enqueue(5);
		System.out.println(twoQueue.dequeue());
		System.out.println(twoQueue.isEmpty());
		System.out.println(twoQueue.isFull());
		
		Queue queue = new Queue(Integer.class);
		
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		System.out.println(queue.dequeue());
		System.out.println(queue.isEmpty());
		System.out.println(queue.isFull());
		
	}

}
