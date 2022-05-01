package com.econ.input_output;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
// image.jpg 의 상대경로
// jvm 은 teacher_java 이하 경로에 실행되기 때문에 상대경로('./',' ')의 시작은 프로젝드 	폴더가 된다.
// ./src/com/econ/input_output/image.jpg
// 절대경로 = C:\Users\K\Desktop\java_study\java_study\src\com\econ\input_output\jv11190820.jpg
// 상대경로 = src/com/econ/input_output/image.jpg or
//            ./src/com/econ/input_output/image.jpg

class CardFrame extends JFrame{
	JLabel image=new JLabel("이미지");
	public CardFrame() throws IOException {
		// 이미지는 색의 블럭의 조합 => 어떤 색블럭을 사용 할 건지 정해야한다.
		BufferedImage thumbnail=new BufferedImage(300, 150, BufferedImage.TYPE_3BYTE_BGR);
		// BufferedImage 작게 그림을 그릴때 대상이되는 이미지 파일 불러오기
		BufferedImage img=ImageIO.read(new File("src/com/econ/input_output/image.jpg"));
		thumbnail.createGraphics().drawImage(img, 0, 0, 300, 150, null);
		
		ImageIcon ii=new ImageIcon(thumbnail);
		image.setIcon(ii);
		this.add(image);
		this.setBounds(0, 0, 300, 150);
		this.setVisible(true);
	}
}

public class L03ImageInput {

	public static void main(String[] args) {
		try {
			new CardFrame();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
