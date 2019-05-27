package com.gildedrose.support;

import com.gildedrose.Item;

class ItemQuery {
    private ItemQuery() {
        //
    }

    static boolean qualityIsNotMoreThen50(Item item) {
        return item.quality < 50;
    }

    static boolean qualityIsNotNegative(Item item) {
        return item.quality > 0;
    }

    static boolean sellByDateHasPassed(Item item) {
        return item.sellIn < 0;
    }

    static boolean sellIn5DaysOrLess(Item item) {
        return item.sellIn <= 5;
    }

    static boolean sellIn10DaysOrLess(Item item) {
        return item.sellIn <= 10;
    }
}
