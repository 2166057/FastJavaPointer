package net.wattpadpremium.demo;

import net.wattpadpremium.fastjavapointer.Pointable;
import net.wattpadpremium.fastjavapointer.PointerManager;

public class ExamplePlayer implements Pointable {
    private final int pointer;
    private final PointerManager pointerManager;
    private final String name;
    private int health;
    public ExamplePlayer(String name, int hp, PointerManager pointerManager) {
        this.pointerManager = pointerManager;
        this.name = name;
        this.health = hp;
        this.pointer = pointerManager.createNewPointer();
    }
    public String name() {
        return name;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public int getHealth() {
        return health;
    }

    public void disconnect() {
        pointerManager.releasePointer(pointer);
    }



    @Override
    public int identifiable() {
        return pointer;
    }
}
