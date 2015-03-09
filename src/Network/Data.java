package Network;

public class Data {
	String info[];
	int infolength;
	int totalNumPackets;
	int packetNo;
	
	int receivePackets[];
	Data(){
		info=new String[100];
		infolength=info.length;
	}
	void setData(String str[],int total,int packNo){
		int i;
		for(i=0;i<str.length;i++){
			info[i]+=(str[i]);
		}
		totalNumPackets=total;
		packetNo=packNo;
	}
}
