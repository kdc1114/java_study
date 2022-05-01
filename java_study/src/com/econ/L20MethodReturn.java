package com.econ;
// class Calc{} // com.econ.Calc 중복될 수 없다.
public class L20MethodReturn {
	// 함수의 리턴과 종료
	public static int a = 10;
	public static String concat(char a,char b) {
		// a+b = ('a'+'b') => "ab" (x) , 195(0)
		String str = "";
		if(a == ' ') {
			str=a+""+b;
			return str;
		}
		str = "a+b : \""+str+"\"";
		return str;
	}
	
	public static void main(String[] args) {
		System.out.println(L20MethodReturn.concat(' ', 'd'));
	}
}
