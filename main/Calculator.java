package main;

import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		
    	Scanner sc = new Scanner(System.in);
    	String[] subStr;
    	CounterTest test = new CounterTest();
        String delimeter = " ";
        subStr = sc.nextLine().split(delimeter);
        if (subStr.length==3) {
        	test.str1=subStr[0]; test.str2=subStr[2];
            test.Test();
        }else{
        	System.out.println("Wrong input forat.");
        }
        switch (subStr[1]) {
	        case ("+"):
	            System.out.println(test.plus());
	            break;
	        case ("-"):
	            System.out.println(test.minus());
	            break;
	        case ("*"):
	            System.out.println(test.mult());
	            break;
	        case ("/"):
	            System.out.println(test.div());
	            break;
	        default:
	            System.out.println("Wrong operation");
	            break;
	    }
        sc.close();
	}
}

