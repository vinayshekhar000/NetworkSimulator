package Network;
public class Queue {
	int a[]=new int[100];
	int size=0;
	int front=0;
	int rear=0;
	void enqueue(int n){
		a[rear]=n;
		rear++;
		size++;
	}
	int dequeue(){
		int temp=a[front];
		front++;
		size--;
		return temp;
	}
	
}
