package linkedLists;

public class Main {

	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		
		linkedList.addNode(1);
		linkedList.addNode(2);
		linkedList.addNode(3);
		linkedList.insertNode(0, 0);
		linkedList.insertNode(1, 4);
		linkedList.insertNode(1, 5);
		linkedList.countNodes();
				
	}
}
