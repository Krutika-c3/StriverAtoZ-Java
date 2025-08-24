package com.dsa.StriverAtoZ.step1.lec1;

public class IfElseStatement {
 public static void main(String[] args) {
        int number = 10; // Example number to check

        // Using if-else statement to check if the number is positive, negative, or zero
        if (number > 0) {
            System.out.println("The number is positive.");
        } else if (number < 0) {
            System.out.println("The number is negative.");
        } else {
            System.out.println("The number is zero.");
        }

        // Example of using a ternary operator for a simple condition
        String result = (number % 2 == 0) ? "Even" : "Odd";
        System.out.println("The number is: " + result);
 }
}
