package com.bjoli.genre;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//import statements
//Check if window closes automatically. Otherwise add suitable code
public class GraphicalFrame extends JFrame {

	public static void main(String args[]) {
		new GraphicalFrame();
	}
	
	GraphicalFrame() {
		super("Epic Genre Classification");
		Container container = getContentPane();
		container.setLayout(new FlowLayout());

		JLabel jlbHelloWorld = new JLabel("Please enter the folder for training data:");
		JTextField jtfText1 = new JTextField(10);
		add(jlbHelloWorld);
		add(jtfText1);

		JLabel jlbClassifier = new JLabel("Please enter the song to classify");
		JTextField jtfClassifier = new JTextField(10);
		add(jlbClassifier);
		add(jtfClassifier);

		this.setSize(500, 500);
		// pack();
		setVisible(true);
	}
}
