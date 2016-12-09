class Queue {
	int size = 0; 		//No of item in Queue;
	int front = -1;		//front index or head index, from where we can dequeue item;
	int rear = -1;		//Rear index or tail index where we can enqueue items;
	int capacity = 0;	// Maximum size of Queue;
	int queArr[];
	Queue(int cap) {
		this.capacity = cap;
		queArr = new int[cap];
	}
	
	//Enque
	public void enqueue(int data) {
		if(full()) {				//We can call full method also.
			System.out.println("Queue is full.");
			return;
		}
		if(empty()) {
			rear = front = 0;
		}
		else {
			rear = (++rear) % queArr.length;
		}		
		queArr[rear] = data;
		size++;
	}
	
	//DeQueue
	public int dequeue() {
		if(empty()) {
			System.out.println("Queue is Empty.");
			return 0;
		}
		//First get the element.
		int item = queArr[front];
		//if Queue is having one element
		if(rear == front) {
			rear = front = -1;
		}
		else {
			front = (++front) % queArr.length;
		}
		size--;
		return item;
	}
	
	//Rear;
	public int rear() {
		if(empty()) {
			System.out.println("Queue is Empty.");
			return 0;
		}
		return queArr[rear];
	}
	
	//Front
	public int front() {
		if(empty()) {
			System.out.println("Queue is Empty.");
			return 0;
		}
		return queArr[front];
	}
	//empty
	public boolean empty() {
		if(rear == -1 && front == -1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//Full
	public boolean full() {
		return ((rear +1) % queArr.length == front);
	}
	public void printQueue() {
		if(empty()) {
			System.out.println("Queue is empty.");
			return;
		}
		
		for(int i=0; i < size; i++) {
			System.out.println(queArr[i]);
		}
	}
}
class QueueUsingArray {
	
	public static void main(String args[]) {
		//Code goes here;
		Queue que = new Queue(3);
		que.enqueue(4);
		que.enqueue(5);
		que.enqueue(6);
		que.enqueue(7);
		que.printQueue();
		System.out.println("-------");
		System.out.println("Rear Item : " + que.rear());
		System.out.println("Front Item : " + que.front());
		System.out.println("-------");
		System.out.println("Poped Item : " + que.dequeue());
		System.out.println("Poped Item : " + que.dequeue());
		que.enqueue(7);
		System.out.println("Poped Item : " + que.dequeue());
		System.out.println("Poped Item : " + que.dequeue());
		System.out.println("Poped Item : " + que.dequeue());
	} 
}