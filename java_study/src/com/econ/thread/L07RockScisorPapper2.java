package com.econ.thread;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class RSPGames extends JFrame{
	final String t = "가위 바위 보 게임";
	ImageIcon[] img= {
			new ImageIcon("src/com/econ/thread/img/kawi.jpg"),
			new ImageIcon("src/com/econ/thread/img/bawi.jpg"),
			new ImageIcon("src/com/econ/thread/img/bo.jpg")
	};
	JFrame f=this;
	
	class SelectButton extends JPanel{ // RSP버튼
		JButton[] btn=new JButton[3];
		public SelectButton() {
			for(int i=0; i<img.length; i++) {
				btn[i] = new JButton(img[i]);
				this.add(btn[i]);
				btn[i].addActionListener(new EventHandler());
			}
		}
	}
	SelectButton slBtn = new SelectButton();
	
	class Display extends JPanel{ // 결과값
		JLabel me = new JLabel("User");
		JLabel com = new JLabel("Computer");
		JLabel result = new JLabel("result");
		public Display() {
			add(me); add(result); add(com);
		}
		public void setting(Icon img,Icon comImage, String res) {
			me.setIcon(img);
			me.setHorizontalTextPosition(JLabel.LEFT);
			com.setIcon(comImage);
			result.setText(res);
		}
	}
	Display dis = new Display();
	
	class EventHandler implements ActionListener{ // 버튼 클릭 이벤트
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btnMe = (JButton) e.getSource();
			int btnCom = (int) (Math.random()*3);
			String result = "";
			if(btnMe.getIcon() == img[0] && btnCom == 2 || 
					btnMe.getIcon() == img[1] && btnCom == 0 ||
					btnMe.getIcon() == img[2] && btnCom == 1) {
				result = "당신이 이겼습니다.";
			}else if(btnMe.getIcon() == img[0] && btnCom == 0 ||
					btnMe.getIcon() == img[1] && btnCom == 1 ||
					btnMe.getIcon() == img[2] && btnCom == 2) {
				result = "비겼습니다.";
			}else {
				result = "당신이 졌습니다.";
			}
			dis.setting(btnMe.getIcon(),img[btnCom], result);
		}
		
	}
	
	class WindowEnd extends WindowAdapter{
		@Override
		public void windowClosing(WindowEvent e) {
			int result = JOptionPane.showConfirmDialog(null, "게임을 종료합니까?", "종료창", JOptionPane.YES_NO_OPTION);
			if(result == JOptionPane.CLOSED_OPTION) {
				new RSPGames(t);
			}else if(result == JOptionPane.YES_OPTION) {
				f.dispose();
				System.exit(0);
			}else {
				new RSPGames(t);
			}
		}
	} // 종료
	public RSPGames(String title) {
		super(title);
		
		add(slBtn,"South");
		add(dis,"Center");
		
		f.setBounds(1000, 150, 500, 500);
		f.setVisible(true);
		addWindowListener(new WindowEnd());
	}
}

public class L07RockScisorPapper2 {
	public static void main(String[]args) {
		new RSPGames("가위 바위 보 게임");
	}
}
