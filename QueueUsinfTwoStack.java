class Node {
	int data;
	Node next;
	Node(int data) {
		this.data = data;
		next = null;
	}
}
class Stack {
	Node head = null;
	public void push(int data) {
		Node node = new Node(data);
		node.next = head;
		head = node;
	}
	public int pop() {
		int data = head.data;
		head = head.next;
		return data;
	}
	public boolean empty() {
		return (head == null);
	}
}

class Queue {
	Stack stack1 = new Stack();
	Stack stack2 = new Stack();
	public void enqueue(int data) {
		stack1.push(data);
	}
	public int dequeue() {
		if(stack1.empty() && stack2.empty()) {
			System.out.println("Queue is empty.");
			return -1;
		}
		if(stack2.empty()) {
			Node temp = stack1.head;
			while(temp != null) {
				int stk1Data = stack1.pop();
				stack2.push(stk1Data);
				temp = temp.next;
			}
		}
		return stack2.pop();
	}
}
class QueueUsinfTwoStack {
	public static void main(String args[]) {
		Queue q = new Queue();
		q.enqueue(2);
		q.enqueue(3);
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		q.enqueue(2);
		System.out.println(q.dequeue());
		
	}
}