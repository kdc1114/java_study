package com.econ;
// import java.util.*; String,Integer,Byte,System.....
class Obj{ // 객체x == 오브젝트x,객체의 설계도 -> data==객체 ???
	int i=10; // 객체의 필드,속성,프로퍼티 될 i를 선언
	Obj(){} // 생성자 (생략가능)
}
class Text{
	String s="문자열 필드 s";
}
// 타입 class 이름의 규칙
// 1. 낙타표기법 권장
// 2. 시작문자 대문자 필수(시작을 숫자x , 특수문자 시작 x)
// 3. 영어+숫자 필수("_"외의 특수문자와 다른 언어 금지)
// 4. 실제 이름은 패키지 이름 포함 (com.econ.Obj : class명의 중복을 방지하기 위해)
// 예) com.econ.String (△) , java.util.String(x)

// new Obj() : 객체
// class Obj{} : 타입
// int i : 변수 or 객체의 필드
// Obj o : 변수

/* class Obj{} = 설명서 이름(청사진)
 * int i = 재료 x , 상세치수
 * obj o = 만들기위한 도구 x , 객체에 지어진 이름
 * new 연산자,Obj() 생성자  = 객체를 만드는 도구
 * new Obj() = 실존하는 DATA,건축물
 */
public class L03Type {
	public static void main(String[] args) {
		// type == class
		Obj o = new Obj(); // 객체 생성 규칙 : new 연산자로 생성자를 호출
		// new Obj() 객체의 필드 i를 출력하세요!
		System.out.println(o.i);
		// o = new Text(); = 변수를 처음 선언한 때 타입과 동일한 객체만 참조 가능
		Text t = new Text(); // 생성자 생략 가능
		// t="문자열"; t=new String("문자열");
		t.s+=" / 문자열은 더하기 연산 가능";
		System.out.println(t.s);
	}
}



