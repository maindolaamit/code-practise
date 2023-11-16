package com.codility.practise.iteration;

import java.util.Scanner;

public class BinaryGap {

    /**
     * A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones
     * at both ends in the binary representation of N.
     * <p>
     * For example, number 9 has binary representation 1001 and contains a binary gap of length 2. The number 529 has
     * https://app.codility.com/c/run/training4FZ3PM-WS6/
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println("Binary representation of " + n + " is " + intToBinary(n));
        System.out.println(maxBinaryGap(n));
    }

    public static int maxBinaryGap(int n) {
        String binaryString = intToBinary(n);

        // check if string contains the gap
        if (!binaryString.contains("01") || !binaryString.contains("10")) return 0;
        else {
            String copy = binaryString;
            int maxLength = 0;
            // loop till there is no 10
            while(copy.contains("10")) {
                int startIndex = copy.indexOf("10");
                int endIndex = copy.indexOf("01");
                int length = endIndex - startIndex ;
                if (length > maxLength) maxLength = length;
                copy = copy.substring(endIndex+1);
            }
            return maxLength;
        }
    }

    public static String intToBinary(int n) {
        String value = "";
        int base = 2;
        while (true) {
            int r = n % base, q = n / base;
            value = new String(r + value);
            n = n / base;
            if (q == 0) {
                break;
            }
        }
        return value;
    }
}
