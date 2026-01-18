package com.dsa.striver_a_to_z.step1.lec1;

import java.util.Scanner;

public class InputOutput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        printNumber(sc);
    }
    public static void printNumber(Scanner sc) {
        System.out.println(sc.next());
    }
}