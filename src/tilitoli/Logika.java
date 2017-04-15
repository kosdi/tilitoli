package tilitoli;



public class Logika {

	
	private GUI gui;
	private Network net = null;
	//private vector m;
	//table
	private int stepNum;
	//Time:time
	
	Logika() {
	}
	
	void setGUI(GUI g) {
		gui = g;
	}
	
	void StartServer() {
		if (network != null)
			network.disconnect();
		network = new Server(this);
		network.connect("localhost");
	}
	
	
	void startClient() {
		if (network != null)
			network.disconnect();
		network = new Client(this);
		network.connect("localhost");
	}
	
	void sendMove(vector m){
		if(network == null)
			return;
		network.send(m);
	}
	
	void moveReceived(vector m){
		if(gui == null)
			return;
		gui.refresh(m);
	}
	
	void Time(){
		
	}
	
	void setTable(){
		
	}
	
	void makeMove(vector m){
		
	}
	
	void calculateScore(time, stepNum){
		
	}
	
	void openIMG(){
		
	}
}
