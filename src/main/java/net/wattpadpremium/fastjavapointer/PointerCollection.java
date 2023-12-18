package net.wattpadpremium.fastjavapointer;

import java.util.ArrayList;
import java.util.List;

public class PointerCollection<K> {
    private final List<K> all = new ArrayList<>();
    public List<K> all(){
        return all;
    }
    public K find(int pointer){
        ensureCapacity(pointer);
        return all().get(pointer);
    }
    public void insert(int pointer, K value){
        ensureCapacity(pointer);
        all().set(pointer, value);
    }
    private void ensureCapacity(int minimumCapacity){
        while (all().size() <= minimumCapacity){
            all().add(null);
        }
    }
}
