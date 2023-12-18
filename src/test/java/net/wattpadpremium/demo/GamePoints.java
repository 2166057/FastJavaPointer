package net.wattpadpremium.demo;

import net.wattpadpremium.fastjavapointer.PointerCollection;

import java.util.ArrayList;
import java.util.List;

public class GamePoints implements PointerCollection<Integer> {
    private final List<Integer> healths = new ArrayList<>();
    @Override
    public List<Integer> all() {
        return healths;
    }
    @Override
    public Integer instant(int pointer) {
        return healths.get(pointer);
    }
}
