package io.github.somethinginconspicuous.game;

public class PlayerCharacter {
    private String name;
    private Inventory inventory;
    private Location location;

    public PlayerCharacter(String name){
        this.name = name;
        inventory = new Inventory();
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

    public void addItem(Item item){
        inventory.addItem(item);
    }
}
