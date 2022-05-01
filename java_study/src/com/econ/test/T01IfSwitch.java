package com.econ.test;

public class T01IfSwitch {

	public static void main(String[] args) {
		
		long start2=(System.currentTimeMillis());
		System.out.println(2+3);
		long end2=(System.currentTimeMillis());
		System.out.println("2+3 : "+(end2-start2));
		// 나노세컨드(1/1000000000초) jvm이 켜지는 시간부터 0이 시작
		
		long start=(System.nanoTime());
		System.out.println(2+3);
		long end=(System.nanoTime());
		System.out.println("2+3 : "+(end-start));
		System.out.println();
		
		int score=55;
		String grade="";
		if(score>=90) {
			grade="A";
		}else if(score>=80) {
			grade="B";
		}else if(score>=70) {
			grade="C";
		}else if(score>=60) {
			grade="D";
		}else {
			grade="F";
		}
		System.out.println("당신의 성적은"+grade+"입니다.");
		end=System.nanoTime();
		System.out.println("성적 if : "+(end-start));
		System.out.println();
		
		switch(score/10) {
			case 10:
				grade="A+";
				break;
			case 9:
				grade="A";
				break;
			case 8:
				grade="B";
				break;
			case 7:
				grade="C";
				break;
			case 6:
				grade="D";
				break;
			default:
				grade="F";
				break;
		}
		System.out.println("당신의 성적은"+grade+"입니다.");
		end=System.nanoTime();
		System.out.println("성적 switch : "+(end-start));
		
	}

}
