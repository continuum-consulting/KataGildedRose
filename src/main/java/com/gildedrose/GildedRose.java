package com.gildedrose;

class GildedRose {
    private static final int MAX_QUALITY = 50;
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (isLegendary(item)) {
                handleLegendary();
            } else if (isAgedBrie(item)) {
                handleAgedBrie(item);
            } else if (isBackstagePass(item)) {
                handleBackstagePass(item);
            } else {
                handleRegularItem(item);
            }
        }

    }

    private void handleLegendary() {
        //do nothing
    }

    private void handleRegularItem(Item item) {
        tryToDecreaseQualityByOne(item);
        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            tryToDecreaseQualityByOne(item);
        }
    }

    private void handleBackstagePass(Item item) {
        increaseQualityByOne(item);
        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 10) {
            increaseQualityByOne(item);
        }

        if (item.sellIn < 5) {
            increaseQualityByOne(item);
        }

        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }

    private void handleAgedBrie(Item item) {
        increaseQualityByOne(item);
        item.sellIn = item.sellIn - 1;
        if (item.sellIn < 0) {
            increaseQualityByOne(item);
        }
    }


    private boolean isAgedBrie(Item item) {
        return item.name.equals("Aged Brie");
    }

    private boolean isBackstagePass(Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isLegendary(Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    private boolean isLowerThanMaxQuality(Item item) {
        return item.quality < MAX_QUALITY;
    }

    private void increaseQualityByOne(final Item item) {
        tryToAdjustQuality(item, 1);
    }

    private void tryToDecreaseQualityByOne(final Item item) {
        tryToAdjustQuality(item, -1);
    }

    private void tryToAdjustQuality(final Item item, final int delta) {
        item.quality += delta;
        if (item.quality > MAX_QUALITY) {
            item.quality = MAX_QUALITY;
        } else if (item.quality < 0) {
            item.quality = 0;
        }
    }
}