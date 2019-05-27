package com.gildedrose.support;

import com.gildedrose.Item;

public abstract class AbstractItemHandler implements ItemHandler {
    private Item item;

    AbstractItemHandler(Item item) {
        this.item = item;
    }

    public Item item() {
        return item;
    }
}
