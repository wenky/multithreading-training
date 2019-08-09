package com.wenky.solutions;

public class ABCPrinter {
public static void main(String[] args) {
	Printer A=new Printer("A");
	Printer B=new Printer("B");
	Printer C=new Printer("C");
	A.start();
	B.start();
	C.start();
}
}
