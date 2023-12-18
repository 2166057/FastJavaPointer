package net.wattpadpremium.demo;

import net.wattpadpremium.fastjavapointer.LogicPointerManager;
import net.wattpadpremium.fastjavapointer.Pointable;
import net.wattpadpremium.fastjavapointer.PointerManager;

public class Player extends Pointable {
    private static final LogicPointerManager pointerManager = PointerManager.createLogicPointerManager();
    private final String name;
    private int health;
    public Player(String name, int hp) {
        super(pointerManager);
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
}
