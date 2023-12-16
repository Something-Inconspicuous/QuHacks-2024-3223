package io.github.somethinginconspicuous.game.items;

import javax.swing.ImageIcon;

import io.github.somethinginconspicuous.Main;
import io.github.somethinginconspicuous.game.Item;

public class Watch implements Item {

    private static Watch instance;

    public static Watch getInstance() {
        if (instance == null)
            instance = new Watch();

        return instance;
    }

    @Override
    public ImageIcon getImageIcon() {
        return new ImageIcon("src/main/resources/images/watch_hack.png");
    }

    @Override
    public String name() {
        return "A digital watch.";
    }

    @Override
    public String flavor() {
        // Shows time in its description even tho it's arbitrary
        return "It’s ticking backwards. The time reads: " + 
            Main.timeLimit().hoursLeft() + ":" + Main.timeLimit().minutesOnlyLeft() + ".";
    }

}
