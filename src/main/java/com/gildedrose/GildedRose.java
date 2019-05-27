package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (isOfAgedBrieCategory(item)) {
                handleAgedBrieItem(item);
            } else if (isOfSulfurasCategory(item)) {
                handleSulfurasItem(item);
            } else if (isOfBackstagePassesCategory(item)) {
                handleBackstagePassesItem(item);
            } else {
                handleDefaultItem(item);
            }
        }
    }

    // Handling commands
    private void handleAgedBrieItem(Item item) {
        if (qualityIsNotMoreThen50(item)) {
            increaseQualityByOne(item);
        }

        decreaseSellInByOne(item);

        if (sellByDateHasPassed(item)) {
            if (qualityIsNotMoreThen50(item)) {
                increaseQualityByOne(item);
            }
        }
    }

    private void handleBackstagePassesItem(Item item) {
        if (qualityIsNotMoreThen50(item)) {
            increaseQualityByOne(item);
            if (sellIn10DaysOrLess(item)) {
                if (qualityIsNotMoreThen50(item)) {
                    increaseQualityByOne(item);
                }
            }
            if (sellIn5DaysOrLess(item)) {
                if (qualityIsNotMoreThen50(item)) {
                    increaseQualityByOne(item);
                }
            }
        }

        decreaseSellInByOne(item);

        if (sellByDateHasPassed(item)) {
            item.quality = 0;
        }
    }

    private void handleDefaultItem(Item item) {
        if (qualityIsNotNegative(item)) {
            decreaseQualityByOne(item);
        }

        decreaseSellInByOne(item);

        if (sellByDateHasPassed(item)) {
            if (qualityIsNotNegative(item)) {
                decreaseQualityByOne(item);
            }
        }
    }

    private void handleSulfurasItem(Item item) {
        // Empty
    }

    // Other commands
    private void decreaseQualityByOne(Item item) {
        item.quality = item.quality - 1;
    }

    private void decreaseSellInByOne(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    private void increaseQualityByOne(Item item) {
        item.quality = item.quality + 1;
    }

    // Queries
    private boolean isOfAgedBrieCategory(Item item) {
        return item.name.equals("Aged Brie");
    }

    private boolean isOfBackstagePassesCategory(Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isOfSulfurasCategory(Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    private boolean qualityIsNotMoreThen50(Item item) {
        return item.quality < 50;
    }

    private boolean qualityIsNotNegative(Item item) {
        return item.quality > 0;
    }

    private boolean sellByDateHasPassed(Item item) {
        return item.sellIn < 0;
    }

    private boolean sellIn5DaysOrLess(Item item) {
        return item.sellIn <= 5;
    }

    private boolean sellIn10DaysOrLess(Item item) {
        return item.sellIn <= 10;
    }

}