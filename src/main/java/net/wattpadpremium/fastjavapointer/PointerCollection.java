package net.wattpadpremium.fastjavapointer;

import java.util.List;

public interface PointerCollection<K> {
    List<K> all();
    K find(int index);
    void insertAt(int index, K value);
}
