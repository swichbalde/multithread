package com.nix;

import com.nix.hello.HelloFromThread;
import com.nix.prime.CountOfPrimeNums;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class AppRunner {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Choose operation" +
                "\n1. Hello tread 49 -> 0" +
                "\n2. Count prime nums");
        try {
            int choose = Integer.parseInt(reader.readLine());

            switch (choose) {
                case 1:
                    helloThread();
                    break;
                case 2:
                    List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 7);
                    countPrime(nums);
                    break;
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Wrong input");
        }
    }

    private static void helloThread() {
        for (int i = 0; i < 50; i++) {
            HelloFromThread helloFromThread = new HelloFromThread();
            helloFromThread.setCoff((50 - i));
            helloFromThread.start();
        }
    }

    private static void countPrime(List<Integer> nums) {

        List<Integer> nums1 = nums.subList(0, nums.size() / 2);
        List<Integer> nums2 = nums.subList(nums.size() / 2, nums.size());

        CountOfPrimeNums countOfPrimeNums1 = new CountOfPrimeNums(nums1);
        countOfPrimeNums1.start();

        CountOfPrimeNums countOfPrimeNums2 = new CountOfPrimeNums(nums2);
        countOfPrimeNums2.start();

        try {
            countOfPrimeNums1.join();
            countOfPrimeNums2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int count = countOfPrimeNums1.getCount();
        count += countOfPrimeNums2.getCount();

        System.out.println("Count of primes = " + count);
    }
}
