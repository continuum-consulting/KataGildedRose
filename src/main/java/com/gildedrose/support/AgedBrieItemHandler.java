package com.gildedrose.support;

import com.gildedrose.Item;

import static com.gildedrose.support.ItemCommand.decreaseSellInByOne;
import static com.gildedrose.support.ItemCommand.increaseQualityByOne;
import static com.gildedrose.support.ItemQuery.qualityIsNotMoreThen50;
import static com.gildedrose.support.ItemQuery.sellByDateHasPassed;

public class AgedBrieItemHandler extends AbstractItemHandler {
    AgedBrieItemHandler(Item item) {
        super(item);
    }

    @Override
    public void doHandleItem() {
        if (qualityIsNotMoreThen50(item())) {
            increaseQualityByOne(item());
        }

        decreaseSellInByOne(item());

        if (sellByDateHasPassed(item())) {
            if (qualityIsNotMoreThen50(item())) {
                increaseQualityByOne(item());
            }
        }
    }
}
