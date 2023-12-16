package io.github.somethinginconspicuous.game.items;

import javax.swing.ImageIcon;

import io.github.somethinginconspicuous.game.Item;

public class Keycard implements Item {

    private static Keycard instance;

    public static Keycard getInstance() {
        if (instance == null)
            instance = new Keycard();

        return instance;
    }

    @Override
    public ImageIcon getImageIcon() {
        return new ImageIcon("src/main/resources/images/keycard_hack.png");
    }

    @Override
    public String name() {
        return "Keycard.";
    }

    @Override
    public String flavor() {
        return "A plastic blue card, engraved with intricate patterns.";
    }

}
