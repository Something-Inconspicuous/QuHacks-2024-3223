package io.github.somethinginconspicuous.game;

public class PlayerCharacter {
    private String name;
    private Inventory inventory;

    public PlayerCharacter(String name){
        this.name = name;
    }

    public String name(){
        return name;
    }
}
