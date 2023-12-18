package net.wattpadpremium.fastjavapointer;

public class SingleWayPointerManager implements PointerManager{
    private int index = 0;
    @Override
    public int createNewPointer() {
        final int pointer = index;
        index++;
        return pointer;
    }
}
