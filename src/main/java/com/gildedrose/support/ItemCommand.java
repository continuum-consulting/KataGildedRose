package com.gildedrose.support;

import com.gildedrose.Item;

class ItemCommand {
    private ItemCommand() {
        //
    }

    static void decreaseQualityByOne(Item item) {
        item.quality = item.quality - 1;
    }

    static void decreaseSellInByOne(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    static void increaseQualityByOne(Item item) {
        item.quality = item.quality + 1;
    }

}
