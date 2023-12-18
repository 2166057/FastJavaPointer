package net.wattpadpremium.demo;


import net.wattpadpremium.fastjavapointer.PointerCollection;

public class Main {
    private static final PointerCollection<Integer> gamePoints = new GamePoints();

    public static void main(String[] args) {
        Player player = new Player("Player", 100);
        player.setHealth(50);
        System.out.println("Player health: " + player.getHealth());
        player.setInstant(gamePoints, 100);
        System.out.println("Player points: " + player.getInstant(gamePoints));
    }
}
