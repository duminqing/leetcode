package com.test;

public class Zhisu {

    public static void main(String[] args) {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            if (isZS(i)) {
                sum += i;
            }
        }
        System.out.println("SUM = " + sum);
    }

    public static boolean isZS(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
