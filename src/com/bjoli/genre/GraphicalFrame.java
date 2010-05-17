package com.bjoli.genre;

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.bjoli.genre.GraphicalFrame;

//import statements
//Check if window closes automatically. Otherwise add suitable code
public class GraphicalFrame extends JFrame {

	public static void main(String args[]) {
		new GraphicalFrame();
	}
	
	GraphicalFrame() {
		JLabel jlbHelloWorld = new JLabel("Hello World");
		add(jlbHelloWorld);
		this.setSize(100, 100);
		// pack();
		setVisible(true);
	}
}
