package net.wattpadpremium.demo;

import net.wattpadpremium.fastjavapointer.Pointable;
import net.wattpadpremium.fastjavapointer.PointerManager;

public class TestPointable implements Pointable {
    private final int pointer;
    private final PointerManager pointerManager;
    public TestPointable(PointerManager pointerManager) {
        this.pointerManager = pointerManager;
        this.pointer = pointerManager.createNewPointer();
    }

    public void disconnect() {
        pointerManager.releasePointer(pointer);
    }



    @Override
    public int identifiable() {
        return pointer;
    }
}
