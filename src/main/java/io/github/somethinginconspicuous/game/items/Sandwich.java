package io.github.somethinginconspicuous.game.items;

import javax.swing.ImageIcon;

import io.github.somethinginconspicuous.game.Item;

public class Sandwich implements Item {

    private static Sandwich instance;

    public static Sandwich getInstance(){
        if(instance == null)
            instance = new Sandwich();

        return instance;
    }

    @Override
    public ImageIcon getImageIcon() {
        return new ImageIcon(getClass().getResource("/images/sandwich_hack.png"));
    }

    @Override
    public String name() {
        return "Old Sandwich.";
    }

    @Override
    public String flavor() {
        return "It's sagging and smells a little musty.";
    }
    
}
