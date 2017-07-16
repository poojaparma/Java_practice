package com.java.practice;

public class Addition {
	public static void main(String[] args) {
		System.out.println("hello: " + ultimateSum(571));
	}
	static int ultimateSum(int number) {

		int n = number,r=0,sum = 0;

		while(n>10){
		r= n%10;
		n=n/10;
		sum = sum+r;
		// System.out.println(sum);

		}
		sum = sum +n;
		System.out.println(sum);
		if(sum > 10){
			return ultimateSum(sum);
		}
		return sum;
		}
	
}
