package Network;
public class BFS{
	int path[];
	int secondpath[];
	int size;
	int pathlen;
	int adjacency[][];
	int child[];
	int marked[];
	int source;
	int destination;
	BFS(){}
	public BFS(int size,int a[][],int source,int destination){
		this.size=size;
		path=new int[size];
		secondpath=new int[size];
		adjacency=a;
		child=new int[size];
		marked=new int[size];
		this.source=source;
		this.destination=destination;
	}
	int visit(int index)
	{
		if (index==size-1)
		{
			path[pathlen++]=index;
			return 1;
		}
		else 
		{
			int j=0;
			int count=0;
			for (j=0;j<size;j++)
				child[j]=0;
			for (j=0;j<size;j++)
				if (adjacency[index][j]==1 && marked[j]!=1)
				{
					child[count++]=j;
					marked[j]=1;
				}
			for (j=0;j<count;j++)
				if (visit(child[j])==1)
				{
					path[pathlen++]=index;	
					return 1;
				}	
			return 0;
		}
	}
}
