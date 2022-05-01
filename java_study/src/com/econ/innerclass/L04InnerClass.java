package com.econ.innerclass;

public class L04InnerClass {
	int a=10;
	int b=20;
	public static void main(String[]args) {
		// 문제 Sum.result()를 호출해서 a+b의 값을 받으세요.
		L04InnerClass i=new L04InnerClass();
		System.out.println(i.new Sum().result());
		System.out.println(new com.econ.innerclass.Sum(i.a,i.b).result());
		
	}
	class Sum{
		public int result() { // com.econ.innerclass.L04InnerClass.Sum
			// 자신을 품고 있는 클래스의 필드를 그대로 사용할 수 있다.
			return a+b;
		}
	}
}
class Sum{
	int a,b;
	public Sum(int a,int b) {
		this.a=a;
		this.b=b;
	}
	public int result() { // com.econ.innerclass.Sum
		return a+b;
	}
}
