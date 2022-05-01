package com.econ;

import java.util.Iterator;

class Month{
	int month; // 1,2,3,4~12
	String en_month; // Jan,Feb ....
	String kr_month; // 1월,2월 ...
	Month(int month,String en_month){
		this.month=month;
		this.en_month=en_month;
		this.kr_month=month+"월";
	}
}
public class L13Array {

	public static void main(String[] args) {
		// Array는 인덱스를 참조키로 사용하는 참조형 데이터 타입
		// 인덱스와 길이를 제외하고 Object의 필드로만 구성된 경량 배열 타임이다.
		String [] month= {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
		Month[] obj_mon= {new Month(1,"Jan"),new Month(2,"Feb"),new Month(3,"Mar"),
				new Month(4,"Apr"),new Month(5,"May"),new Month(6,"Jun"),new Month(7,"Jul")
				,new Month(8,"Aug"),new Month(9,"Sep"),new Month(10,"Oct"),new Month(11,"Nov")
				,new Month(12,"Dec")};
		int[] p_arr= {-3000,1000,12000,2500,500,3000};
		System.out.println(p_arr.length);
		System.out.println(p_arr[4]);
		try {
			System.out.println(p_arr[5]); // 길이는 1부터, 인덱스는 0부터 시작
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		System.out.println("실행 좀 되어주세요");
		
		int  p_arr_total = 0;
		for(int i=0; i<p_arr.length; i++) {
			p_arr_total+=p_arr[i];
		}
		System.out.println(p_arr_total+"won");
		int max = 0; // 처음에 발견한 것이 max
		int max_i = 0;
		for(int i=0; i<p_arr.length; i++) {
			if(i==0) {
				max=p_arr[i];
			}else {
				if(max < p_arr[i]) {
					max=p_arr[i];
					max_i=i;
				}
			}
		}
		System.out.println(max_i+" : "+max);
		int min = 0; // 처음에 발견한 것이 max
		int min_i = 0;
		for(int i=0; i<p_arr.length; i++) {
			if(i==0) {
				min=p_arr[i];
			}else {
				if(min > p_arr[i]) {
					min=p_arr[i];
					min_i=i;
				}
			}
		}
		System.out.println(min_i+" : "+min);
		// 최소값을 찾으세요
		// 최대값을 맨 앞으로 옮겨서 정렬하세요 (선택 정렬)
		for(int i=0; i<p_arr.length -1; i++) {
			// 배열길이 -1 : 마지막 요소는 검사안해도됨
			int max1 = i;
			for(int j=i+1; j<p_arr.length;j++) {
				if(p_arr[max1] < p_arr[j]) {
					max1 = j;
				}
			}
			int temp = p_arr[max1];
			p_arr[max1] = p_arr[i];
			p_arr[i] = temp;
		}
		for(int i:p_arr) {
			System.out.println(i + "");
		}
		
		String[] weeks=new String[7];
		weeks[0]="월요일";
		weeks[1]="화요일";
		weeks[2]="수요일";
		weeks[3]="목요일";
		weeks[4]="금요일";
		weeks[5]="토요일";
		weeks[6]="일요일";
		String[] week = {"월","화","수","목","금","토","일"};
	}
}
