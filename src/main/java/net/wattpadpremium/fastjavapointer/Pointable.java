package net.wattpadpremium.fastjavapointer;


public interface Pointable{
    int pointerIndex();
    default <T> T readPointer(PointerCollection<T> collection){
        return collection.find(pointerIndex());
    }
    default <T> void writePointer(PointerCollection<T> collection, T value){
        collection.insert(pointerIndex(), value);
    }
}
