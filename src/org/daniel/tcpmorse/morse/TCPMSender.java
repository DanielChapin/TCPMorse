package org.daniel.tcpmorse.morse;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TCPMSender extends JPanel {
	
	public TCPMSender(Socket socket) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 300);
		frame.setLocation(650, 0);
		frame.setContentPane(this);
		frame.setVisible(true);
		
		this.setBackground(Color.red);
		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
					
			}

			@Override
			public void mousePressed(MouseEvent e) {
				DataOutputStream writer;
				try {
					writer = new DataOutputStream(socket.getOutputStream());
					writer.write(1);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				DataOutputStream writer;
				try {
					writer = new DataOutputStream(socket.getOutputStream());
					writer.write(1);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				
			}
			
		});
	}
	
}
