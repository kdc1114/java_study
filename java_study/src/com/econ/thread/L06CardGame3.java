//package com.econ.thread;
//
//import java.awt.*;
//import java.awt.event.*;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//import java.util.*;
//import javax.imageio.ImageIO;
//import javax.swing.*;
//import javax.swing.border.LineBorder;
//
//class CardGameFrame extends JFrame {
//	public boolean res=true;
//	MyDialog dlg;
//	MyDialog2 dlg2;
//	int time=30;
//	int score=0;
//	JPanel resultP=new JPanel();
//	JPanel buttonP=new JPanel();
//	JLabel timeL=new JLabel("제한 시간: "+time+"초");
//	JLabel scoreL=new JLabel("  점수:"+score+"점");
//	Card[] cards=new Card[12];
//	ImageIcon icon_back;
//	ImageIcon [] icon_arr=new ImageIcon[6];
////	BufferedImage thumbnail1=new BufferedImage(150, 260, BufferedImage.TYPE_3BYTE_BGR);
////	BufferedImage backcard=ImageIO.read(new File("./src/com/econ/thread/backcard.jpg"));
////	ImageIcon i1=new ImageIcon(thumbnail1);
////	
////	BufferedImage thumbnail2=new BufferedImage(150, 260, BufferedImage.TYPE_3BYTE_BGR);
////	BufferedImage img1=ImageIO.read(new File("./src/com/econ/thread/iu1.jpg"));
////	ImageIcon i2=new ImageIcon(thumbnail2);
////	
////	BufferedImage thumbnail3=new BufferedImage(150, 260, BufferedImage.TYPE_3BYTE_BGR);
////	BufferedImage img2=ImageIO.read(new File("./src/com/econ/thread/iu2.jpg"));
////	ImageIcon i3=new ImageIcon(thumbnail3);
////	
////	BufferedImage thumbnail4=new BufferedImage(150, 260, BufferedImage.TYPE_3BYTE_BGR);
////	BufferedImage img3=ImageIO.read(new File("./src/com/econ/thread/iu3.jpg"));
////	ImageIcon i4=new ImageIcon(thumbnail4);
////	
////	BufferedImage thumbnail5=new BufferedImage(150, 260, BufferedImage.TYPE_3BYTE_BGR);
////	BufferedImage img4=ImageIO.read(new File("./src/com/econ/thread/iu4.jpg"));
////	ImageIcon i5=new ImageIcon(thumbnail5);
////	
////	BufferedImage thumbnail6=new BufferedImage(150, 260, BufferedImage.TYPE_3BYTE_BGR);
////	BufferedImage img5=ImageIO.read(new File("./src/com/econ/thread/iu5.jpg"));
////	ImageIcon i6=new ImageIcon(thumbnail6);
////	
////	BufferedImage thumbnail7=new BufferedImage(150, 260, BufferedImage.TYPE_3BYTE_BGR);
////	BufferedImage img6=ImageIO.read(new File("./src/com/econ/thread/iu6.jpg"));
////	ImageIcon i7=new ImageIcon(thumbnail7);
//	
//	Integer [] cards_nums= {1,1,2,2,3,3,4,4,5,5,6,6};
//	LinkedList<Card> clk_arr=new LinkedList<Card>();
//	JFrame f=this;
//	
//	public 	BufferedImage thubmnail(int width,int height,String path) throws IOException {
//		BufferedImage thumbnail7=new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
//		BufferedImage img6=ImageIO.read(new File(path));
//		thumbnail7.getGraphics().drawImage(img6, 0, 0, width, height, null);
//		return thumbnail7;
//	}
//	
//	public CardGameFrame(String title) throws IOException {
//		super(title);
//		dlg=new MyDialog(this,"실패");
//		dlg2=new MyDialog2(this,"성공");
//		
//		icon_back =new ImageIcon(thubmnail(150,260,"./src/com/econ/thread/backcard.jpg"));
//		for(int i=0; i<6; i++) {
//			icon_arr[i]=new ImageIcon(thubmnail(150,260,"./src/com/econ/thread/iu"+(i+1)+".jpg"));			
//		}
//		
//		randomCards();
//		//Card 버튼 12개를 frame에 붙이기
//		for(Card c :cards) {
//			buttonP.add(c);
//			c.setIcon(icon_back);
//		}	
//		Thread t1=new Thread(new Runnable() {			
//			public void run() {
//				for(Card c :cards) {
//					try {
//						Thread.sleep(100);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//					if(c.card_num==1) {
//						c.setIcon(icon_arr[0]);
//					}else if(c.card_num==2) {
//						c.setIcon(icon_arr[1]);
//					}else if(c.card_num==3) {
//						c.setIcon(icon_arr[2]);
//					}else if(c.card_num==4) {
//						c.setIcon(icon_arr[3]);
//					}else if(c.card_num==5) {
//						c.setIcon(icon_arr[4]);
//					}else if(c.card_num==6) {
//						c.setIcon(icon_arr[5]);
//					}
//					c.setBorder(new LineBorder(Color.BLACK,1));
//					f.validate();
//				}
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//		});
//		Thread t2=new Thread(new Runnable() {			
//			public void run() {
//					for(Card c :cards) {
//						try {
//							Thread.sleep(100);
//						} catch (InterruptedException e) {
//							e.printStackTrace();
//						}
//						c.setIcon(icon_back);
//						c.setBorder(new LineBorder(Color.BLACK,1));
//						f.validate();
//					}
//			}
//		});
//		Thread t3=new Thread(new Runnable() {
//			public void run() {
//				while(true) {
//				try {
//					Thread.sleep(500);
//				} catch (InterruptedException e1) {
//					e1.printStackTrace();
//				}
//					if(clk_arr.size()==2) {
//						if(clk_arr.get(0).card_num!=clk_arr.get(1).card_num) {
//							try {
//								Thread.sleep(300);
//							} catch (InterruptedException e1) {
//								e1.printStackTrace();
//							}
//							for(Card c: clk_arr) {
//								c.setBorder(new LineBorder(Color.RED,3));
//							}
//							try {
//								Thread.sleep(500);
//							} catch (InterruptedException e) {
//								e.printStackTrace();
//							}
//							for(Card c: clk_arr) {
//								c.setIcon(icon_back);
//								c.setBorder(new LineBorder(Color.BLACK,1));
//							}
//						}else {
//							for(Card c: clk_arr) {		
//							c.setBorder(new LineBorder(Color.GREEN,3));
//							c.success=true;
//							score+=10;
//							scoreL.setText("  점수:"+Integer.toString(score)+"점");
//								if(score==120) {
//									dlg2.setVisible(true);
//									res=false;
//								}
//							}
//						}				
//						clk_arr.clear();
//					}
//				}
//			}	
//		});
//		Thread t4=new timer();
//		
//		this.setLayout(new BorderLayout());
//		buttonP.setLayout(new GridLayout(3,4,20,10));
//		resultP.add(timeL);
//		resultP.add(scoreL);
//		this.add(resultP,BorderLayout.NORTH);
//		this.add(buttonP,BorderLayout.CENTER);
//		this.setBounds(600,100,600,800);
//		this.setVisible(true);
//		this.validate();
//		t4.start();			
//		t1.start();
//		try {
//			t1.join();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}	
//		t2.start();
//		try {
//			t2.join();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		setCardAction();						
//		t3.start();
//
//		this.addWindowListener(new WindowHandler());
//	}
//	class timer extends Thread{
//		public void run() {
//			int t=time;
//			try {
//				Thread.sleep(2400);
//			} catch (InterruptedException e1) {
//				e1.printStackTrace();
//			}
//				while(t>0 && res){
//					try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//					t--;
//					timeL.setText("제한 시간: "+Integer.toString(t)+"초");
//					if(res==false) {
//						timeL.setText("성공하셨습니다 !!!!  남은시간 : "+Integer.toString(t)+"초");
//					}
//						if(t==0) {
//							dlg.setVisible(true);
//							timeL.setText("게임 실패!!!");
//							res=false;
//						}
//				}
//		}
//		
//	}
//	class MyDialog extends JDialog{
//		JPanel p= new JPanel();
//	    JLabel l = new JLabel("게임 실패!!!!!!!!!");
//	    JPanel p2= new JPanel();
//	    JButton yesBtn=new JButton("확인");
//
//	    MyDialog(JFrame frame, String title){
//	        super(frame,title);
//	        this.setLayout(new FlowLayout());
//	        p.add(l);
//	        p2.add(yesBtn);
//	        this.add(p);
//	        this.add(p2);
//	        this.setLayout(new GridLayout(2,1));
//	        this.setBounds(700,400,500,200);
//	        yesBtn.addActionListener(new ActionListener(){
//	            public void actionPerformed(ActionEvent ae) {
//	                setVisible(false);
//	            }
//	        });
//	    }
//	}
//	class MyDialog2 extends JDialog{
//		JPanel p= new JPanel();
//	    JLabel l = new JLabel("성공하셨습니다!!!!");
//	    JPanel p2= new JPanel();
//	    JButton yesBtn=new JButton("확인");
//
//	    MyDialog2(JFrame frame, String title){
//	        super(frame,title);
//	        this.setLayout(new FlowLayout());
//	        p.add(l);
//	        p2.add(yesBtn);
//	        this.add(p);
//	        this.add(p2);
//	        this.setLayout(new GridLayout(2,1));
//	        this.setBounds(700,400,500,200); 
//	        yesBtn.addActionListener(new ActionListener(){
//	            public void actionPerformed(ActionEvent ae) {
//	                setVisible(false);
//	            }
//	        });
//	    }
//	}
//	class WindowHandler extends WindowAdapter{
//		public void windowClosing(WindowEvent e) {f.dispose();}
//		public void windowClosed(WindowEvent e) {System.exit(0);}
//	}	
//	public void randomCards() {
//		LinkedList<Integer> card_list=new LinkedList<Integer>(Arrays.asList(cards_nums));
//		for(int i=0; i< cards.length; i++){
//			int random=(int)(new Random().nextDouble()*card_list.size());
//			cards[i]=new Card(card_list.remove(random));
//		}	
//	}
//	public void setCardAction() {
//		for(Card c: cards) {
//			c.addActionListener(new CardActionHander(c));
//		}
//	}
//	class CardActionHander implements ActionListener{
//		Card c;
//		CardActionHander(Card c){
//			this.c=c;
//		}
//		public void actionPerformed(ActionEvent e) {
//			if(!res) return;
//			if(c.success==true) return;
//				if(clk_arr.size()<2) {		
//					if(clk_arr.size()==1 && c==clk_arr.get(0) ) return;
//						System.out.println(c.card_num);
//						clk_arr.add(c);
//						if(c.card_num==1) {
//							c.setIcon(icon_arr[0]);
//						}else if(c.card_num==2) {
//							c.setIcon(icon_arr[1]);
//						}else if(c.card_num==3) {
//							c.setIcon(icon_arr[2]);
//						}else if(c.card_num==4) {
//							c.setIcon(icon_arr[3]);
//						}else if(c.card_num==5) {
//							c.setIcon(icon_arr[4]);
//						}else if(c.card_num==6) {
//							c.setIcon(icon_arr[5]);
//						}
//			}
//		}
//	}
//}
//class Card extends JButton{
//	JButton b;
//	public int card_num;
//	public boolean success=false; //카드 찾기 성공하면 TRUE가 된다.
//	public Card(int card_num) {
//		this.card_num=card_num;
//	}
//}
//public class L06CardGame3{
//	public static void main(String[]args) throws InterruptedException {		
//		try {
//			new CardGameFrame("카드게임");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//}
