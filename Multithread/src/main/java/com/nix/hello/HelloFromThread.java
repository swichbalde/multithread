package com.nix.hello;

public class HelloFromThread extends Thread {

    private int coff;

    @Override
    public void run() {
        try {
            Thread.sleep(coff * 10L * Runtime.getRuntime().availableProcessors());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hello from " + Thread.currentThread().getName());
    }

    public void setCoff(int coff) {
        this.coff = coff;
    }
}
