package com.econ;

class Engine{
	int oil;
	int RPM;
	public void upRPM(int oil) {
		this.oil=oil;
		++this.RPM;
	}
	public void downAccel(int push) {}
}

// Interface는 class의 설계도(type을 명시하기 전에 스케치 하는것)
interface Carable{ // 자동차의 설계도 => 바디를 명시할 수 없다.
	String handle="핸들"; // String final static handle="핸들";(class 변수)
	// Carble(){}// 인터페이스는 객체의 설계도기 때문에 생성자를 명시할 수 없다.
	void turnLeft(int left);
	void turnRight(int ritht);
	void downAccel(int push);
	//private void upRPM(int oil) {}
	// private은 내부에서만 사용가능한데 인터페이스는 설계도의 설계도이기 때문에
	// private은 쓸모가 없다.
	// The method upRPM(int) from the type Carble is never used locally???
}
interface Carable2{
	// 바디가 구현되지 않은 메소드를 추상메소드라 하고 interface내부에서는 	생략가능(모든 메소드가 추상메소드)하다.
	public abstract void moveForward();
	public abstract void moveBackward();
	public abstract void downAccel(int push);
}

// 인터페이스는 extends가 아니라 implements로 구현해야한다.
class BMW extends Engine implements Carable,Carable2{
	// 인터페이스에는 메소드만 존재하고 멤버 변수가 없기 때문에 상속받은 변수와 멤버 		변수가 겹치지않는다.
	// 인터페이스의 메소드는 구현되지 않은 설계도 형태기 때문에 상속받은 메소드와 		이름이 겹쳐도 아무 상관이 없다.
	public void turnLeft(int left) {}
	public void turnRight(int ritht) {}
	public void downAccel(int push) {}//Engine의 메소드가 우선순위가 높다.
	public void moveForward() {}
	public void moveBackward() {}
}
class QM3 extends Engine implements Carable{
	@Override
	public void turnLeft(int left) {}
	@Override
	public void turnRight(int ritht) {
		super.downAccel(20);
	}
}
class moveCar{
	Carable b;
	public moveCar(Carable b) {
		this.b=b;
	}
	public void leftMove(int a) {
		b.turnLeft(a);
		System.out.println(a+"만큼 왼쪽으로 움직였다.");
	}
	public void rightMove(int a) {
		b.turnRight(a);
		System.out.println(a+"만큼 오른쪽으로 움직였다.");
	}
}
/* 1.인터페이스의 추상 메소드 구현이 "{}" 바디를 추가하는것이다.
 * 2.class의 메소드는 구현이되어있고 추상메소드는 구현되지 않았기 때문에 우선순위가높다
 * 3.추상메소드(바디없고 abstract라고 써진 메소드),
 * interface(모든 메소드가 추상이고 멤버 변수가 없는 껍데기 설계도),
 * implements(class가 인터페이스를 구현할 때 사용하는 명령어)
 */
public class L29Interface {
	public static void main(String[] args) {
		System.out.println(Carable.handle);
		// Carble c=new Carble(); // 인터페이스는 객체가 될 수 없다.
		BMW b=new BMW();
		Carable bmw =(Carable) new BMW();
		Carable qm3 = new QM3();
		// 두개의 다른 타입의 객체를 1개의 타입으로 참조함
		
		new moveCar(new BMW()).rightMove(100);
		new moveCar(new QM3()).rightMove(50);
	}
}
