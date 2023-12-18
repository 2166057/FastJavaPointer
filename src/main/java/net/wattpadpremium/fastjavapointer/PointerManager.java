package net.wattpadpremium.fastjavapointer;

public interface PointerManager {
    int createNewPointer();
    static SingleWayPointerManager createSingleWayPointerManager(){
        return new SingleWayPointerManager();
    }
    static LogicPointerManager createLogicPointerManager(){
        return new LogicPointerManager();
    }
}
