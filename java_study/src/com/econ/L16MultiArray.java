package com.econ;

import java.util.Iterator;

public class L16MultiArray {
	public static void main(String[] args) {
		// String[][] multi=new String[4][3]; // 고정 크기의 2차원 배열 선언
		String[][] multi=new String[4][]; // 2차원 배열을 가변길이로 선언
		multi[0]=new String[3];
		multi[1]=new String[1];
		multi[2]=new String[4];
		multi[3]=new String[5];
		
		String[][] multi_arr = {
								{"고구마","감자","연근"},
								{"사과","배","감","체리"},
								{"토마토","고추","파프리카"},
								{"배추","무","파"}
							};
		
		// 반복문 > 반복문 사용해서 배열형상으로 출력하기
		System.out.println("{");
		for(int i=0; i<multi_arr.length; i++) {
			System.out.print("{");
			for(int j=0; j<multi_arr[i].length; j++) {
				System.out.print(multi_arr[i][j]+",");
			}
			System.out.print("}");
			System.out.print(",\n"); // \n 은 라인 개행의 특수문자
		}
		System.out.println("}");
		
		String [][] stars= {
				{"*"},
				{"*","*"},
				{"*","*","*"},
				{"*","*","*","*"},
				{"*","*","*","*","*"},
				{"*","*","*","*","*","*"}};
		System.out.println("별찍기!");
		for(int i=0; i<stars.length; i++) {
			for(int j=0; j<stars[i].length; j++) {
				System.out.print(stars[i][j]+" ");
			}
			System.out.println("");
		}
		System.out.println("");
		for(int i=stars.length-1; 0<=i; i--) {
			for(int j=0; j<stars[i].length; j++) {
				System.out.print(stars[i][j]+" ");
			}
			System.out.println("");
		}
		System.out.println("");
		System.out.println("배열 없이 별찍기(삼각형 모양으로 바꾸기)");
		for(int i=0; i<6; i++) {
			for(int j=0; j<6-i; j++) {
				System.out.print("* ");
			}
			System.out.println("");
		}
		System.out.println("");
		for(int i=0; i<6; i++) {
			for(int j=0; j<=i; j++) {
				System.out.print("* ");
			}
			System.out.println("");
		}
		
		int[] nums = {-200,10,1,300,-5}; // 버블 정렬 해보세요!
		for(int i=0; i<nums.length-1; i++) { // 입력받은 배열 반복 0 ~ 4까지
// -i를 하는 이유 -> 제일 큰 수가 맨 마지막으로 정렬이 됨 (맨 마지막은 비교 안해도 됨)
			for(int j=0; j<nums.length -i -1; j++) {
				// ex) j = 0일 때, nums[0] > nums[0+1]로 앞자리가 숫자가 더 크다면
				if(nums[j]>nums[j+1]) {// 앞 숫자와 뒤 숫자 서로 비교할 반복문
// 값을 옮겨주기 위해 temp 변수 선언하여 큰 숫자인 nums[0]에 있는 값을 담아준다.
					int temp = nums[j];
	// 그리고 비어있는 앞자리에 숫자가 작은 뒷자리 숫자를 nums[0]에 넣어준다.
					nums[j] = nums[j+1];
	// 임시로 temp에 담아뒀던 큰 숫자를 nums[0+1]자리에 담아주면서 위치를 바꿔준다.
					nums[j+1] = temp;
				}
			}
		}
		for(int i=0; i<nums.length; i++) {
			System.out.print(nums[i]+" ");
		}
	}
}




