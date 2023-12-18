package net.wattpadpremium.fastjavapointer;

public class Pointer {
    private final int pointer;
    public Pointer(PointerManager pointerManager) {
        this(pointerManager.createNewPointer());
    }
    private Pointer(int pointer) {
        this.pointer = pointer;
    }
    public int index() {
        return pointer;
    }
}
