package Network;

public class Packet {
	Data data;
	Path path1;
	int  path[];
	int counter;
	int choose;//Set choose to 0 for Shortest and 1 for second Shortest
	Packet(){
		//pathToTraverse=new Path();
		path1=new Path();
		data=new Data();
	}
	Packet(Data data,int count){
		this.data=data;
		counter=count;
	}
	public void setPath(int choice,int a[][],int size,int dest){
		choose=choice;
		path1.findShortest(a, size, dest);
		if(choice == 1){
			int i=0;
			NodePath p=path1.path2.head;
			while(p!=null){
				path[i]=p.data;
				p=p.next;
				i++;
			}
		}
		else{
			int j=0 ;
			NodePath p=path1.path1.head;
			while(p!=null){
				path[j]=p.data;
				p=p.next;
				j++;
			}
		}
	}
}
