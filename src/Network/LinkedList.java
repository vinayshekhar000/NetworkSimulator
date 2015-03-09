package Network;
public class LinkedList {
	NodePath head;
	NodePath tail;
	LinkedList(){
		head=null;
		tail=null;
	}
	public void add(int value){
		if(head==null && tail==null){
			NodePath node=new NodePath(value);
			head=node;
			tail=node;
		}
		else{
			NodePath node=new NodePath(value);
			tail.next=node;
			tail=node;
		}
	}
	public void copyContents(LinkedList l1){
		NodePath p=l1.head;
		head=null;
		tail=null;
		while(p!=null){
			this.add(p.data);
			p=p.next;
		}
	}

	public void display()
	{
		NodePath temp = head;
		while (temp!=null)
		{
			System.out.print(temp.data + "\t");
			temp=temp.next;
		}
		System.out.println();
	}
		
}
