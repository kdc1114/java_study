package com.econ.synchronize;

public class L02ThreadError2 {
	static String str="";
	static StringBuffer sb=new StringBuffer("");

	public static void main(String[] args) throws InterruptedException {
		Thread[] t_arr=new Thread[1000];
		for(int k=0; k<1000; k++) {
			Thread t=new Thread() {
				@Override
				public void run() {
					for(int i=0; i<100; i++) {
						str+="a";
						sb.append("a");
					}
				}
			};
			t.start();
			t_arr[k]=t;
		}
		for(Thread t: t_arr) {
			t.join();
		}
		System.out.println(str.length());
		System.out.println(sb.length());
	}

}
