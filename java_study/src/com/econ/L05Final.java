package com.econ;

class MathInfo{
	final double PI = 3.141592653589793238462643;
}

public class L05Final {
	public static void main(String[] args) {
		// 변수(변할수 있는 수) ??
		// 1. 참조하는 객체가 바뀔 수 있다.
		int i = 10; // js : let (int) i = 10;
		i = 20;
		
		// 상수(변하지[const] 않는 수) const I = 10;
		final int I = 10;
        // I = 20;
		// ?? 상수는 언제 사용하나요?? 
		// let arr = [1,2,3,4];
		// arr = 20;
		// arr[0]; 오류!
		// const arr = [1,2,3,4];
		// arr = 20; 불가능!
		// 정보를 전달하기위해
		// 바뀌면 안되는 값을 정의하기 위해
		System.out.println(Integer.MAX_VALUE);
		final double PI = 3.14; // 바뀌지 않는 정보를 참조할때
		// 상수를 대문자로 작성하는 이유는 변수와 차이를 주기위해(상수를 명시하기위해)
		
		// 반지름이 2인 원의 부피
		// System.out.println(2*2*3.14);
		System.out.println("반지름이2인 원의 부피:"+2*2*new MathInfo().PI);
		
	}
}
