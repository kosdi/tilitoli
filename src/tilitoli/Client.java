package tilitoli;



import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

import szoftechtutor.SerialClient.ReceiverThread;


//import vector
public class Client extends Network {
	private Socket socket = null;
	private ObjectOutputStream out = null;
	private ObjectInputStream in = null;
	
	
	
	
	Client(Logika l) {
		super(l);
	}
	
	
	
	
	
	private class ReceiverThread implements Runnable {

		public void run() {
			System.out.println("Waiting for points...");
			try {
				while (true) {
				//	Point received = (Point) in.readObject();
				//	ctrl.clickReceived(received);
				}
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
				System.err.println("Server disconnected!");
			} finally {
				disconnect();
			}
		}
	}
	
	
	
	void connect(String ip) {
		disconnect();
		try {
			socket = new Socket(ip, 10007);

			out = new ObjectOutputStream(socket.getOutputStream());
			in = new ObjectInputStream(socket.getInputStream());
			out.flush();

			Thread rec = new Thread(new ReceiverThread());
			rec.start();
		} catch (UnknownHostException e) {
			System.err.println("Don't know about host");
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for the connection. ");
			JOptionPane.showMessageDialog(null, "Cannot connect to server!");
		}
	}
	
	
	
	
	void send(Vector m) {
		if (out == null)
			return;
		System.out.println("Sending vector: " + m + " to Server");
		try {
			out.writeObject(p);
			out.flush();
		} catch (IOException ex) {
			System.err.println("Send error.");
		}
	}
	
	void disconnect() {
		try {
			if (out != null)
				out.close();
			if (in != null)
				in.close();
			if (socket != null)
				socket.close();
		} catch (IOException ex) {
			System.err.println("Error while closing conn.");
		}
	}
	
	
	
	
}
