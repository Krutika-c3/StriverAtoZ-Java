package com.dsa.StriverAtoZ.step1.lec4;
import java.util.Scanner;

public class PalindromeNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        int revNum = 0;        // variable to store reversed number
        int dup = n;           // store the original number for comparison

        // reverse the number
        while (n > 0) {
            int ld = n % 10;             // get last digit
            revNum = (revNum * 10) + ld; // build reversed number
            n = n / 10;                  // remove last digit
        }

        // check if the reversed number equals the original
        if (dup == revNum)
            System.out.println("True");   // palindrome
        else
            System.out.println("False");  // not palindrome

        sc.close();
    }
}
