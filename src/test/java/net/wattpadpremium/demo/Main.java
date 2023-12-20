package net.wattpadpremium.demo;


import net.wattpadpremium.fastjavapointer.FastCollection;
import net.wattpadpremium.fastjavapointer.PointerCollection;
import net.wattpadpremium.fastjavapointer.PointerManager;

import java.util.HashMap;


public class Main {
    private static final HashMap<String,String> hashMap = new HashMap<>();
    private static final PointerManager pointerManager = new PointerManager();
    private static final PointerCollection<String> collection = new FastCollection<>(pointerManager);
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
        for (int i = 0; i < index; i++) {
            collection.insertAt(new ExamplePlayer("wish.com",3,pointerManager).identifiable(), i+"");
        }

        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("\n--------------------------------------------");
        System.out.println("Fast Java Pointers");
        System.out.println("Inserted Count: " + collection.all().size());
        System.out.println("Time taken: " + elapsedTime + " milliseconds");

        long startTime2 = System.currentTimeMillis();
        String value = collection.find(index/2);
        long endTime2 = System.currentTimeMillis();
        long elapsedTime2 = endTime2 - startTime2;
        System.out.println("Time taken to get: " + elapsedTime2 + " milliseconds");
        System.out.println("Value: " + value);

    }
}

