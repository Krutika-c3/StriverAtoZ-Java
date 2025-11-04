package com.dsa.StriverAtoZ.step1.lec4;

import java.util.Scanner;

public class ReverseNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        int revNum = 0;        // this will store the reversed number

        // Repeat until all digits are processed
        while (n > 0) {
            int ld = n % 10;           // get the last digit of n (remainder when divided by 10)
            revNum = (revNum * 10) + ld; // shift existing digits left and add the new last digit
            n = n / 10;                // remove the last digit from n
        }

        System.out.println("Reversed number: " + revNum);

        sc.close();
    }
}

