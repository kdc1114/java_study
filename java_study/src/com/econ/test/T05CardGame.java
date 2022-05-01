package com.econ.test;

import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

class Card{
	int num;
	String img;
	boolean flip;
	Card(int num){
		this.num=num;
	}
}
public class T05CardGame {
	public static void main(String[]args) {
		// 짝 맞추기 카드게임
		Integer[] cards= {1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9};
		LinkedList<Integer> card_list=new LinkedList<Integer>(Arrays.asList(cards));
		Integer[] random_card=new Integer[18];
		for(int i=0; i<random_card.length; i++) {
			int ran=(int)(new Random().nextDouble()*card_list.size());
			int random_obj=card_list.remove(ran);
			random_card[i]=random_obj;
		}
		System.out.println(new ArrayList<>(Arrays.asList(random_card)));
//		for(int i=0; i<cards.length;) {
//			int ran=cards[(int) (Math.random()*18)];
//			if(random_card[ran]==null) {
//				random_card[ran]=cards[i];
//				i++;
//			}
//		}
//		System.out.println(new ArrayList(Arrays.asList(random_card)));
	}
}
