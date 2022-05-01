package com.econ;
// 계산기
// 생성자에 연산할 수를 입력하고
// abstract calc()에서 원하는 형태로 연산을 구현하고
// enter()를 호출하면 콘솔에 sum의 결과를 출력
abstract class Calculater{
	int a,b;
	public Calculater(int a,int b) {
		this.a=a;
		this.b=b;
	}
	abstract int calc(); // 연산의 결과를 반환
	public void enter() {
		System.out.println("연산의 결과는 "+this.calc()+"입니다.");
	}
}


public class L32AbstractClass3 {
	public static void main(String[]args) {
		// 추상클래스는 구현이 덜된 것이 있어서 무조건 바디를 작성한다.
		Calculater cal=new Calculater(10,20) {
			public int calc() {
				return this.a*this.b;
			}
		};
		cal.enter();
		// a/b 결과를 출력하세요.
		//////////////////////////////////////
		Calculater cal2=new Calculater(20,10) {
			public int calc() {
				return this.a/this.b;
			}
		};
		cal2.enter();
	}
}




