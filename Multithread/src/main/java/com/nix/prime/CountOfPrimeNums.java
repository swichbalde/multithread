package com.nix.prime;

import java.util.List;

public class CountOfPrimeNums extends Thread{

    private Integer count = 0;
    private final List<Integer> nums;

    public CountOfPrimeNums(List<Integer> nums) {
        this.nums = nums;
    }

    @Override
    public void run() {
        for (Integer num : nums) {
            if (isPrime(num))
                count = count + 1;
        }
    }

    public boolean isPrime(int prime) {
        int temp;
        boolean isPrime = true;

        for (int i = 2; i <= prime / 2; i++) {
            temp = prime % i;
            if (temp == 0) {
                isPrime = false;
                break;
            }
        }

        return isPrime;
    }

    public int getCount() {
        return count;
    }
}
