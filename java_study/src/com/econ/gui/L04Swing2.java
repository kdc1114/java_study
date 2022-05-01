package com.econ.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.w3c.dom.ls.LSOutput;

class SignInFrame extends JFrame{
	JFrame f=this;
	JPanel p= new JPanel();
	JTextField tf= new JTextField("아이디를 입력",10);
	JLabel l= new JLabel("ID :");
	JButton b= new JButton("제출");
	public SignInFrame(String name) {
		super(name);
		p.add(l);
		p.add(tf);
		p.add(b);
		f.add(p);
		f.addWindowListener(new WindowCloser(this));
		b.addActionListener(new SubmitAction(tf));//콘솔창에 tf에 입력된 값이 출력
		
		this.setBounds(300, 100, 200, 300);;
		this.setVisible(true);
	}
}
class SubmitAction implements ActionListener{
	JTextField tf;
	public SubmitAction(JTextField tf) {
		this.tf=tf;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(tf.getText()+"제출 버튼이 눌렸습니다.");
	}
}
class WindowCloser implements WindowListener{
	JFrame f;
	public WindowCloser(JFrame f) {
		this.f=f;
	}
	@Override
	public void windowOpened(WindowEvent e) {
		System.out.println("열림");
	}
	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("닫히는 중");
		f.dispose();
	}
	@Override
	public void windowClosed(WindowEvent e) {
		System.out.println("닫힘. JVM 종료");
		System.exit(0);
	}
	@Override
	public void windowIconified(WindowEvent e) {
		System.out.println("작아짐");
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
		System.out.println("커짐");
	}
	@Override
	public void windowActivated(WindowEvent e) {
		//System.out.println("windowActivated : 관심중");
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
		//System.out.println("windowDeactivated : 관심 벗어남");
	}
	
	
}
public class L04Swing2 {
	public static void main(String[] args) {
		new SignInFrame("로그인");
	}

}
