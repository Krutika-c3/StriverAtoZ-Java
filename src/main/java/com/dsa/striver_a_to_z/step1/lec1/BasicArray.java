package com.dsa.striver_a_to_z.step1.lec1;

public class BasicArray {
 public static void main(String[] args) {
        // Example of declaring and initializing an array in Java
        int[] numbers = {1, 2, 3, 4, 5}; // Integer array

        // Printing the elements of the array
        System.out.println("Elements of the array:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Element at index " + i + ": " + numbers[i]);
        }

        // Example of accessing an element in the array
        int firstElement = numbers[0];
        System.out.println("First element: " + firstElement);

        // Example of modifying an element in the array
        numbers[2] = 10; // Changing the third element to 10
        System.out.println("Modified third element: " + numbers[2]);

        // String manipulation using arrays
        String sentence = "Java is awesome";
        // Split the string into words
        String[] words = sentence.split(" ");
        System.out.println("Words in the sentence:");
        for (String word : words) {
            System.out.println(word);
        }

        // Join array elements into a single string
        String joined = String.join("-", words);
        System.out.println("Joined with hyphens: " + joined);

        // Reverse a string using a character array
        char[] chars = sentence.toCharArray();
        for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        String reversed = new String(chars);
        System.out.println("Reversed string: " + reversed);
 }
}
