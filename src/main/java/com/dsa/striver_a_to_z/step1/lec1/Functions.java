package com.dsa.striver_a_to_z.step1.lec1;

public class Functions {
 public static void main(String[] args) {
        // Example of a simple function to reverse a string
        String input = "Hello, World!";
        String reversed = reverseString(input);
        System.out.println("Reversed string: " + reversed);

        // Example of a function with parameters and return type
        int sum = addNumbers(5, 10);
        System.out.println("Sum of 5 and 10: " + sum);

        // Theory: Pass by Value in Java
        /*
         * In Java, all method arguments are passed by value.
         *
         * For primitive types (int, double, etc.):
         * - The actual value is copied and passed to the method.
         * - Any changes to the parameter inside the method do NOT affect the original variable.
         *   Example: If you pass an int x=5 to a method and set x=10 inside the method,
         *   the original x outside the method remains 5.
         *
         * For objects (arrays, custom classes, etc.):
         * - Objects are essentially reference values in Java.
         * - The value of the reference (the memory address) is copied and passed to the method.
         * - Both the original and the method parameter point to the same object in memory.
         * - Because the reference is copied, any changes to the object inside the method
         *   (such as modifying fields or array elements) will change the original object.
         *   Example: If you pass an array and change array[0] inside the method,
         *   the change is visible outside the method.
         * - However, if you reassign the reference inside the method (e.g., array = new int[5];),
         *   this does NOT affect the original reference outside the method.
         *
         * Summary:
         * - Primitive: changes inside method do NOT affect original.
         * - Object: changes to internal state DO affect original, but reassigning the reference does NOT.
         */

        // Example with primitive type (pass by value)
        int num = 20;
        modifyPrimitive(num);
        System.out.println("After modifyPrimitive, num: " + num); // Output: 20

        // Example with object reference (reference passed by value)
        int[] arr = {1, 2, 3};
        modifyArray(arr);
        System.out.print("After modifyArray, arr: ");
        for (int n : arr) {
            System.out.print(n + " ");
        }
        System.out.println(); // Output: 10 2 3
    }

    // Function to reverse a string
    public static String reverseString(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }

    // Function to add two numbers
    public static int addNumbers(int a, int b) {
        return a + b;
    }

    // Function to demonstrate pass by value with primitive
    public static void modifyPrimitive(int x) {
        x = 100; // Only changes local copy
    }

    // Function to demonstrate pass by value with object reference
    public static void modifyArray(int[] array) {
        array[0] = 10; // Modifies the original array
    }
}
