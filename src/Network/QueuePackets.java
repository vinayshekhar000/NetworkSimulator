package Network;
class Qnode{
	Packet pack;
	Qnode next;
	Qnode(){
	}
}
public class QueuePackets {
	Qnode head;
	Qnode tail;
	
	void enqueue(Packet pack){
		Qnode node=new Qnode();
		node.pack=pack;
		if(head==null){
			head=node;
			tail=node;
		}
		else{
			tail.next=node;
			tail=node;
		}
	}
	
	Packet dequeue(){
		if(head==null && tail==null)
			return null;
		Packet temp;
		temp=head.pack;
		if(head==tail){
			head=null;
			tail=null;
		}
		else{
			head=head.next;
		}
		return temp;
	}
	
}
