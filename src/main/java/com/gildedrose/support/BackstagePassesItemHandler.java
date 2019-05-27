package com.gildedrose.support;

import com.gildedrose.Item;

import static com.gildedrose.support.ItemCommand.decreaseSellInByOne;
import static com.gildedrose.support.ItemCommand.increaseQualityByOne;
import static com.gildedrose.support.ItemQuery.*;

public class BackstagePassesItemHandler extends AbstractItemHandler {
    BackstagePassesItemHandler(Item item) {
        super(item);
    }

    @Override
    public void doHandleItem() {
        if (qualityIsNotMoreThen50(item())) {
            increaseQualityByOne(item());
            if (sellIn10DaysOrLess(item())) {
                if (qualityIsNotMoreThen50(item())) {
                    increaseQualityByOne(item());
                }
            }
            if (sellIn5DaysOrLess(item())) {
                if (qualityIsNotMoreThen50(item())) {
                    increaseQualityByOne(item());
                }
            }
        }

        decreaseSellInByOne(item());

        if (sellByDateHasPassed(item())) {
            item().quality = 0;
        }
    }
}
