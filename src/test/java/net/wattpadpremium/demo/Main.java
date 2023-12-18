package net.wattpadpremium.demo;


import net.wattpadpremium.fastjavapointer.PointerCollection;

import java.util.HashMap;


public class Main {
    private static final PointerCollection<String> fastJavaPointers = new PointerCollection<>();
    private static final HashMap<String,String> hashMap = new HashMap<>();
    public static void main(String[] args) {
        int count = 1;
        while (count < 10000000) {
            count *= 10;
            benchmarkFastJavaPointers(count-1);
            System.gc();
            benchmarkHashMap(count);
            System.gc();
        }
    }

    private static void benchmarkHashMap(int index) {
        long startTime = System.currentTimeMillis();
        for (int i = index; i > 0; i--) {
            hashMap.put(i+"", i+"");
        }

        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;

        System.out.println("\n--------------------------------------------");
        System.out.println("HashMap");
        System.out.println("Inserted Count: " + hashMap.values().size());
        System.out.println("Time taken: " + elapsedTime + " milliseconds");

        long startTime2 = System.currentTimeMillis();
        String value = hashMap.get(index/2 + "");
        long endTime2 = System.currentTimeMillis();
        long elapsedTime2 = endTime2 - startTime2;
        System.out.println("Time taken to get: " + elapsedTime2 + " milliseconds");
        System.out.println("Value: " + value);
        System.out.println("\n--------------------------------------------");
    }

    private static void benchmarkFastJavaPointers(int index) {
        long startTime = System.currentTimeMillis();
        for (int i = index; i > 0; i--) {
            fastJavaPointers.insert(i, i+"");
        }

        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("\n--------------------------------------------");
        System.out.println("Fast Java Pointers");
        System.out.println("Inserted Count: " + fastJavaPointers.all().size());
        System.out.println("Time taken: " + elapsedTime + " milliseconds");

        long startTime2 = System.currentTimeMillis();
        String value = fastJavaPointers.find(index/2);
        long endTime2 = System.currentTimeMillis();
        long elapsedTime2 = endTime2 - startTime2;
        System.out.println("Time taken to get: " + elapsedTime2 + " milliseconds");
        System.out.println("Value: " + value);

    }
}

