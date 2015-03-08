package Network;

public class Node {
	int data;
	Node ref[];
	Data packets;
	Node(int data, int size){
		this.data=data;
		ref = new Node[size];
		packets=new Data();
	}

	void makeLink(int a[], int size, Node list[])
	{
		int i;
		for (i=0;i<size;i++)
		{
			if (a[i]==1)
			{
				ref[i]=list[i];
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
