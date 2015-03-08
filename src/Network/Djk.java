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
	
	public void findShortest(int a[][],int size,int dest){
		int pathlen=1;
		int mark[]=new int[size];
		Queue q=new Queue();
		q.enqueue(0);
		mark[0]=pathlen;
		LinkedList list1[]=new LinkedList[size];
		LinkedList list2[]=new LinkedList[size];
		for(int i=0;i<size;i++){
			list1[i]=new LinkedList();
			list2[i]=new LinkedList();
		}
		int j; // counter keeps track of the number of times you visit each node
		int counter[] = new int[size];
		while(q.size!=0){
			pathlen=1+mark[q.front]; //adding one to length of previous node..
			if(counter[dest]==2){
				break;
			}
			if (1==counter[dest])
			{
				System.out.println("\nFound shortest path");
				display(list1,list2,size);
			}

			for(j=0;j<size;j++){
				if(a[q.front][j]==1 && counter[j]<2){
					mark[j]=pathlen;
					int k;
					counter[j]++;
					if (1==counter[j]){
						list1[j].copyContents(list1[q.front]);
						list1[j].add(j);
					}
					else if (2==counter[j]){
						if (counter[q.front]==1)
						{
							list2[j].copyContents(list1[q.front]);
							list2[j].add(j);
						}
						else if (counter[q.front]==2)
						{
							list2[j].copyContents(list2[q.front]);
							list2[j].add(j);
						}
					}
					if (j==dest)
					{
						if (counter[dest]==1)
							path1len=mark[dest];
						else 
							path2len=mark[dest];
					}
					System.out.println("Coming here");
					q.enqueue(j);
				}
			}
			q.dequeue();
		}
		System.out.println("Shortest path is ="+mark[dest]);
		System.out.println("The array of paths generated are");
		//display(path);
		display(list1,list2,size);
	}
	public void display(int a[][]){
		int i,j;
		for(i=0;i<a.length;i++){
			for(j=0;j<a[i].length;j++){
				System.out.print(a[i][j]+"\t");
			}
			System.out.println();
		}
	}
	public void  display(LinkedList[] list1, LinkedList list2[], int size) {
		int i;
		System.out.print("shortest paths \n");
		for(i=0;i<size;i++){
			System.out.print("\n for node " + i + " ");
			Node p=list1[i].head;
			while(p!=null){
				System.out.print(p.data+"\t");
				p=p.next;
			}
		}
		System.out.println();
		System.out.print("2nd shortest paths \n");
		for(i=0;i<size;i++){
			System.out.print("\n for node " + i + " ");
			Node p=list2[i].head;
			while(p!=null){
				System.out.print(p.data+"\t");
				p=p.next;
			}
		}
		System.out.println();
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
	}
}
