package org.daniel.tcpmorse.morse;

import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TCPMReciever extends JPanel {

	private BufferedReader reader;
	
	private boolean white = true;
	
	public TCPMReciever(Socket socket) {
		try {
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 300);
		frame.setContentPane(this);
		frame.setVisible(true);
		
		this.setBackground(Color.white);
		
		read();
	}
	
	private void read() {
		try {
			reader.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		white = !white;
		this.repaint();
		read();
	}
	
	@Override
	public void paint(Graphics g) {
		this.setBackground((white) ? Color.white : Color.black);
		super.paint(g);
	}
}
