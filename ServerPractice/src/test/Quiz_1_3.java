package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Quiz_1_3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int n;
		System.out.print("please enter number : ");
		BufferedReader inputNum = new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(inputNum.readLine());

		System.out.println();
		
		for(int i=0; i<n; i+=1) {
			for(int j=0; j<(i+1); j+=1) {
				System.out.printf("%4d", j+1 );
			}
			System.out.println();
		}
	}

}
