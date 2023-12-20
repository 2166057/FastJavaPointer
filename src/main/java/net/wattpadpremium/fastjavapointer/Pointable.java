package net.wattpadpremium.fastjavapointer;


public interface Pointable{
    int identifiable();
    default <T> T readPointer(PointerCollection<T> collection){
        return collection.find(identifiable());
    }
    default <T> void writePointer(PointerCollection<T> collection, T value){
        collection.insertAt(identifiable(), value);
    }
}
