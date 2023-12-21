package net.wattpadpremium.demo;


import net.wattpadpremium.fastjavapointer.FastCollection;
import net.wattpadpremium.fastjavapointer.PointerCollection;
import net.wattpadpremium.fastjavapointer.PointerManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Main {
    private static final String RESET = "\u001B[0m";
    private static final String RED_BOLD = "\033[1;91m";
    private static final String GREEN_BOLD = "\033[1;92m";
    private static final HashMap<Integer,String> hashMap = new HashMap<>();
    private static final PointerManager pointerManager = new PointerManager();
    private static final List<TestPointable> testPointables = new ArrayList<>(10000000);

    public static void main(String[] args) {
        int max = 10000000;
        System.out.println("Starting benchmarking");
        System.out.println("Max: " + max);
        System.out.println("Calculating time to create TestPointables");
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < max; i++) {
            testPointables.add(new TestPointable(pointerManager));
        }
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("Time taken: " + elapsedTime + " milliseconds");


        int count = 1;
        while (count < max) {
            count *= 10;
            benchmarkFastJavaPointers(count);
            System.gc();
            benchmarkHashMap(count);
            System.gc();
        }
    }



    private static void benchmarkHashMap(int addCount) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < addCount; i++) {
            hashMap.put(i, Integer.toString(i));
        }

        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;

        long startTime2 = System.currentTimeMillis();
        for (int i = 0; i < addCount; i++) {
            hashMap.put(testPointables.get(i).identifiable(), Integer.toString(i));
        }
        long endTime2 = System.currentTimeMillis();
        long elapsedTime2 = endTime2 - startTime2;

        System.out.println(RED_BOLD + "--------------------------------------------");
        System.out.println("HashMap");
        System.out.println("Inserted: " + addCount);
        System.out.println("Time taken: " + elapsedTime + " milliseconds");
        System.out.println("Time taken to get: " + elapsedTime2 + " milliseconds");
        System.out.println("--------------------------------------------" + RESET + "\n");
    }

    private static void benchmarkFastJavaPointers(int addCount) {
        PointerCollection<String> collection = new FastCollection<>(pointerManager);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < addCount; i++) {
            collection.insertAt(testPointables.get(i).identifiable(), Integer.toString(i));
        }

        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;

        long startTime2 = System.currentTimeMillis();
        for (int i = 0; i < addCount; i++) {
            collection.find(i);
        }
        long endTime2 = System.currentTimeMillis();
        long elapsedTime2 = endTime2 - startTime2;

        System.out.println(GREEN_BOLD + "--------------------------------------------");
        System.out.println("Fast Java Pointers");
        System.out.println("Count: " + addCount);
        System.out.println("Time taken: " + elapsedTime + " milliseconds");
        System.out.println("Time taken to get: " + elapsedTime2 + " milliseconds");
        System.out.println("--------------------------------------------" + RESET + "\n");
    }

}

