package io.github.somethinginconspicuous.game.items;

import java.io.InputStream;

import javax.swing.ImageIcon;

import io.github.somethinginconspicuous.game.Item;

public class Coat implements Item {

    private static Coat instance;

    public static Coat getInstance(){
        if(instance == null)
            instance = new Coat();

        return instance;
    }

    @Override
    public ImageIcon getImageIcon() {
        return new ImageIcon(getClass().getResource("/images/coat_hack.png"));
    }

    @Override
    public String name() {
        return "Coat.";
    }

    @Override
    public String flavor() {
        return "It's yellow and fuzzy, like a duck.";
    }
    
}
