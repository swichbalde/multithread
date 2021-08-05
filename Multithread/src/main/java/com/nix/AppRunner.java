package com.nix;

import com.nix.hello.HelloFromThread;
import com.nix.prime.CountOfPrimeNums;

import java.util.List;

public class AppRunner {

    public static void main(String[] args) throws InterruptedException {
        helloThread();
        Thread.sleep(1500);
        countPrime();
    }

    private static void helloThread() {
        for (int i = 0; i < 50; i++) {
            HelloFromThread helloFromThread = new HelloFromThread();
            helloFromThread.setCoff((50 - i));
            helloFromThread.start();
        }
    }

    private static void countPrime() throws InterruptedException {
        List<Integer> nums1 = List.of(1, 2, 3, 4, 5);
        List<Integer> nums2 = List.of(6, 7, 8, 9, 10, 7);

        CountOfPrimeNums countOfPrimeNums = new CountOfPrimeNums(nums1);
        countOfPrimeNums.start();
        while (countOfPrimeNums.isAlive())
            Thread.sleep(100);
        int count = countOfPrimeNums.getCount();
        countOfPrimeNums = new CountOfPrimeNums(nums2);
        countOfPrimeNums.start();
        while (countOfPrimeNums.isAlive())
            Thread.sleep(100);
        count += countOfPrimeNums.getCount();
        System.out.println("count = " + count);
    }
}
