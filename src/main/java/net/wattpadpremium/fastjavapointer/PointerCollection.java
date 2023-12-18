package net.wattpadpremium.fastjavapointer;

import java.util.List;

public interface PointerCollection<K> {
    List<K> all();
    default K find(int pointer){
        ensureCapacity(pointer);
        return all().get(pointer);
    }
    default void insert(int pointer, K value){
        ensureCapacity(pointer);
        all().set(pointer, value);
    }
    private void ensureCapacity(int minimumCapacity){
        while (all().size() <= minimumCapacity){
            all().add(null);
        }
    }
}
