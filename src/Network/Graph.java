package Network;
import java.util.*;
public class Graph {
	int inputArray[][];
	int inputSize;
	BFS bfs;
	Graph(int size){
		inputArray=new int[size][size];
		inputSize=size;
		bfs=new BFS(size,inputArray,0,size-1);
	}
	 void input(int a[][], int size)
	{
		Scanner in=new Scanner(System.in);
		int i,j;
		for (i=0;i<size;i++)
		{
			for (j=0;j<size;j++)
			{
				a[i][j]=in.nextInt();
				inputArray[i][j]=a[i][j];
			}
		}
	}

	void printarray(int a[][], int size)
	{
		int i,j;
		System.out.print("printing array \n");
		for (i=0;i<size;i++)
		{
			for (j=0;j<size;j++)
				System.out.print(a[i][j] + " ");
			System.out.print("\n");
		}
	}

	int[][] addNode( int array[][], int size)
	{
		int a[] = new int[size+1];
		int i,j;
		Scanner in = new Scanner(System.in);
		for (i=0;i<=size;i++)
			a[i]= in.nextInt();
		int newarray[][] = new int[size+1][size+1];
		for (i=0;i<size;i++)
		{
			newarray[i] = new int[size+1];
			for (j=0;j<size;j++)
			{
				newarray[i][j] =array[i][j];
			}
		}
		newarray[i] = a;
		for (i=0;i<=size;i++)
		{
			newarray[i][size]=a[i];
		}
		printarray(newarray, size+1);
		inputArray=newarray;
		inputSize++;
		return newarray;
	}
	void displayInputArray(){
		int i,j;
		for(i=0;i<inputSize;i++){
			for(j=0;j<inputSize;j++){
				System.out.print(inputArray[i][j]);
			}
			System.out.println();
		}
	}
}
