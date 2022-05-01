package com.econ.gui;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
// 생성자를 구현하면 된다!
class WindowClose implements WindowListener{
	Frame f;
	public WindowClose(Frame f) {
		this.f=f;
	}
	@Override
	public void windowOpened(WindowEvent e) {}
	@Override
	public void windowClosing(WindowEvent e) {
		this.f.dispose(); // closed가 호출된다.
		System.out.println("클로징 버튼을 눌렀습니다.");
	}
	@Override
	public void windowClosed(WindowEvent e) {
		System.out.println("창이 꺼졌습니다.");
		System.exit(0); 
		// dispose()로 창이 꺼지면 jvm이 할일이
		// 없어서 종료되지만 노파심에 한번 더 종료
	}
	@Override
	public void windowIconified(WindowEvent e) {}
	@Override
	public void windowDeiconified(WindowEvent e) {}
	@Override
	public void windowActivated(WindowEvent e) {}
	@Override
	public void windowDeactivated(WindowEvent e) {}
}
public class L01Awt {
	public static void main(String[]args) {
		Frame f= new Frame("로그인");
		Panel p= new Panel();
		Label l= new Label();
		Label l1= new Label();
		TextField tf= new TextField(10);
		TextField tf1= new TextField(10);
		l.setText("아이디");
		l1.setText("패스워드");
		Button b= new Button("입력");
		Button b1= new Button("입력");
		p.add(l); p.add(tf); p.add(b);
		p.add(l1); p.add(tf1); p.add(b1);
		f.add(p);
		f.setSize(250, 300);
		f.setVisible(true);
		f.addWindowListener(new WindowClose(f));
	}
}
