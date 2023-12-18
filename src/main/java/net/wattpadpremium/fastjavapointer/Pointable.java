package net.wattpadpremium.fastjavapointer;


public class Pointable {
    private final int pointer;
    public Pointable(PointerManager pointerManager) {
        this(pointerManager.createNewPointer());
    }
    private Pointable(int pointer) {
        this.pointer = pointer;
    }
    public <T> T getInstant(PointerCollection<T> collection){
        return collection.find(pointer);
    }
    public <T> void setInstant(PointerCollection<T> collection, T value){
        collection.insert(pointer, value);
    }
}
