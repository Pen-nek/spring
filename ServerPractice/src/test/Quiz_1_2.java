package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Quiz_1_2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int n;
		int k=-1;
		
		System.out.print("please enter number : ");
		BufferedReader inputNum = new BufferedReader(new InputStreamReader(System.in));
		
		n=Integer.parseInt(inputNum.readLine());

		System.out.println();
		
		for(int i=0; i<n; i+=1) {
			for(int j=0; j<n; j+=1) {
				System.out.printf("%4d", (k+=2));
			}
			System.out.println();
		}
	}

}
