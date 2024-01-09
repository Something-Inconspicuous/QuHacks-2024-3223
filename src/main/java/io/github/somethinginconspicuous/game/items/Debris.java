package io.github.somethinginconspicuous.game.items;

import javax.swing.ImageIcon;

import io.github.somethinginconspicuous.game.Item;

public class Debris implements Item {

    private static Debris instance;

    public static Debris getInstance(){
        if(instance == null)
            instance = new Debris();

        return instance;
    }

    @Override
    public ImageIcon getImageIcon() {
        return new ImageIcon(getClass().getResource("/images/debris_hack.png"));
    }

    @Override
    public String name() {
        return "Debris.";
    }

    @Override
    public String flavor() {
        return "It's hefty, but looks like it could break at any moment.";
    }
    
}
