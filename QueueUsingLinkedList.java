/*Create Node*/
class Node {
	int data;
	Node next;
	Node(int data) {
		this.data = data;
		next = null;
	}
}
/*Implement Stack*/
class Stack {
	Node rear = null;
	Node front = null;
	int size = 0;
	Node head = null;
	
	//Enqueue
	public void enqueue(int data) {
		Node temp = new Node(data);
		if(rear == null && front == null) {	//If Queue is empty.
			rear = front = temp;
		}
		else {
			rear.next = temp;		//O(1) is Time complexity in this case.
			rear = temp;
		}
		size++;
	}
	
	//Dequeue
	public int dequeue() {
		if(empty()) {
			System.out.println("Queue is empty.");
			return -1;
		}
		int item = front.data;
		if(front == rear) {
			rear = front = null;
		}
		else {
			front = front.next;
		}
		size--;
		return item;
	}
	
	//empty
	public boolean empty() {
		if(rear == null && front == null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//Full method is not required.
	//get Size
	public int getSize() {
		return size;
	}
	//PrintQueue
	public void printQueue() {
		Node temp = front;
		while(temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
}
class QueueUsingLinkedList {
	public static void main(String args[]) {
		Stack stk = new Stack();
		stk.enqueue(5);
		stk.enqueue(6);
		stk.enqueue(7);
		stk.printQueue();
		System.out.println("Size : " + stk.getSize());
		System.out.println("Pooped data :  " + stk.dequeue());
		System.out.println("Pooped data :  " + stk.dequeue());
		System.out.println("Pooped data :  " + stk.dequeue());
		System.out.println("Pooped data :  " + stk.dequeue());
		stk.enqueue(8);
		stk.enqueue(9);
		stk.enqueue(1);
		System.out.println("Size : " + stk.getSize());
		stk.printQueue();
		System.out.println("Pooped data :  " + stk.dequeue());
		System.out.println("Size : " + stk.getSize());
		
	}
	
}