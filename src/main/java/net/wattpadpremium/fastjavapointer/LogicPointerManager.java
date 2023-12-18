package net.wattpadpremium.fastjavapointer;


import java.util.HashSet;
import java.util.Set;

public class LogicPointerManager implements PointerManager{
    private final Set<Integer> usedPointers = new HashSet<>();
    private int nextPointer = 0;

    public int createNewPointer() {
        while (usedPointers.contains(nextPointer)) {
            nextPointer++;
        }
        usedPointers.add(nextPointer);
        return nextPointer++;
    }

    public int releasePointer(int pointer) {
        usedPointers.remove(pointer);
        return pointer;
    }
}
