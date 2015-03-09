package Network;

public class Node {
	int data;
	Node ref[];
	Data packets;
	QueuePackets[] queue;
	int adjacency[][];
	Node(int data, int size,int a[][]){
		this.data=data;
		ref = new Node[size];
		queue = new QueuePackets[size];
		packets=new Data();
		adjacency=a;
	}
	void makeLink(int a[], int size, Node list[])
	{
		int i;
		for (i=0;i<size;i++)
		{
			if (a[i]==1)
			{
				ref[i]=list[i];//The reference to the node is made if there is an edge in the graph
				queue[i]=new QueuePackets();//THe ith queue contains qnodes (Packets being data) of ith Node in the graph
			}
		}
	}

	void printNode()
	{
		System.out.println("Data - " + data);
		int i;
		for(i=0;i<ref.length;i++)
		{
			if (ref[i]!=null)
				System.out.println(ref[i].data);
		}
	}

}
