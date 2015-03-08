package Network;
import java.util.Scanner;
public class Mainclass {
	public static void main(String args[])
	{
		int size,j;
		System.out.println("Size");
		Scanner in=new Scanner(System.in);
		size=in.nextInt();
		Graph graph1=new Graph(size); 
		int a[][] = new int[size][size];
		System.out.println("Enter the adjaceny matrix");
		graph1.input(a,size);
		Node list[]= new Node[size];
		int i;
		for (i=0;i<size;i++)
		{
			list[i]=new Node(i,size);
		}
		for (i=0;i<size;i++)
		{
			list[i].makeLink(a[i], size, list);
		}
		for (i=0;i<size;i++)
		{
			list[i].printNode();
		}
		System.out.println("The matrix before adding is");
		graph1.printarray(a, size);
		GraphDraw frame=new GraphDraw("Nodes plotting");
		frame.setSize(1000,1000);
		
		frame.setVisible(true);
		/*System.out.println("Adding a new node, enter the adjacency row\n");
		a= graph1.addNode(a,size);
		System.out.println("final print");
		graph1.printarray(a,size+1);*/
		int k=1;
		for(i=0;i<size;i++){
			frame.addNode(Integer.toString(i),k*100,k*100);
			k++;
		}
		for(i=0;i<size;i++){
			for(j=0;j<size;j++){
				if(a[i][j]==1)
				frame.addEdge(i, j);
			}
		}
		//System.out.println("MAking sure that my input array is right");
		//graph1.displayInputArray();
	}
}
