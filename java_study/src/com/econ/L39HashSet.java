package com.econ;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class L39HashSet {
	public static void main(String[] args) {
		HashSet<Integer> num_set=new HashSet<Integer>();
		num_set.add(1);
		num_set.add(1);
		num_set.add(1);
		num_set.add(2);
		num_set.add(2);
		num_set.add(3);
		num_set.add(new Integer(3));
		// add가 일어날때 모든 요소중에 같은 것이 있는지 검색후 더한다.(set) 
		System.out.println(num_set);
		
		Set<String> str_set=new HashSet<String>();
		str_set.add("안녕");
		str_set.add("자바");
		str_set.add("야!");
		str_set.add("안녕");
		str_set.add(new String("안녕"));
		// set에서 값을 비교할때 "==" or equals() 중에 어떤것으로 비교하는지 확인
		System.out.println(str_set);
		// Set은 순서가 없다.
		// 객체가 동일한지 equals()로 비교 후 더한다.
		System.out.println(str_set.contains("안녕"));
		System.out.println(str_set.size());
		// set은 사이즈가 있지만 index나 key같이 참조할 수 있는 것이 없다(순서도x)
		// set의 출력은 Iterator밖에 방법이 없다.
		Iterator<String> it =str_set.iterator();
		System.out.println("[");
		while(it.hasNext()) {
			System.out.println(it.next()+",");
		}
		System.out.println("]\n");
	}
}


