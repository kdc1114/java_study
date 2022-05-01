package com.econ.test;

import java.util.Random;
import java.util.Scanner;

public class T04RockPaperScissors {

	public static void main(String[] args) {
		System.out.println(new Random().nextDouble()); // Math.random()과 같다.
		boolean t=true;
		do {
		String[] rps= {"가위","바위","보"};
		Scanner sc=new Scanner(System.in);
		System.out.print("가위(0),바위(1),보(2) : ");
		String input=sc.next();
		int parse_input = Integer.parseInt(input);
		int com = (int) (Math.random()*3);
		System.out.println(rps[parse_input]+"vs"+rps[com]);
		int result = parse_input-com;
		if(result==1 || result==-2) {
			System.out.println("승리");
		}else if(result==0) {
			System.out.println("비김");
		}else {
			System.out.println("졌음");
		}
		System.out.println();
		}while(t);
		// 승리  패배
		// 0 2   0 1
		// 1 0	 1 2
		// 2 1   2 0
	}

}
