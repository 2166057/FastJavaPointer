package net.wattpadpremium.fastjavapointer;

import java.util.List;
import java.util.ArrayList;
public class FastCollection<K> implements PointerCollection<K>{
    private List<K> elements;
    public FastCollection(PointerManager pointerManager) {
        pointerManager.registerCollection(this);
        this.elements = new ArrayList<>(pointerManager.size());
        for (int i = 0; i < pointerManager.size(); i++) {
            elements.add(null);
        }
    }
    @Override
    public List<K> all() {
        return elements;
    }

    @Override
    public K find(int index) {
        return elements.get(index);
    }

    @Override
    public void insertAt(int index, K value) {
        elements.set(index, value);
    }
    public void resize(int size) {
        if (size > elements.size()) {
            ArrayList<K> newList = new ArrayList<>(size);
            newList.addAll(elements);

            for (int i = elements.size(); i < size; i++) {
                newList.add(null);
            }

            this.elements = newList;
        }
    }

}
