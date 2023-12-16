package io.github.somethinginconspicuous.game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Inventory implements Iterable<Item> {

    ArrayList<Item> items = new ArrayList<>();

    @Override
    public Iterator<Item> iterator() {
        return items.iterator();
    }

    public List<Item> asList(){
        return items;
    }
    
}
