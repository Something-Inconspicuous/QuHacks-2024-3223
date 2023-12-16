package io.github.somethinginconspicuous.game;

public class PlayerCharacter {
    private String name;
    private Inventory inventory;
    private Location location;

    public PlayerCharacter(String name){
        this.name = name;
        setLocation(Location.HOSPITAL);
    }

    public String name(){
        return name;
    }

    public Location location(){
        return location;
    }

    public void setLocation(Location location){
        this.location = location;
    }

    public boolean hasItem(Item item){
        return inventory.contains(item);
    }
}
