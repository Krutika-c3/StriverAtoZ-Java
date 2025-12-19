package com.dsa.striver_a_to_z.step1.lec4;

//negative numbers not supported
public class CountDigits {

    static int count(int n) {
        // Special case for 0
        if (n == 0)
            return 1;

        int count = 0;
        while (n > 0) {
            count = count + 1; // increment count
            n = n / 10;    // remove last digit
        }
        return count;
    }

    public static void main(String[] args) {
        int number = 12345;
        System.out.println("Number of digits in " + number + " = " + count(number));
    }
}
