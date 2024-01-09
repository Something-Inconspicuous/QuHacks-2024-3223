package io.github.somethinginconspicuous.game.items;

import javax.swing.ImageIcon;

import io.github.somethinginconspicuous.game.Item;

public class Map implements Item {

    private static Map instance;

    public static Map getInstance() {
        if (instance == null)
            instance = new Map();

        return instance;
    }

    @Override
    public ImageIcon getImageIcon() {
        return new ImageIcon(getClass().getResource("/images/pxil-frame-0.png"));
    }

    @Override
    public String name() {
        return "Blood-stained Map";
    }

    @Override
    public String flavor() {
        return "A dusty, stained map. There are 4 yellow dots scattered across it.";
    }

}
