package com.gildedrose.support;

import com.gildedrose.Item;

import static com.gildedrose.support.ItemQuery.qualityIsNotNegative;

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

    static void tryToDecreaseQualityBy(Item item, int delta) {
        int counter = 0;
        while (counter++ < delta) {
            tryToDecreaseQualityByOne(item);
        }
    }

    private static void tryToDecreaseQualityByOne(Item item) {
        if (qualityIsNotNegative(item)) {
            decreaseQualityByOne(item);
        }
    }

}
