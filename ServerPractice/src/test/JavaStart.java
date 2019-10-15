package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JavaStart {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int a,b,c;
		
		System.out.print("please enter first number(a) : ");
		BufferedReader inputNum = new BufferedReader(new InputStreamReader(System.in));		// 키보드에서 값을 입력받을 수 있는 방법 중 하나!
		
		a=Integer.parseInt(inputNum.readLine());
		
		System.out.print("Please enter second number(b) : ");
		inputNum=new BufferedReader(new InputStreamReader(System.in));
		
		b=Integer.parseInt(inputNum.readLine());
		
		c=a+b;
		
		System.out.println("a = " + a +", b = " + b +", c = "+ c);
	}
}
