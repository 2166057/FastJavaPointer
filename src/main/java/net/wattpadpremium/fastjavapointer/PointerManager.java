package net.wattpadpremium.fastjavapointer;


import java.util.HashSet;
import java.util.Set;

public class PointerManager  {
    private final Set<FastCollection<?>> collections = new HashSet<>();
    private final Set<Integer> availablePointers = new HashSet<>();
    private int size = 0;
    public int createNewPointer() {
        if (!availablePointers.isEmpty()) {
            int pointer = availablePointers.iterator().next();
            availablePointers.remove(pointer);
            return pointer;
        }
        size++;
        for (FastCollection<?> collection : collections) {
            collection.resize(size);
        }
        return size - 1;
    }

    public void releasePointer(int pointer) {
        availablePointers.add(pointer);
    }

    public void registerCollection(FastCollection<?> collection) {
        collections.add(collection);
    }
}
