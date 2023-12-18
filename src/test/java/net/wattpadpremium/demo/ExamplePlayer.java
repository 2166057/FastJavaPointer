package net.wattpadpremium.demo;

import net.wattpadpremium.fastjavapointer.LogicPointerManager;
import net.wattpadpremium.fastjavapointer.Pointable;
import net.wattpadpremium.fastjavapointer.Pointer;
import net.wattpadpremium.fastjavapointer.PointerManager;

public class ExamplePlayer implements Pointable {
    private static final LogicPointerManager pointerManager = PointerManager.createLogicPointerManager();
    private final Pointer pointer = new Pointer(pointerManager);
    private final String name;
    private int health;
    public ExamplePlayer(String name, int hp) {
        this.name = name;
        this.health = hp;
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

    @Override
    public int pointerIndex() {
        return pointer.index();
    }
}
