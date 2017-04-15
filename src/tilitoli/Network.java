package tilitoli;

//import java.awt.Vector;

abstract class Network {
	
	protected Logika logika;
	
	Network(Logika l){
		logika = l;
	}
	
	
	
	abstract void connect(String ip);

	abstract void disconnect();

	abstract void send(Vector m);
}
