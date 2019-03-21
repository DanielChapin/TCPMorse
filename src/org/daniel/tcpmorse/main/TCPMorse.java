package org.daniel.tcpmorse.main;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.daniel.tcpmorse.morse.TCPMReciever;
import org.daniel.tcpmorse.morse.TCPMSender;

public class TCPMorse {
	
	private int port = 12365;
	private String ip = "";
	private boolean isServer = true;
	
	private ServerSocket server;
	private Socket socket;

	public static void main(String[] args) {
		new TCPMorse(args);
	}
	
	private TCPMorse(String[] args) {
		if(args.length == 3) {
			port = Integer.parseInt(args[0]);
			ip = args[1];
			isServer = Boolean.parseBoolean(args[2]);
		}
		try {
			if(isServer)
				setupServer();
			else
				setupClient();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private void setupServer() throws IOException {
		server = new ServerSocket(port);
		socket = server.accept();
		new TCPMSender(socket);
		new TCPMReciever(socket);
	}
	
	private void setupClient() throws IOException {
		socket = new Socket(ip, port);
		new TCPMSender(socket);
		new TCPMReciever(socket);
	}

}
