package io.github.somethinginconspicuous.game.items;

import javax.swing.ImageIcon;

import io.github.somethinginconspicuous.game.Item;

public class Key implements Item {

    private static Key instance;

    public static Key getInstance() {
        if (instance == null)
            instance = new Key();

        return instance;
    }

    @Override
    public ImageIcon getImageIcon() {
        return new ImageIcon("src/main/resources/images/imageedit_25_6825500106_hack.png");
    }

    @Override
    public String name() {
        return "Receptionist's Key.";
    }

    @Override
    public String flavor() {
        return "A fancy key scavenged from the receptionist. It can only be used on something as elaborate as itself.";
    }

}
