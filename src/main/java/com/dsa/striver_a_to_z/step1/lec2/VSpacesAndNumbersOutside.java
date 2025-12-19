package com.dsa.striver_a_to_z.step1.lec2;

public class VSpacesAndNumbersOutside {

    private static void pattern(int n) {
        for (int i = 1; i <= n; i++) {
            //numbers
            for (int k = 1; k <= i; k++) {
                System.out.print(k);
            }
            int spaces = 2 * n - 2 * i;
            for (int j = 1; j <= spaces; j++) {
                System.out.print(" ");
            }
            //numbers
            for (int l = i; l >= 1; l--) {
                System.out.print(l);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 4;
        pattern(n);
    }
}
