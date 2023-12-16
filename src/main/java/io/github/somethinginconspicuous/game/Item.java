package io.github.somethinginconspicuous.game;

import javax.swing.ImageIcon;

public interface Item {
   ImageIcon getImageIcon();

   String name();
   String flavor();
}
