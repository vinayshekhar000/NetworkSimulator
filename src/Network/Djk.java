import java.util.Scanner;

class Path {
	LinkedList path1;
	LinkedList path2;
	int path1len;
	int path2len;
	Path(){
		path1=new LinkedList();
		path2=new LinkedList();
	}
	
	void findShortest(int a[][], int size, int dest)
	{
		int i, tempdist;
		int dist[] = new int[size];
		int dist2[]=new int[size];
		LinkedList list = new LinkedList();
		LinkedList path[] = new LinkedList[size];
		LinkedList secpath2[] = new LinkedList[size];
		for (i=0;i<size;i++)
		{
			path[i]=new LinkedList();
			secpath2[i]=new LinkedList();
		}	
		for (i=0;i<size;i++)
		{
			dist[i]=Integer.MAX_VALUE;
		}
		dist[0]=0;
		path[0].add(0);
		secpath2[0].add(0);
		for (i=0;i<size;i++)
		{
			//computing minimum 
			Node temp=list.head;
			while(temp!=null)
			{
				//checking if the current node is connected to the node in the list
				if (a[i][temp.data]!=0)
				{	
					tempdist=dist[temp.data] + a[i][temp.data]; // adding distance of edge to the existing shortest distance 
					if (tempdist<dist[i]) // if tempdata is smaller than existing shortest distance
					{
						dist2[i]=dist[i];
						dist[i]=tempdist;
						secpath2[i].copyContents(path[i]);
						path[i].copyContents(path[temp.data]);
						path[i].add(i);
					}
					//checking if the edge can modify dist[temp.data]
					tempdist=dist[i]+a[i][temp.data];
					if (tempdist<dist[temp.data])
					{
						dist2[temp.data]=dist[temp.data];
						dist[temp.data]=tempdist;
						secpath2[temp.data].copyContents(path[temp.data]);
						path[temp.data].copyContents(path[i]);
						path[temp.data].add(temp.data);
					}
				}
				temp=temp.next;
			}

			//the shortest distance has been updated
			list.add(i);

		}

		System.out.println("Displaying paths for all");
		for (i=0;i<size;i++)
		{
			System.out.print("path for " + i+ " ");
			path[i].display();
		}
		path1len=dist[dest];
		path2len=dist2[dest];
		path1 = path[dest];
		path2 = secpath2[dest];
	}
}

public class Djk {
	public static void main(String args[]){
		System.out.println("Enter the size of the adjaceny matrix");
		Scanner in=new Scanner(System.in);
		int size=in.nextInt();
		int i,j;
		int a[][]=new int[size][size];
		Path path = new Path();
		for(i=0;i<size;i++){
			for(j=0;j<size;j++){
			a[i][j]=in.nextInt();
			}
		}
		System.out.println("enter the destination");
		int dest=in.nextInt();
		path.findShortest(a,size,dest);
		System.out.println("shortest distance is " + path.path1len);
		System.out.println("shortest path is ");
		path.path1.display();
		System.out.println("second shortest distance is " + path.path2len);
		System.out.println("shortest path is ");
		path.path2.display();
		
	}
}
