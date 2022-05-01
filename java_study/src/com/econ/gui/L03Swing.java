package com.econ.gui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class L03Swing {
	public static void main(String[] args) {
		JFrame f=new JFrame();
		JButton b=new JButton();
		JPanel p=new JPanel();
		b.setText("제출");
		p.add(b);
		f.add(p);
		f.setSize(250,300);
		f.setVisible(true);
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				f.dispose();
				System.exit(0);
			}
		});
	}
}
