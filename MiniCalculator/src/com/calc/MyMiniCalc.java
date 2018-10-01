package com.calc;

import java.util.Scanner;

/* 
 	Project Name : Mini Calculator

	Discription : In this project we can just use functions like addition,multiplication,division,and subtraction

	Author : Vinay Shetty
*/


public class MyMiniCalc {

	public static void main(String[] args) {
		
		double num1,num2,result; // to store input from user and result after operation
		int option; // use to get the option from user and use it in Switch case
		char choice = 0; // use to ask user if they want to continue or not
		
		System.out.println();
		System.out.println("******************** Welcome to My Mini Calculator *********************");
		
		Scanner sc = new Scanner(System.in);
		do {
					
			System.out.println("Please Enter 1st Number : ");
			num1 = sc.nextDouble();
			System.out.println("Please Enter 2nd Number : ");
			num2 = sc.nextDouble();
			
			System.out.println("Please select one option from below......");
			
			System.out.println("1. Addition");
			System.out.println("2. Subtraction");
			System.out.println("3. Division");
			System.out.println("4. Multiplication");
			
			option = sc.nextInt();
			
			switch(option) {
			case 1 :
				result = num1+num2;
				System.out.println("Addition of two number is : "+result);
				break;
			case 2 :
				result = num1-num2;
				System.out.println("Subtractin of two number is : "+result);
				break;
			case 3 :
				if(num2==0||num2<0) {
					System.out.println("Please enter 2nd number greater then 0 !!!");
				}
				else {
					result = num1/num2;
					System.out.println("Division of two number is : "+result);
				}
				
				break;
			case 4 :
				result = num1*num2;
				System.out.println("Multiplication of two number is : "+result);
				break;
				
			default:
				System.out.println("Please select correct option");
				break;
			}
			
			System.out.println("Do you want to continue... Y/N");
			
			choice = sc.next().charAt(0);
			
		}while(choice=='y'|| choice=='Y');
		
		sc.close();
		System.out.println("Thank you for using our service......");
	}

}
