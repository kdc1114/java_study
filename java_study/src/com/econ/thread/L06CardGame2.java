package com.econ.thread;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.*;

import org.w3c.dom.ls.LSOutput;

interface CardColors{
	Color FRONT=new Color(255, 255, 255);
	Color FRONT_TEXT=new Color(0);
	Color BACK=new Color(0, 216, 255);
	Color BACK_TEXT=new Color(0, 216, 255);
	//배경과 글자색을 똑같이 해서 보이지 않게 하기

	//Color BACK_TEXT=new Color(185, 185, 185);
	Color FAILED=new Color(240, 100, 100);
	Color FAILED_TEXT=new Color(105, 15, 25);
	Color SUCCESS=new Color(200, 240, 200);
	Color SUCCESS_TEXT=new Color(15, 115, 25);	
}
class CardGameSet extends JFrame{
	//ImageIcon back= new ImageIcon("src/com/econ/thread/cardimg/back.jpg");
	int time=30;
	boolean time_b=true;
	int score=0;
	JFrame f=this;
	JPanel mainP=new JPanel();
	JPanel subP=new JPanel();
	
	JLabel timeL=new JLabel(time+"초");
	JLabel scoreL=new JLabel(score+"점");
	
	Card[] cards=new Card[12];
	Integer[] cards_nums= {1,1,2,2,3,3,4,4,5,5,6,6};
	LinkedList<Card> click_cards=new LinkedList<Card>();
	Thread t1=new ShowCard();
	Thread t2=new HideCard();
	Thread t3=new CheckCard();
	Thread timer=new Timer();
	
	public CardGameSet() throws InterruptedException {
		randomCards(); // 카드 섞고 버튼객체 만들기
		for(Card c :cards) { // 카드 버튼 12개를 패널에 붙이기
			subP.add(c);
		}
		f.setLayout(new BorderLayout()); //y축으로 1칸씩 정렬되는 레이아웃
		subP.setLayout(new GridLayout(3,4,20,10)); //그리드로 정렬되는 레이아웃
		mainP.add(timeL);
		mainP.add(scoreL);
		f.add(mainP,BorderLayout.NORTH);
		f.add(subP,BorderLayout.CENTER);
		f.setBounds(600, 100, 600, 800);
		setTitle("카드게임");
		f.setVisible(true);
		f.validate(); // 새로고침
		f.addWindowListener(new WindowSet());
		
		t1.start(); // 화면에 카드 출력
		t1.join();
		t2.start(); // 출력된 카드 감추기
		t2.join();
		timer.start();
		CardAction(); // 카드 클릭이벤트
		t3.start(); // 카드 짝맞추기 검사
	}
	class Timer extends Thread{ // 제한 시간
		public void run() {
			while(time>0 && time_b) {
				try {Thread.sleep(1000);} catch (InterruptedException e1) {e1.printStackTrace();}
				time--;
				timeL.setText(time+" 초");
				if(time_b==false) {
					int result=JOptionPane.showConfirmDialog(null, "승리했습니다! 재시작?", "게임 성공", JOptionPane.YES_NO_OPTION);
					if(result==JOptionPane.YES_OPTION) {
						f.dispose();
						try {new CardGameSet();} catch (InterruptedException e) {e.printStackTrace();}
					}else {
						f.dispose();
						System.exit(0);
					}
					timer.stop();
				}
			}
			if(time==0) {
				int result=JOptionPane.showConfirmDialog(null, "시간이 다됬습니다 재시작?", "시간 초과", JOptionPane.YES_NO_OPTION);
				if(result==JOptionPane.YES_OPTION) {
					f.dispose();
					try {new CardGameSet();} catch (InterruptedException e) {e.printStackTrace();}	
				}else {
					f.dispose();
					System.exit(0);
				}
			}
		}
	}
	class ShowCard extends Thread{ // 카드보이기
		public void run() {
			for(Card c :cards) {
				try {Thread.sleep(0);} catch (InterruptedException e) {e.printStackTrace();}
				c.setOpaque(true);
				c.setBorderPainted(false);
				c.setBackground(CardColors.FRONT); 
				c.setText(c.card_num+"");
				c.setForeground(CardColors.FRONT_TEXT);

				f.validate();
			}
		}
	}
	class HideCard extends Thread{ // 카드감추기
		public void run() {
			try {Thread.sleep(4000);} catch (InterruptedException e) {e.printStackTrace();}
			for(Card c :cards) {
				try {Thread.sleep(0);} catch (InterruptedException e) {e.printStackTrace();}
				c.setBackground(CardColors.BACK);
				c.setForeground(CardColors.BACK_TEXT);
			}
		}
	}
	class CheckCard extends Thread{ // 카드 짝맞추기 검사
		public void run() {
			while(true) {
				try {Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();}
				if(click_cards.size()==2) {
					// 실패시 다시 뒤집기
					if(click_cards.get(0).card_num!=click_cards.get(1).card_num) {
						try {Thread.sleep(100);} catch (InterruptedException e1) {e1.printStackTrace();}
						for(Card c: click_cards) {
							c.setBackground(CardColors.FAILED); 
							c.setForeground(CardColors.FAILED_TEXT);
						}
						try {Thread.sleep(100);} catch (InterruptedException e1) {	e1.printStackTrace();}								
						for(Card c: click_cards) {
							c.setBackground(CardColors.BACK);
							c.setForeground(CardColors.BACK_TEXT);
						}
					}else {
						// 성공시 true로 바꿔 다시 안뒤집어지게 하기
						for(Card c: click_cards) {
							c.success=true;
							c.setBackground(CardColors.SUCCESS); 
							c.setForeground(CardColors.SUCCESS_TEXT);
							if(c.success==true) {
								score+=5;
								scoreL.setText(score+" 점");
							}
							if(score==60) {
								time_b=false;
							}
						}
					}
					click_cards.clear(); // 성공하든 실패하든 2번 클릭하면 클릭초기화
				}
			}
		}
	}
	public void CardAction() { // 카드자체에 이벤트주기
		for(Card c: cards) {
			c.addActionListener(new CardCont(c));
		}
	}
	class CardCont implements ActionListener{
		Card c;
		public CardCont(Card c) {
			this.c=c;
		}
		public void actionPerformed(ActionEvent e) {
			if(c.success) return; // 성공한 카드는 끝
			if(click_cards.size()<2) { // 카드 2번 클릭가능
				if(click_cards.size()==1 && c==click_cards.get(0)) return;
				click_cards.add(c);
				c.setBackground(CardColors.FRONT);
				c.setForeground(CardColors.FRONT_TEXT);
			}		
		}
	}
	public void randomCards() { // 번호 랜덤섞기 + 카드생성
		LinkedList<Integer> card_list=new LinkedList<Integer>(Arrays.asList(cards_nums));
		for(int i=0; i<cards.length; i++) {
			int random=(int)(Math.random()*card_list.size());
			Card c=new Card(card_list.remove(random));
			c.setBackground(CardColors.FRONT);
			c.setOpaque(true);
			c.setBorderPainted(false);
			
			cards[i]=c;
		}
	}
	class WindowSet extends WindowAdapter{ // 종료이벤트
		public void windowClosing(WindowEvent e) {
			int result=JOptionPane.showConfirmDialog(null, "게임을 종료합니까?", "종료창", JOptionPane.YES_NO_OPTION);
			if(result==JOptionPane.CLOSED_OPTION) {
				
			}else if(result==JOptionPane.YES_OPTION) {
				f.dispose();
				System.exit(0);
			}else {
				
			}
		}
	}
	
}

class Card extends JButton{
	public int card_num; //선택한 2개의 카드가 같은지 비교할 때 사용
	public boolean success=false; //카드 찾기 체크 boolean
	public Card(int card_num) {
		this.card_num=card_num;
	}
}
public class L06CardGame2 {
	public static void main(String[] args) {
		try {
			new CardGameSet();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
