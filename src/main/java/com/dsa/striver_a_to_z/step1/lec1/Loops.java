package com.dsa.striver_a_to_z.step1.lec1;

public class Loops {
 public static void main(String[] args) {
        // Example of a for loop
        System.out.println("For Loop:");
        for (int i = 0; i < 5; i++) {
            System.out.println("Iteration " + i);
        }

        // Example of a while loop
        System.out.println("While Loop:");
        int j = 0;
        while (j < 5) {
            System.out.println("Iteration " + j);
            j++;
        }

        // Example of a do-while loop
        System.out.println("Do-While Loop:");
        int k = 0;
        do {
            System.out.println("Iteration " + k);
            k++;
        } while (k < 5);
 }
}
