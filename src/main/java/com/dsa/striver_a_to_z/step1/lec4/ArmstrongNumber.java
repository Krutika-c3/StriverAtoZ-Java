package com.dsa.striver_a_to_z.step1.lec4;

import java.util.Scanner;

public class ArmstrongNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        int dup = n;            // store original number
        int sum = 0;            // to store the sum of cubes of digits

        // extract each digit and calculate the cube sum
        while (n > 0) {
            int ld = n % 10;          // get last digit
            sum = sum + (ld * ld * ld); // add cube of last digit
            n = n / 10;               // remove last digit
        }

        // check if the cube-sum equals the original number
        if (dup == sum)
            System.out.println("True");   // Armstrong number
        else
            System.out.println("False");  // Not an Armstrong number

        sc.close();
    }
}
