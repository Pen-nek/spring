package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Quiz_1_1 {

	public static void main(String args[])throws Exception {

		// 내 답
		int n;
		int j;
		int k = 0;

		System.out.print("please enter number : ");
		BufferedReader inputNum = new BufferedReader(new InputStreamReader(System.in));

		n=Integer.parseInt(inputNum.readLine());

		System.out.println();
		for(int i=0; i<n; i+=1) {
			for(j=0; j<n; j+=1) {
				System.out.printf("%4d", j+(1+k) );
			}
			System.out.println();
			k += n;
		}

		
		
//		// 정답
//		int n,k;
//		System.out.print("please enter number : ");
//		BufferedReader inputNum = new BufferedReader(new InputStreamReader(System.in));
//		n=Integer.parseInt(inputNum.readLine());
//
//		System.out.println();
//		
//		// 1씩 증가하는 변수
//		k=0;
//		
//		for(int i=0; i<n; i+=1) {
//			for(int j=0; j<n; j+=1) {
//				System.out.printf("%4d", (k+=1));
//			}
//			System.out.println();
//		}
	}
}